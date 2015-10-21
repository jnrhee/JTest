package com.example.jrhee.test;

import android.util.Log;

abstract class MyAbstractClass {
    static final int VAL = 100;

    void printName() {
        Log.v(Main.DBGSTR, "non-Abstract function - MyAbstractClass");
    }

    abstract void printNameAbstract();
}