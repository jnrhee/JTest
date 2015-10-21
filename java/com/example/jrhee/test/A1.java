package com.example.jrhee.test;

import android.util.Log;

public class A1 {
    private int val;

    A1 () {
        val = 10;
    }

    int getVal() {
        return val;
    }

    void printName() {
        Log.v(Main.DBGSTR, "normal - A1 base class....");
    }

    static void printNameStatic() {
        Log.v(Main.DBGSTR, "static - A1 base class....");
    }
}