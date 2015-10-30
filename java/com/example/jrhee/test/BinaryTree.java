package com.example.jrhee.test;

import android.util.Log;

import java.util.LinkedList;

class BinaryTree {
    private Node head;
    private LinkedList<Node> mQueue = new LinkedList<Node>();

    BinaryTree(int[] data) {
        for (int i=0;i<data.length;i++) {
            insertNode(data[i]);
        }
    }

    boolean isBST() {
        return checkBST(head, 0, -1);
    }

    private boolean checkBST(Node p, int ppval, int dir) {
        if (p == null)
            return true;

        if (p.left != null && p.left.val >= p.val)
            return false;
        if (p.right != null && p.right.val <= p.val)
            return false;

        if (dir == 0 && p.right != null && p.right.val >= ppval)
            return false;
        if (dir == 1 && p.left != null && p.left.val <= ppval)
            return false;

        return checkBST(p.left, p.val, 0) && checkBST(p.right, p.val, 1);
    }

    private void insertNode(int v) {
        if (head == null) {
            head = new Node(v);
        } else {
            Node n = findNextAvailableParent();
            Node child = new Node(v);
            if (n.left == null)
                n.left = child;
            else
                n.right = child;
        }
    }

    private Node mNext;
    private boolean mNextFound;
    private Node findNextAvailableParent() {
        mQueue.clear();
        mQueue.add(head);
        mNext = null;
        mNextFound = false;

        findNextAvailableParentRecursion();

        return mNext;
    }

    private void findNextAvailableParentRecursion() {
        if (mNextFound)
            return;

        Node p = mQueue.remove();

        if (p == null)
            return;

        mNext = p;
        if (p.left == null || p.right == null) {
            mNextFound = true;
            return;
        }

        if (p.left != null)
            mQueue.add(p.left);
        if (p.right != null)
            mQueue.add(p.right);
        findNextAvailableParentRecursion();
    }

    private String out;
    void inOrderPrint() {
        out = "";
        inOrderPrintSub(head);
        Log.v(Main.DBGSTR, "BT - inOrder = " + out);
    }

    private void inOrderPrintSub(Node root) {
        if (root == null)
            return;

        inOrderPrintSub(root.left);
        out += " "+root.val;
        inOrderPrintSub(root.right);
    }
}