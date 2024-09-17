package com.hengchang.testeventbus2;

import com.hengchang.testeventbus2.NodeTest.Node;
import com.hengchang.testeventbus2.NodeTest.TreeTest;

import org.junit.Test;

public class TestTree {

    @Test
    public void testA(){
        Node root = new Node();
        int n = 5;
        TreeTest.createTree(root,n);
    }
}
