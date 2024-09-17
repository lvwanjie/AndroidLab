package com.hengchang.testeventbus2

import com.hengchang.testeventbus2.NodeTest.Node
import com.hengchang.testeventbus2.NodeTest.TreeTest
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testNode() {
        val root: Node<*> = Node<Any?>()
        val n = 5
        TreeTest.createTree(root, n)
    }
}