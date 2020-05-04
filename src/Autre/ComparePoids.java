package Autre;

import Type.Arc;

import java.util.Comparator;

public class ComparePoids implements Comparator<Arc> {

    public int compare(Arc s1, Arc s2) {
        if (s1.getValeur() > s2.getValeur()){ return 1; }
        else if (s1.getValeur() < s2.getValeur()){ return -1; }
        return 0;
    }

}
