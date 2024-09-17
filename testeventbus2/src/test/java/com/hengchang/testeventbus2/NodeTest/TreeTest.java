package com.hengchang.testeventbus2.NodeTest;

public class TreeTest {


    public static void main(String[] args){
        Node root = new Node();
        int n = 5;
        createTree(root,n);
    }

    public static void createTree(Node root,int n){

        Node leftNode = new Node();
        Node rightNode = new Node();
        root.setLeftChild(leftNode);
        root.setRightChild(rightNode);

        if(n > 0){
            createTree(leftNode,n-1);
            createTree(rightNode,n-1);
        }

    }
}
