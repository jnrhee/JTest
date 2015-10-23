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
        nlist.preOrderPrint();
        nlist.inOrderPrint();
        nlist.postOrderPrint();
        nlist.getTreeLength();
        Log.v(DBGSTR, "----------------------");
        nlist.BFSearchPrint();

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
