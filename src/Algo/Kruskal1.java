package Algo;

import Autre.ComparePoidsCroissant;
import Type.Arc;
import Type.Graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal1 {
	private List<Arc> listeArcs;
    private int poidsTotal;

    public Kruskal1(Graphe graphe){
    	this.poidsTotal = 0;
        this.listeArcs = new ArrayList<>(graphe.getArc());
        Arc arc;
        int i = 0;
        Collections.sort(listeArcs, new ComparePoidsCroissant());
        while(i < listeArcs.size()) {
            arc = listeArcs.get(i);
            if(graphe.estConnexe(arc)) {
            	listeArcs.remove(arc);
                System.out.println(arc.getOrigine().getId()+ " " +arc.getArrivee().getId());
                poidsTotal += arc.getValeur();
            } else {
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
