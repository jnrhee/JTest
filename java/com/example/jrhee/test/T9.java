package com.example.jrhee.test;

import android.util.Log;

import java.util.ArrayList;

class T9 {

    private String[][] T9 = {
            {"A", "B", "C"},
            {"D", "E", "F"},
            {"G", "H", "I"},
            {"J", "K", "L"},
            {"M", "N", "O"},
            {"P", "Q", "R", "S"},
            {"T", "U", "V"},
            {"W", "X", "Y", "Z"}
    };

    private int[] input;
    private String word;

    ArrayList<String> printStrings(int[] a) {
        /*
        TODO: need to remove all integer not in 2..9
         */

        ArrayList<String> ret = new ArrayList<String>();
        input = a;
        word = "";
        printS(0, ret);

        return ret;
    }

    private void printS(int inputPos, ArrayList ret) {
        int t9Idx = getT9Idx(input[inputPos]);

        for (int i=0;i<T9[t9Idx].length;i++) {
            word += T9[t9Idx][i];

            if (inputPos == input.length-1) {
                /*
                    TODO: need to add dictionary check and add only if
                    <word> is in dictionary.
                 */
                ret.add(new String(word));
                Log.v(Main.DBGSTR, "STR = "+word);
                word = word.substring(0, word.length()-1);
            }

            if (inputPos < input.length - 1) {
                printS(inputPos+1, ret);
                word = word.substring(0, word.length()-1);
            }
        }
    }

    private int getT9Idx(int val) {
        return val-2;
    }
}