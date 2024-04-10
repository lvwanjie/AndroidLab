package com.lvwanjie.myapplication.kotlinTest.testAlgorithm.sort


fun maoPaoSort(array:Array<Int>){

    for(i in array.indices){
        for(j in 1 until array.size -i){
            if(array[j] < array[j-1]){
                swap(array,j,j-1)
            }
        }


    }
}

fun swap(array: Array<Int>, n:Int, m:Int){
    var f = array[n]
    array[n] = array[m]
    array[m] = f
}

fun main(){
    var array = arrayOf(9,6,8,0,4,1,5,2,3,7,5)
    maoPaoSort(array)
    println(array.toList())
}