package com.example.jrhee.test;

import android.util.Log;

import java.util.Arrays;

class MergeSort {

    private int[] data;
    MergeSort(int n) {
        data = new int[n];

        for (int i=0;i<data.length;i++) {
            data[i] = (int)(Math.random()*(double)100*(double)n);
        }

        Log.v(Main.DBGSTR, Arrays.toString(data));
    }

    void sort() {
        doSort(0, data.length - 1);

        Log.v(Main.DBGSTR, "--------- merge sort ----------");
        Log.v(Main.DBGSTR, Arrays.toString(data));
    }

    private void doSort(int l, int r) {
        if (l == r)
            return;

        int mid = (l + r)/2;
        doSort(l, mid);
        doSort(mid+1, r);

        merge(l, r);
    }

    private void merge(int l, int r) {
        int size = r - l + 1;
        int mid = (l + r)/2;
        int[] tmp = new int[size];
        int tmpIdx = 0;

        int idx_l = l;
        int idx_r = mid+1;
        boolean pickLeft;
        while (idx_l <= mid || idx_r <= r) {
            if (idx_l > mid)
                pickLeft = false;
            else if (idx_r > r)
                pickLeft = true;
            else {
                if (data[idx_l] < data[idx_r])
                    pickLeft = true;
                else
                    pickLeft = false;
            }

            if (pickLeft)
                tmp[tmpIdx] = data[idx_l++];
            else
                tmp[tmpIdx] = data[idx_r++];
            tmpIdx++;
        }

        for (int i=l;i<=r;i++) {
            data[i] = tmp[i-l];
        }
    }
}