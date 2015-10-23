package com.example.jrhee.test;

import android.util.Log;

import java.util.ArrayList;

class Nodes {
    private Node target;
    private boolean found;
    private ArrayList<Node> list = new ArrayList<Node>();
    private int dist;
    private int distRecord;
    private Node childNode;

    Nodes () {
    }

    int getTreeLength() {
        Node root = list.get(0);
        dist = distRecord = 1;
        childNode = root;

        measureTreeLength(root);
        Log.v(Main.DBGSTR, "max-dist = "+distRecord);
        return dist;
    }

    private void measureTreeLength (Node parent) {
        if (parent == null)
            return;

        dist++;
        if (parent.right == null && parent.left == null) {
            if (dist > distRecord) {
                childNode = parent;
                distRecord = dist;
            }
        } else {
            if (parent.left != null) {
                measureTreeLength(parent.left);
                dist--;
            }

            if (parent.right != null) {
                measureTreeLength(parent.right);
                dist--;
            }
        }
    }

    private Node rootNode;
    void insert2(Node n) {
        if (rootNode == null) {
            rootNode = n;
            return;
        }

        Node child = findFirstAvailableChild(rootNode);

        if (child.left == null)
            child.left = n;
        else
            child.right = n;
    }

    private Node findFirstAvailableChild(Node parent) {
        queue(parent);
        return findFirstAvailableChildSub();
    }

    private Node findFirstAvailableChildSub() {
        Node parent = dequeue();
        if (parent.left == null || parent.right == null)
            return parent;
        
        queue(parent.left);
        queue(parent.right);
        return findFirstAvailableChildSub();
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

