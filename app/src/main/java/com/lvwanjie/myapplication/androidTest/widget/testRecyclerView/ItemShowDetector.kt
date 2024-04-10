package com.lvwanjie.myapplication.androidTest.widget.testRecyclerView

import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ItemShowDetector(val recyclerView: RecyclerView, val onShow: (position: Int) -> Unit) : RecyclerView.OnScrollListener() {

    /**
     * 可见百分比 0-100
     */
    var visiblePercent = 50

    /**
     * 是否忽略flipping的曝光
     */
    var ignoreFlipping = true

    /**
     * 隐藏后是否需要重新曝光
     */
    var needReshow = false

    companion object{
        const val TAG = "ItemShowDetector.k"
    }

    /**
     * 保存曝光的状态
     */
    var flag: BooleanArray = BooleanArray(0)

    private var isDragging = false

    private val adapter: RecyclerView.Adapter<*> =
        if (recyclerView.adapter == null) throw RuntimeException("recyclerview未设置adapter") else recyclerView.adapter!!

    init {
        //监听滚动监听
        recyclerView.addOnScrollListener(this)

        recyclerView.addOnChildAttachStateChangeListener(object : RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewAttachedToWindow(view: View) {

            }

            //监听item被移除的事件
            override fun onChildViewDetachedFromWindow(view: View) {
                if (needReshow) {
                    recyclerView.getChildLayoutPosition(view).takeIf { it in flag.indices }?.let {
                        flag[it] = false
                    }
                }
            }
        })

        //监控adapter的数据变化
        adapter.registerAdapterDataObserver(DataObserver())

        //检测初始化的曝光
        recyclerView.post {
            flag = BooleanArray(adapter.itemCount)
            doTrace()
        }

    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        isDragging = newState == RecyclerView.SCROLL_STATE_DRAGGING
        if (newState == RecyclerView.SCROLL_STATE_IDLE) doTrace()
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

        if (!ignoreFlipping || isDragging) {
            doTrace()
        }

    }

    /**
     * 清除flag
     */
    fun reset() {
        flag.fill(false)
        doTrace()

    }


    /**
     * 检测是否曝光
     */
    fun doTrace() {

        val layoutManager = recyclerView.layoutManager ?: return
        //获取可见的范围
        val (first, last) = getRange(layoutManager)
        //遍历可见的index
        for (index in first..last) {
            //如果未曝光过并且在认为曝光的阈值内 调用onShow
            if (index in flag.indices &&
                !flag[index] &&
                boundsCheck(layoutManager.findViewByPosition(index))
            ) {
                flag[index] = true
                onShow(index)
            }
        }

    }

    /**
     * 获取view可见的范围
     * 支持三种LayoutManager的判断
     */
    private fun getRange(layoutManager: RecyclerView.LayoutManager): Pair<Int, Int> {
        var first = -1
        var last = -1
        when (layoutManager) {
            is LinearLayoutManager -> {
                first = layoutManager.findFirstVisibleItemPosition()
                last = layoutManager.findLastVisibleItemPosition()
            }
            is GridLayoutManager -> {
                first = layoutManager.findFirstVisibleItemPosition()
                last = layoutManager.findLastVisibleItemPosition()
            }
            is StaggeredGridLayoutManager -> {
                val startPos = IntArray(layoutManager.spanCount)
                val endPos = IntArray(layoutManager.spanCount)
                layoutManager.findFirstVisibleItemPositions(startPos)
                layoutManager.findLastVisibleItemPositions(endPos)
                var start = startPos[0]
                var end = endPos[0]
                for (i in 1 until startPos.size) {
                    if (start > startPos[i]) {
                        start = startPos[i]
                    }
                }
                for (i in 1 until endPos.size) {
                    if (end < endPos[i]) {
                        end = endPos[i]
                    }
                }
                first = start
                last = end
            }
        }
        return first to last
    }

    /**
     * 检查view是否在设置的可见阈值之内
     */
    private fun boundsCheck(view: View?): Boolean {
        if (view == null) return false
        val rect = Rect()

        if (view.getLocalVisibleRect(rect)) {
            val height = view.height.toDouble()
            val width = view.width.toDouble()
            val l = rect.left.toDouble()
            val t = rect.top.toDouble()
            val r = rect.right.toDouble()
            val b = rect.bottom.toDouble()
            Log.i(TAG, "boundsCheck: $l  $t  $r  $b")
            val visiblePercent = when {
                l != 0.0 -> (width - l) / width
                r != width -> r / width
                t != 0.0 -> (height - t) / height
                b != height -> b / height
                else -> 1.0
            } * 100
            return visiblePercent >= this.visiblePercent
        }

        return false
    }

    private inner class DataObserver : RecyclerView.AdapterDataObserver() {

        //所有都改变
        override fun onChanged() {
            flag = BooleanArray(adapter.itemCount)
            doTrace()
        }

        //改变规定的range
        override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
            flag.fill(false, positionStart, positionStart + itemCount)
            doTrace()
        }

        //把form移动到to 移动方法类似冒泡
        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
            if (fromPosition == toPosition) {
                return
            }
            var form = fromPosition
            for (i in IntProgression.fromClosedRange(fromPosition, toPosition, toPosition.compareTo(fromPosition))) {
                val temp = flag[form]
                flag[form] = flag[i]
                flag[i] = temp
                form = i
            }

            doTrace()

        }

        //插入新元素到flag
        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            val newFlag = BooleanArray(itemCount + flag.size)
            System.arraycopy(flag, 0, newFlag, 0, positionStart)
            System.arraycopy(flag, positionStart, newFlag, positionStart + itemCount, flag.size - positionStart)
            flag = newFlag

            doTrace()

        }

        //删除flag中的元素
        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {

            val newFlag = BooleanArray(flag.size - itemCount)
            System.arraycopy(flag, 0, newFlag, 0, positionStart)
            System.arraycopy(flag, positionStart + itemCount, newFlag, positionStart, flag.size - positionStart - itemCount)
            flag = newFlag

            doTrace()
        }

    }

}
