package com.company;

/*
Evgeniya Zhukova
ID: 101239316
Feb 14, 2020
*/

public class Node {

    // declaration of variables
    public int data;
    public Node next;
    public Node prev;

    // constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}