package Algo;

import Autre.ComparePoidsDecroissant;
import Type.Arc;
import Type.Graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal2 {
    private List<Arc> listeArcs;
    private int poidsTotal;


    public Kruskal2(Graphe graphe){
    	this.poidsTotal = 0;
    	this.listeArcs = new ArrayList<Arc>(graphe.getArc());
        Arc arc;
        int i = 0;
        Collections.sort(listeArcs, new ComparePoidsDecroissant());
        while(i < listeArcs.size()) {
        	arc = listeArcs.get(i);
            if(graphe.estConnexe(arc)) {
            	listeArcs.remove(arc);
            }
            else {
            	this.poidsTotal += arc.getValeur();
            	i++;
            }
        }
    }

    public int getNbArc(){
        return this.getArcs().size();
    }
    
    public List<Arc> getArcs(){
    	return this.listeArcs;
    }

    public int getPoidsTotal(){
    	return this.poidsTotal;
    }
}
