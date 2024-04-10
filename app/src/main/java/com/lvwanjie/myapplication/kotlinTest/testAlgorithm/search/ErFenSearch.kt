package com.lvwanjie.myapplication.kotlinTest.testAlgorithm.search



fun search(value:Int,array:Array<Int>):Int{

    var lo = 0
    var hi = array.size -1
    while (lo <= hi ){
        var mid = (lo+hi)/2
        var midValue = array[mid]
        if(midValue < value ){
            lo = mid +1
        }else if(midValue > value){
            hi  = mid -1
        }else {
            return mid
        }
    }

    return lo.inv()

}

fun binarySearch(array: IntArray, size: Int, value: Int): Int {
    var lo = 0
    var hi = size - 1
    while (lo <= hi) {
        val mid = lo + hi ushr 1
        val midVal = array[mid]
        if (midVal < value) {
            lo = mid + 1
        } else if (midVal > value) {
            hi = mid - 1
        } else {
            return mid // value found
        }
    }
    return lo.inv() // value not present
}