package com.example.jrhee.test;

import android.util.Log;

public class B1 extends A1{

    void test() {
        int x = super.protVal;
    }
    void printName() {
        Log.v(Main.DBGSTR, "normal - B1 base class....");
    }

    static void printNameStatic() {
        Log.v(Main.DBGSTR, "static - B1 base class....");
    }
}