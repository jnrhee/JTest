package com.example.jrhee.test;

import android.util.Log;

import java.util.Arrays;

class InsertionSort {
    private int[] data;
    InsertionSort(int n) {
        data = new int[n];

        for (int i=0;i<data.length;i++) {
            data[i] = (int)(Math.random()*(double)100*(double)n);
        }

        Log.v(Main.DBGSTR, Arrays.toString(data));
    }

    void sort() {
        for (int i=1;i<data.length;i++) {
            int val = data[i];

            int j = i-1;
            if (val < data[j]) {
                while (j>=0 && val < data[j]) {
                    j--;
                }
                int srcPos = j+1;
                System.arraycopy(data,srcPos,data,srcPos+1,i-srcPos);
                data[srcPos] = val;
            }
        }

        Log.v(Main.DBGSTR, "--------- Insertion sort ----------");
        Log.v(Main.DBGSTR, Arrays.toString(data));
    }
}