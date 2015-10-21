package com.example.jrhee.test;

import android.util.Log;

import java.util.ArrayList;

class Nodes {
    private Node target;
    private boolean found;
    private ArrayList<Node> list = new ArrayList<Node>();

    Nodes () {
    }

    void insert(Node n) {
        if (n == null) {
            //throw new RuntimeException();
            return;
        }

        list.add(n);

        Node[] nl = list.toArray(new Node[list.size()]);

        int pos = nl.length-1;

        if (pos > 0) {
            int parentPos = (pos - 1) / 2;
            if (pos % 2 == 1)
                nl[parentPos].left = n;
            else
                nl[parentPos].right = n;
        }

        int level = 0;
        int i = 0;
        while (i < nl.length) {
            String str = "";
            while (i< Math.pow(2, level) && i < nl.length) {
                str += " "+nl[i].val;
                i++;
            }

            level++;
            Log.v(Main.DBGSTR, str);
        }
    }

    private String out;
    void preOrderPrint() {
        out = "";
        preOrderPrintSub(list.get(0));
        Log.v(Main.DBGSTR, " preOrder = " + out);
    }

    private void preOrderPrintSub(Node root) {
        if (root == null)
            return;

        out += " "+root.val;
        preOrderPrintSub(root.left);
        preOrderPrintSub(root.right);
    }

    void inOrderPrint() {
        out = "";
        inOrderPrintSub(list.get(0));
        Log.v(Main.DBGSTR, " inOrder = " + out);
    }

    private void inOrderPrintSub(Node root) {
        if (root == null)
            return;

        preOrderPrintSub(root.left);
        out += " "+root.val;
        preOrderPrintSub(root.right);
    }

    void postOrderPrint() {
        out = "";
        postOrderPrintSub(list.get(0));
        Log.v(Main.DBGSTR, " postOrder = " + out);
    }

    private void postOrderPrintSub(Node root) {
        if (root == null)
            return;

        preOrderPrintSub(root.left);
        preOrderPrintSub(root.right);
        out += " "+root.val;
    }
}

