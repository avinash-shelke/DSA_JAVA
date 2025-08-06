package com.dsa.questions.potd.utils;


public class QNode {
    public int val;
    public QNode next;
    public QNode random;

    public QNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}