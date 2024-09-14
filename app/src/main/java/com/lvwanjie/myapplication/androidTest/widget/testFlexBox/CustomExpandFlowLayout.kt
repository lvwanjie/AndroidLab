package com.lvwanjie.myapplication.androidTest.widget.testFlexBox

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.lvwanjie.myapplication.R
import kotlin.math.max

class ExpandFlowLayout@JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet?= null,
    def:Int = 0
): LinearLayout(context,attributes,def) {

    companion object{
        const val TAG = "CustomExpandFlow.kt"
    }
    private var lastView:View? = null
    private var expandableLine = -1;
    private var maxLine = -1;
    private var tabSpace  = 0
    private var lineSpace = 0
    private var isClose = true
    private var expandViewShow = true

    init {
        val typedArray = context.obtainStyledAttributes(attributes, R.styleable.expand_flow_layout);
        tabSpace = typedArray.getDimension(R.styleable.expand_flow_layout_tab_space,0f).toInt();
        lineSpace = typedArray.getDimension(R.styleable.expand_flow_layout_line_space,0f).toInt()
        expandableLine = typedArray.getInteger(R.styleable.expand_flow_layout_expand_line,-1).toInt()
        typedArray.recycle()
    }

    fun setLastView(view: View){
        removeView(lastView)
        this.addView(view)
        this.lastView = view
    }

    fun setExpand(expand:Boolean){
        isClose = !expand
        requestLayout()
        invalidate()
    }

    fun isExpand():Boolean{
        return !isClose
    }

    fun toggle(){
        isClose = !isClose
        requestLayout()
        invalidate()
    }

    fun setExpandViewShow(show:Boolean){
        expandViewShow = show
        requestLayout()
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val spaceWidth = MeasureSpec.getSize(widthMeasureSpec)
        val leftStart = paddingLeft
        val rightEnd = spaceWidth - paddingEnd
        val topStart = paddingTop
        var curLeft = leftStart
        var curTop = topStart
        var lineCount = 1
        var curLineHeight = 0
        var lastLineStartIndex = 0
        var lastLineEndIndex = 0
        var lineStartIndex = 0
        var lastLineTop = 0
        for(i in 0 until childCount) {
            val curView = getChildAt(i)
            measureChild(curView,widthMeasureSpec,heightMeasureSpec)
            if (curView == lastView) {
                continue
            }
            //换行
            if (rightEnd - curLeft < (curView.measuredWidth)) {
                //设置 上一行 item 的index 范围
                lastLineStartIndex = lineStartIndex
                lineStartIndex = i
                lastLineEndIndex = i - 1
                //重制left 和 top 位置
                curLeft = leftStart
                lastLineTop = curTop
                curTop += (curLineHeight + lineSpace)
                lineCount++
            }
            if(isOverLine(lineCount)){
                break
            }

            curLineHeight = max(curLineHeight,curView.measuredHeight)
            val childRight = curLeft + curView.measuredWidth
            val childBottom = curTop + curView.measuredHeight
            val rect = Rect(curLeft, curTop, childRight, childBottom)
            curView.setTag(R.id.flow_item_bound,rect)
            curLeft = childRight + tabSpace
        }

        if(lastView != null && expandViewShow){
            // 如果关闭状态 重绘最后一行
            measureChild(lastView,widthMeasureSpec,heightMeasureSpec)
            if(needSetLastViewWithCloseState(lineCount)){
                curLeft = reMeasureLine(lastLineStartIndex, lastLineEndIndex,rightEnd) + tabSpace
                curTop = lastLineTop
            }

            // 设置lastView
            if(needSetLastView(lineCount)){
                val lastViewWidth = lastView?.measuredWidth?:0
                val lastViewHeight = lastView?.measuredHeight?:0
                val lastViewSpaceWidth = lastViewWidth
                if((rightEnd - curLeft) < lastViewSpaceWidth ){
                    curLeft = leftStart
                    curTop += (curLineHeight + lineSpace)
                }
                val rect = Rect(curLeft, curTop, curLeft+lastViewWidth, curTop+lastViewHeight)
                lastView?.setTag(R.id.flow_item_bound,rect)
            }
        } else {
            lastView?.setTag(R.id.flow_item_bound,null)
        }

        // 设置容器大小
        val curHeight = curTop + curLineHeight + paddingBottom
        val widthMode  = MeasureSpec.makeMeasureSpec(spaceWidth,MeasureSpec.AT_MOST)
        val heightMode  = MeasureSpec.makeMeasureSpec(curHeight,MeasureSpec.AT_MOST)
        setMeasuredDimension(widthMode,heightMode)
    }


    private fun reMeasureLine(lineStartIndex:Int,lineEndIndex:Int,rightEnd:Int):Int{
        val lastViewSpaceWidth = (lastView?.measuredWidth?:0) + tabSpace
        var lastShowRect:Rect? = null
        for(i in lineEndIndex downTo lineStartIndex){
            val curView = getChildAt(i)
            val rect = curView.getTag(R.id.flow_item_bound) as Rect
            if((rightEnd - rect.right) > lastViewSpaceWidth){
                lastShowRect = rect
                break
            }
            curView.setTag(R.id.flow_item_bound,null)
        }
        return lastShowRect?.right?:0
    }

    //绘制的总数量是否超过指定行数
    private fun isOverLine(lineCount: Int) :Boolean{
        var isOver = false
        if(isClose){
            isOver = (expandableLine > 0) and (lineCount > expandableLine)
        }else{
            isOver = (maxLine > 0) and (lineCount > maxLine)
        }
        return  isOver
    }


    //总行数超过expand 并且是关闭状态
    private fun needSetLastViewWithCloseState(lineCount:Int):Boolean{
        return (expandableLine > 0) and (lineCount > expandableLine) and (isClose)
    }

    private fun needSetLastView(lineCount:Int):Boolean{
        return (expandableLine > 0) and (lineCount > expandableLine)
    }

    private fun needSetLastViewWithOpenState(lineCount:Int):Boolean{
        return (expandableLine > 0) and (lineCount > expandableLine) and (!isClose)
    }


    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for(i in 0 until childCount) {
            val curView = getChildAt(i)
            val rect:Rect? = curView.getTag(R.id.flow_item_bound) as Rect?
            if(rect != null){
                curView.layout(rect.left,rect.top,rect.right,rect.bottom)
            }else {
                curView.layout(0,0,0,0)
            }
        }
    }


}