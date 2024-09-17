package com.lvwanjie.myapplication.kotlinTest.testAlgorithm

object TwoStrCompareKt {
    @JvmStatic
    fun main(args: Array<String>) {
        println(compare("abc1", "abc"))
    }

    fun compare(str1: String?, str2: String?): Boolean {
        if (str1 == null || str2 == null) {
            return false
        }
        val c1 = str1.toCharArray()
        val c2 = str2.toCharArray()
        return isContain(c1, c2) || isContain(c2, c1)
    }

    fun isContain(c1: CharArray, c2: CharArray): Boolean {
        var isContain = true
        for (i in c1.indices) {
            val temp = c1[i]
            var tempHasEquals = false
            for (j in c2.indices) {
                if (temp == c2[j]) {
                    tempHasEquals = true
                    break
                }
            }
            if (!tempHasEquals) {
                isContain = false
                break
            }
        }
        return isContain
    }
}
