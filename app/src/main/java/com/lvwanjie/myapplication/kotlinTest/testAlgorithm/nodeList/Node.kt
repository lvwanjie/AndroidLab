package com.lvwanjie.myapplication.kotlinTest.testAlgorithm.nodeList

class Node(var value:Int){
    var next: Node? = null


}

fun createNode(array: Array<Int>): Node?{
    var node: Node? = null
    var nodeHead: Node? = null
    for(i in array.indices){
        if(node == null){
            node = Node(array[i])
            nodeHead = node
        }else{
            node.next = Node(array[i])
            node = node.next
        }
    }
    return nodeHead
}

fun printNode(node: Node?){
    var curNode: Node? = node
    var str = ""
    while (curNode != null){
        if(curNode.next != null){
            str += "${curNode.value} ->"
        }else{
            str += "${curNode.value}"
        }
        curNode = curNode.next
    }
    println(str)
}