package com.example.jrhee.test;

/**
 * Created by rhee on 10/12/15.
 */
public class MySearch {

    private static int[] a;
    private static int v;
    private static int ret;

    static int quickSearch(int[] array, int val) {
        if (array == null)
            return -1;

        a = array;
        v = val;

        ret = -1;
        quickSearchSub(0, a.length - 1);
        return ret;
    }

    private static void quickSearchSub(int l, int r) {
        if (l > r) {
            return;
        }

        int idx = (l+r)/2;
        if (a[idx] == v) {
            ret = idx;
            return;
        }

        quickSearchSub(l, idx-1);
        quickSearchSub(idx+1, r);
    }

    static int findSmallest(int[] array) {
        if (array == null)
            return -1;

        a = array;
        if (a.length == 1)
            return a[0];

        int l = 0;
        int r = 1;
        int val = a[0];

        while (r < a.length) {
            if (a[r] < a[l]) {
                val = a[r];
                break;
            }
            l++;
            r++;
        }

        return val;
    }

    static void quickSort(int[] array) {
        if (array == null)
            return;

        a = array;
        qsSub(0, a.length - 1);
    }

    static private void qsSub(int l, int r) {
        if (l >= r)
            return;

        int idx = qsPartition(l, r);

        qsSub(l, idx-1);
        qsSub(idx+1, r);
    }

    static private int qsPartition(int l, int r) {
        int val = a[r];

        while (true) {
            while (l < r && a[l] < val) {
                l++;
            }

            while (l < r && a[r] > val) {
                r--;
            }

            if (l == r)
                return l;

            if (a[l] == a[r])
                l++;
            else
                swap(l, r);
        }
    }

    static void swap (int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
