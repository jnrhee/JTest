package com.example.jrhee.test;

import android.util.Log;
import java.util.Arrays;

class HeapSort {
    private boolean DBG = false;
    private int[] data;

    HeapSort(int n) {
        data = new int[n];

        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * (double) 100 * (double) n);
        }

        if (DBG) Log.v(Main.DBGSTR, "----------- HEAP data ---------------");
        if (DBG) Log.v(Main.DBGSTR, Arrays.toString(data));
        if (DBG) Log.v(Main.DBGSTR, "----------------------------");
    }

    private int mSize;
    void sort(boolean max) {
        mSize = data.length;
        int pos = 0;
        for (int i=data.length-1;i>0;i--) {
            heaptify(max);
            swap(i, 0);
            mSize--;
        }

        if (DBG) Log.v(Main.DBGSTR, "----------- HEAP sorted data [" +(max?"Max:Low-High":"Min:High-Low")+"] ---------------");
        if (DBG) Log.v(Main.DBGSTR, Arrays.toString(data));
        if (DBG) Log.v(Main.DBGSTR, "----------------------------");
    }

    private void heaptify(boolean max) {
        for (int i=mSize/2;i>=0;i--) {
            if (max)
                maxHeap(i);
            else
                minHeap(i);
        }
    }

    private void maxHeap(int pos) {
        if (pos < 0)
            return;

        int maxIdx = pos;

        int L = getL(maxIdx);
        if (L < mSize && data[maxIdx] < data[L])
            maxIdx = L;

        int R = getR(maxIdx);
        if (R < mSize && data[maxIdx] < data[R])
            maxIdx = R;

        if (maxIdx != pos) {
            swap(maxIdx, pos);
            maxHeap(getParent(maxIdx));
        }
    }

    private void minHeap(int pos) {
        if (pos < 0)
            return;

        int maxIdx = pos;

        int L = getL(maxIdx);
        if (L < mSize && data[maxIdx] > data[L])
            maxIdx = L;

        int R = getR(maxIdx);
        if (R < mSize && data[maxIdx] > data[R])
            maxIdx = R;

        if (maxIdx != pos) {
            swap(maxIdx, pos);
            minHeap(getParent(maxIdx));
        }
    }

    private int getL(int idx) {
        return 2*idx + 1;
    }

    private int getR(int idx) {
        return 2*idx + 2;
    }

    private int getParent(int idx) {
        return (idx + idx%2)/2 - 1;
    }

    private void swap(int x, int y) {
        int tmp = data[x];
        data[x] = data[y];
        data[y] = tmp;
    }
}