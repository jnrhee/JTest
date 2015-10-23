package com.example.jrhee.test;

class Node {
    int val;
    int level;
    Node left;
    Node right;
    Node next;

    Node (int v) {
        val = v;
        level = 0;
        next = left = right = null;
    };
}