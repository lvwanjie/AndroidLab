package com.lvwanjie.myapplication.kotlinTest.testAlgorithm.sort



fun quickSort(array: Array<Int>,left:Int, right:Int){
    if(left >= right){
        return
    }
    var flag = array[left]
    var i = left
    var j = right
    var swap:Int
    while (i < j){
        while (i < j && array[j] >= flag){
            j--
        }
        while (i < j && array[i] <= flag){
            i++
        }
        if(i < j){
            swap = array[i]
            array[i] = array[j]
            array[j] = swap
        }
    }
    array[left] = array[i]
    array[i] = flag
    quickSort(array,left,i-1)
    quickSort(array,i+1,right)

}


fun main(){
    var array = arrayOf(0,8,9,5,3,6,4,7,2,1,4)
    println(array.toList())
    quickSort(array,0,array.size-1)
    println(array.toList())
}

fun sort(array: IntArray, left: Int, right: Int) {
    if (left > right) {
        return
    }
    // base中存放基准数
    val base = array[left]
    var i = left
    var j = right
    while (i != j) {
        // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
        while (array[j] >= base && i < j) {
            j--
        }
        // 再从左往右边找，直到找到比base值大的数
        while (array[i] <= base && i < j) {
            i++
        }
        // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
        if (i < j) {
            val tmp = array[i]
            array[i] = array[j]
            array[j] = tmp
        }
    }

    // 将基准数放到中间的位置（基准数归位）
    array[left] = array[i]
    array[i] = base

    // 递归，继续向基准的左右两边执行和上面同样的操作
    // i的索引处为上面已确定好的基准值的位置，无需再处理
    sort(array, left, i - 1)
    sort(array, i + 1, right)
}
