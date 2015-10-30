package com.example.jrhee.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Main extends AppCompatActivity {
    static final String DBGSTR = "JTEST";
    
    private EditText mInText;
    private TextView mOutText;

    private HashSet<Integer> hs = new HashSet<Integer>();
    private HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        boolean ret = hs.add(2);
        Log.v(DBGSTR, "ret = "+ret);
        ret = hs.add(2);
        Log.v(DBGSTR, "ret = "+ret);
        ret = hs.add(3);
        Log.v(DBGSTR, "ret = "+ret);
        ret = hs.add(4);
        Log.v(DBGSTR, "ret = "+ret);

        String outs = "";

        Iterator<Integer> it = hs.iterator();

        while (it.hasNext())
            outs += " "+it.next();

        Log.v(DBGSTR, outs);

        hm.put(1, 11);
        hm.put(2, 11);
        hm.put(3, 12);
        hm.put(4, 13);
        Collection<Integer> co = hm.values();

        outs = "";
        it = co.iterator();
        while (it.hasNext())
            outs += " "+it.next();
        Log.v(DBGSTR, outs);

        Permute pm = new Permute();
        pm.printAllPermute();

        mInText = (EditText) findViewById(R.id.textInput);
        mOutText = (TextView) findViewById(R.id.textOutput);

        mInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInText.setText("");
                mOutText.setText("");
            }
        });

        A1 a1 = new A1();
        a1.protVal = 10;
        B1 b1 = new B1();
        b1.protVal = 20;

        T9 t9 = new T9();
        int[] in = {2,3};
        ArrayList<String> as = t9.printStrings(in);
        Log.v(Main.DBGSTR, Arrays.toString(as.toArray()));


        Nodes nlist = new Nodes();
        for (int i=0;i<17;i++) {
            //Node n = new Node((int)(Math.random()*100));
            Node n = new Node(i);
            nlist.insert2(n);
            Log.v(DBGSTR, "----------------------");
        }

        Log.v(DBGSTR, "is Tree balaneced?   " + nlist.isTreeBalanced(nlist.rootNode));
        nlist.preOrderPrint();
        nlist.inOrderPrint();
        nlist.postOrderPrint();
        nlist.getTreeLength();
        nlist.getTreeLength2();
        Log.v(DBGSTR, "----------------------");
        nlist.BFSearchPrint();

        MergeSort ms = new MergeSort(16);
        ms.sort();

        ComboStr cs = new ComboStr("ABCD");
        cs.printUniqueStr();
        cs.printUniqueStr2();

        double lastTime = System.currentTimeMillis();
        HeapSort hs = new HeapSort(100);
        hs.sort(true);
        hs.sort(false);
        Log.v(Main.DBGSTR, "heap sort time = " + ((System.currentTimeMillis() - lastTime) / (double) 1000));

        InsertionSort is = new InsertionSort(16).ext1(10).ext2(16);
        Log.v(Main.DBGSTR, "v1 = "+is.getVar(0)+"  v2 = "+is.getVar(1));
        is.sort();

        StrComparator[] scl = {new StrComparator("Rhee", "Joon"),
                new StrComparator("Kim", "Mike"),
                new StrComparator("Lee", "Robert"),
                new StrComparator("Rhee", "Abc"),
                new StrComparator("Rhee", "Moon"),
                new StrComparator("Kim", "Albert"),
                new StrComparator("Rhee", "Joo")};

        Arrays.sort(scl, new StrComparator("", ""));
        for (StrComparator sc : scl)
            Log.v(Main.DBGSTR, "Name:"+sc.surname+", "+sc.givenname);

        //ClassicSingleton csn = ClassicSingleton.getInstance();
        ClassicSingleton csn = ClassicSingleton.INST;
        Log.v(Main.DBGSTR, "singleton val = "+csn.getVal());

        Fib fb = new Fib(10);

        //lastTime = System.currentTimeMillis();
        //int n = fb.compute(0);
        //Log.v(Main.DBGSTR, "Fib time = " + ((System.currentTimeMillis() - lastTime) / (double) 1000)+  "    result = "+n);
        lastTime = System.currentTimeMillis();
        int n = fb.compute(1);
        Log.v(Main.DBGSTR, "Memory Fib time = " + ((System.currentTimeMillis() - lastTime) / (double) 1000)+  "    result = "+n+"  memory hit cnt= "+fb.mHit);

        lastTime = System.currentTimeMillis();
        n = fb.compute(2);
        Log.v(Main.DBGSTR, "Loop Fib time = " + ((System.currentTimeMillis() - lastTime) / (double) 1000)+  "    result = "+n);

        String str = "Joe Smith Mike";
        String strClone = "";
        for (int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            strClone += c;
        }
        Log.v(Main.DBGSTR, "Name = " + strClone);

        String[] ss = strClone.split(" ");
        for (String s : ss) {
            Log.v(Main.DBGSTR, "Name Array = " + s);
        }

        strClone = strClone.replace(" ", "");
        Log.v(Main.DBGSTR, "Name = " + strClone);

        HashMap<Integer, String> hm = new HashMap();
        boolean col1 = (hm.put(1, "Hi")!=null);
        boolean col2 = (hm.put(1, "Joon")!=null);

        Log.v(Main.DBGSTR, "Hash map = " + hm.get(1) + " " + hm.get(1) + "   collision1=" + col1 + "  2=" + col2);

        StringBuffer sbuf = new StringBuffer("Joon Rhee");
        sbuf.insert(4, " is first name, ");
        sbuf.append(" is last name");
        Log.v(Main.DBGSTR, "StringBuffer = " + sbuf);

        Prime pr = new Prime <Integer>();
        pr.print(100);
        String ssss = (String)pr.printType("what");
        Log.v(Main.DBGSTR, "Prime print type = "+ssss);

        /*
        Object obj = new Object();
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        String swaps = "ABCDE FGHI JKLMNOP";
        char[] ca = swaps.toCharArray();
        for (int i=0;i<ca.length/2;i++) {
            char tmp = ca[i];
            ca[i] = ca[ca.length-1-i];
            ca[ca.length-1-i] = tmp;
        }
        String afterSwaps = new String(ca);
        Log.v(Main.DBGSTR, "Swap string : "+swaps+" => "+afterSwaps);

        //BinaryTree bt = new BinaryTree(new int[] {5, 4, 2, 10, 11, 14, 15, 19, 8, 1});
        BinaryTree bt = new BinaryTree(new int[] {10, 5, 15, 1, 7, 12, 18});
        bt.inOrderPrint();
        Log.v(Main.DBGSTR, "Is BST = "+bt.isBST());

                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOutText.setText(mInText.getText());
            }
        });

        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
