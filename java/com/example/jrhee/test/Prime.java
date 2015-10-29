package com.example.jrhee.test;

import android.util.Log;

import java.util.Arrays;

class Prime <T> {
    void print(int n) {
        int[] set = {2, 3, 5, 7};
        int[] out = new int[n];
        int j = 0;

        for (int i=2;i<=n;i++) {
            int cnt=0;
            for (int div : set) {
                if (i%div == 0)
                    cnt++;
            }
            if (cnt == 0)
                out[j++] = i;
        }

        Log.v(Main.DBGSTR, "Prime = "+ Arrays.toString(out));
    }

    T printType(T input) {
        return input;
    }
}