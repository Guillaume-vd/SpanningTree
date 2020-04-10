package Autre;

import Type.Sommet;

import java.util.Comparator;

public class ComparePoid implements Comparator<Sommet> {

    public int compare(Sommet s1, Sommet s2) {
        if (s1.getPoid() > s2.getPoid()){ return 1; }
        else if (s1.getPoid() < s2.getPoid()){ return -1; }
        return 0;
    }

}
