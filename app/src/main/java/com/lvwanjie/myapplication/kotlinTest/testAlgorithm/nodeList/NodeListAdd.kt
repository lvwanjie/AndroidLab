package com.lvwanjie.myapplication.kotlinTest.testAlgorithm.nodeList

fun add(node1: Node?, node2: Node?): Node?{
    var curNode1 = node1
    var curNode2 = node2
    var newNode: Node = Node(0)
    var newNodeHead  = newNode
    while (curNode1 != null && curNode2 != null){
        var value1 = curNode1.value
        var value2 = curNode2.value
        newNode.next = Node(value1+value2)
        newNode = newNode.next!!
        curNode2 = curNode2.next
        curNode1 = curNode1.next
    }

    while (curNode1 != null){
        newNode.next = Node(curNode1.value)
        curNode1 = curNode1.next
        newNode = newNode.next!!
    }

    while (curNode2 != null){
        newNode.next = Node(curNode2.value)
        curNode2 = curNode2.next
        newNode = newNode.next!!
    }

    return newNodeHead.next
}


fun main(){
    var node1 = createNode(arrayOf(2,6,5,7))
    var node2 = createNode(arrayOf(3,9,2,4,8,9))
    printNode(node1)
    printNode(node2)
    var newNode = add(node1,node2)
    printNode(newNode)
}