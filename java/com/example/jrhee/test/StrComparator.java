package com.example.jrhee.test;

import java.util.Comparator;

class StrComparator implements Comparator <StrComparator> {
    public String surname;
    public String givenname;

    StrComparator(String a, String b) {
        surname = a;
        givenname = b;
    }

    @Override
    public int compare(StrComparator a, StrComparator b) {
        int ret = a.surname.compareToIgnoreCase(b.surname);

        if (ret == 0)
            ret = a.givenname.compareToIgnoreCase(b.givenname);

        return ret;
    }
}