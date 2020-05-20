package Autre;

import Type.Graphe;
import Type.Sommet;

import java.util.List;

public class Reset {

    public Reset(Graphe graphe){
        List<Sommet> sommetList = graphe.getSommets();
        for (Sommet s:sommetList) {
            s.unmarquer();
        }
    }
}
