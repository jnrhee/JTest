package com.example.jrhee.test;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;

class ComboStr {
    private String str;
    private HashSet<String> hs = new HashSet<String>();

    ComboStr(String s) {
        str = s;
    }

    void printUniqueStr() {
        ArrayList<String> al = new ArrayList<>();
        printS(al, str);
        Log.v(Main.DBGSTR, "Combo STR: " + hs.toString());
    }

    private void printS(ArrayList<String> al, String s) {
        hs.add(s);

        if (s.length() == 1)
            return;

        for (int i = 0; i < s.length(); i++) {
            String subs = removePos(s, i);
            printS(al, subs);
        }
    }

    private String removePos(String s, int i) {
        if (i == 0)
            return s.substring(1, s.length());
        else if (i == s.length() - 1)
            return s.substring(0, s.length() - 1);
        else {
            return s.substring(0, i) + s.substring(i + 1, s.length());
        }
    }

    private String word;

    void printUniqueStr2() {
        ArrayList<String> al = new ArrayList<String>();
        word = "";
        printS2(al, 0);
        Log.v(Main.DBGSTR, "Combo STR: " + al.toString());
    }

    private void printS2(ArrayList<String> al, int start) {
        if (start >= str.length())
            return;

        for (int i=start;i<str.length();i++) {
            word += str.substring(i,i+1);
            al.add(word);
            printS2(al, i+1);
            word = word.substring(0, word.length()-1);
        }
    }
}