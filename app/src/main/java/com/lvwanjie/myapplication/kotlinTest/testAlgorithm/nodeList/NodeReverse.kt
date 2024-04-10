package com.lvwanjie.myapplication.kotlinTest.testAlgorithm.nodeList


fun nodeReverse(node:Node?):Node?{
   var curNode:Node? = node
    var preNode:Node? = null
    var nextNode:Node? = null
    while (curNode != null){
        nextNode = curNode.next
        curNode.next = preNode
        preNode = curNode
        curNode = nextNode
    }
    return preNode

}

fun main(){
    var node = createNode(arrayOf(0,8,9,7))
    var newNode = nodeReverse(node)
    printNode(newNode)

}