package com.example.jrhee.test;

class Fib {

    private int num;
    private int[] data;
    int mHit=0;

    Fib (int n) {
        num = n;
        data = new int[num+1];
        for (int i=0;i<data.length;i++)
            data[i] = -1;
    }

    int compute(int which) {
        if (which == 0)
            return get(num);
        else if (which == 1)
            return get2(num);
        else
            return get3(num);
    }

    private int get (int n) {
        if (n <= 1)
            return n;
        else
            return get(n-1)+get(n-2);
    }

    private int get2 (int n) {
        int val;

        if (data[n] != -1) {
            mHit++;
            return data[n];
        }

        if (n <= 1)
            val = n;
        else {
            /*
            data[n-1] = get2(n - 1);
            data[n-2] = get2(n - 2);
            val = data[n-1] + data[n-2];
            */
            val = get2(n-1)+get2(n-2);
        }

        data[n] = val;
        return val;
    }

    private int get3 (int n) {
        int val;
        int p_n1 = 1;
        int p_n2 = 0;

        for (int i=3;i<=n;i++) {
            int tmp = p_n1;
            p_n1 = p_n1+p_n2;
            p_n2 = tmp;
        }

        return p_n1+p_n2;
    }
}