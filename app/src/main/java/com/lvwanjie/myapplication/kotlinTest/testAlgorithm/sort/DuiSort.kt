package com.lvwanjie.myapplication.kotlinTest.testAlgorithm.sort

/**
 * 堆排序
 */



fun heapSort(array: Array<Int>){

    for(i in  (array.size-1)/2 downTo 0){
        adjustHeap(array,i,array.size)
    }

    for(i in array.size-1 downTo 0){
        var temp = array[i]
         array[i] = array[0]
        array[0]  = temp
        adjustHeap(array,0,i)
    }

}

fun adjustHeap(array: Array<Int>, parent:Int,arrayLength:Int){
    var parentIndex = parent
    var temp = array[parentIndex]
    var leftIndex = 2*parentIndex + 1
    var childIndex = leftIndex
    while (childIndex < arrayLength){
        var rightIndex = leftIndex +1
        if(rightIndex < arrayLength && (array[leftIndex] < array[rightIndex]) ){
            childIndex = rightIndex
        }
        if(temp >= array[childIndex]){
            break
        }
        array[parentIndex] = array[childIndex]
        parentIndex = childIndex
        childIndex = 2*parentIndex +1
    }
    array[parentIndex] = temp
}






fun main(){

}