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
        Node root = rootNode;
        dist = distRecord = 0;
        childNode = root;

        measureTreeLength(root);
        Log.v(Main.DBGSTR, "max-dist = "+distRecord);
        return dist;
    }

    int getTreeLength2() {
        int maxHeight =  doGetTreeLength(rootNode);

        Log.v(Main.DBGSTR, "adv max-dist = "+maxHeight);
        return maxHeight;
    }

    int doGetTreeLength(Node parent) {
        if (parent == null)
            return 0;

        return 1 + Math.max(doGetTreeLength(parent.left), doGetTreeLength(parent.right));
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

    Node rootNode;
    void insert2(Node n) {
        if (rootNode == null) {
            rootNode = n;
            return;
        }

        Node child = findFirstAvailableChild(rootNode);

        n.level = child.level+1;
        if (child.left == null)
            child.left = n;
        else
            child.right = n;
    }

    private Node findFirstAvailableChild(Node parent) {
        queueInit(parent);
        return findFirstAvailableChildSub();
    }

    private Node findFirstAvailableChildSub() {
        Node parent = dequeue();
        if (parent == null)
            return null;

        if (parent.left == null || parent.right == null)
            return parent;
        
        queue(parent.left);
        queue(parent.right);
        return findFirstAvailableChildSub();
    }

    private Node qHead;
    private Node qTail;

    private void queueInit(Node root) {
        qHead = qTail = null;
        queue(root);
    }

    private void queue(Node n) {
        if (n == null)
            return;

        if (qHead == null) {
            qHead = qTail = n;
        } else {
            Node tmp = qTail;
            qTail = n;
            tmp.next = qTail;
            qTail.next = null;
        }
    }

    private Node dequeue() {
        Node ret = qHead;

        if (qHead != null) {
            qHead = qHead.next;
            ret.next = null;
        }

        return ret;
    }

    int bfsLevel;
    String bfsStr;
    void BFSearchPrint() {
        bfsLevel = 0;
        bfsStr = "";
        queueInit(rootNode);
        bfs();
        Log.v(Main.DBGSTR, "BFS-" + bfsLevel + " :" + bfsStr);
    }

    private void bfs() {
        Node n = dequeue();

        if (n == null)
            return;

        if (n.level > bfsLevel) {
            Log.v(Main.DBGSTR, "BFS-" + bfsLevel + " :" + bfsStr);
            bfsStr = " "+n.val;
            bfsLevel = n.level;
        } else {
            bfsStr += " "+n.val;
        }

        queue(n.left);
        queue(n.right);

        bfs();
    }

    void insert(Node n) {
        if (n == null) {
            //throw new RuntimeException();
            return;
        }

        list.add(n);
        if (list.size() == 1)
            rootNode = list.get(0);

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
        preOrderPrintSub(rootNode);
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
        inOrderPrintSub(rootNode);
        Log.v(Main.DBGSTR, " inOrder = " + out);
    }

    private void inOrderPrintSub(Node root) {
        if (root == null)
            return;

        inOrderPrintSub(root.left);
        out += " "+root.val;
        inOrderPrintSub(root.right);
    }

    void postOrderPrint() {
        out = "";
        postOrderPrintSub(rootNode);
        Log.v(Main.DBGSTR, " postOrder = " + out);
    }

    private void postOrderPrintSub(Node root) {
        if (root == null)
            return;

        postOrderPrintSub(root.left);
        postOrderPrintSub(root.right);
        out += " "+root.val;
    }

    boolean isTreeBalanced(Node p){
        if (p == null)
            return true;

        if (Math.abs(getHeight(p.left) - getHeight(p.right)) > 1)
            return false;
        else
            return isTreeBalanced(p.left) && isTreeBalanced(p.right);
    }

    private int getHeight(Node p) {
        if (p==null)
            return 0;

        return 1+Math.max(getHeight(p.left), getHeight(p.right));
    }

    private int mDepth;
    private int mStep;

    void createDlink(Node root, int depth) {
        mStep = 0;
        mDepth = depth;

        //Linklist<Node> ret = new LinkList<Node>();

        createDlink(root);
    }

    void createDlink(Node p) {
        if (p == null)
            return;

        if (mDepth == mStep) {
            //ret.add(p);
            return;
        }

        if (p.left != null) {
            mDepth++;
            createDlink(p.left);
            mDepth--;
        }
        if (p.right != null) {
            mDepth++;
            createDlink(p.right);
            mDepth--;
        }
    }
}

