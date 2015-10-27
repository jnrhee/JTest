package com.example.jrhee.test;

public enum ClassicSingleton {
    INST;

    /*
    private static ClassicSingleton instance = null;
    private ClassicSingleton() {
        // make it private so, it can't be instantiated.
    }
    public static ClassicSingleton getInstance() {
        if(instance == null) {
           // instance = new ClassicSingleton();
        }
        return instance;
    }
    */

    private int val = 100;
    int getVal() {
        return val;
    }
}