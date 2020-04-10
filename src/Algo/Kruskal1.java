package Algo;

import Autre.ComparePoid;
import Type.Graphe;
import Type.Sommet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal1 {

    public Kruskal1(Graphe graphe){
        List<Sommet> ListeSommets;
        List<Sommet> ListeSommetsAjouter = new ArrayList<>();

        ListeSommets = graphe.getSommetsClone();
        Collections.sort(ListeSommets, new ComparePoid());

        while (!ListeSommets.isEmpty()){
            Sommet sommet = ListeSommets.get(0);

            ListeSommets.remove(0);

        }

    }

}
