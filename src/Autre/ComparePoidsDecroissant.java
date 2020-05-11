package Autre;

import Type.Arc;

import java.util.Comparator;

public class ComparePoidsDecroissant implements Comparator<Arc> {

    public int compare(Arc s1, Arc s2) {
    	return s2.getValeur() - s1.getValeur();
    }

}
