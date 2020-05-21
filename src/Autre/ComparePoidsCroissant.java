package Autre;

import Type.Arc;

import java.util.Comparator;

public class ComparePoidsCroissant implements Comparator<Arc> {

    public int compare(Arc s1, Arc s2) {
        return s1.getValeur() - s2.getValeur();
    }

}
