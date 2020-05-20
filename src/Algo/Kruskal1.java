package Algo;

import Autre.ComparePoids;
import Autre.FormeCycle;
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
        this.listeArcs = new ArrayList<Arc>();
        List<Arc> ListeArc = graphe.getArc();
        Arc ArcAjout;
        int i;
        Collections.sort(ListeArc, new ComparePoids());
        this.listeArcs.add(ListeArc.get(0));
        this.poidsTotal += ListeArc.get(0).getValeur();
        for(i = 1; i  < ListeArc.size(); i++) {
        	ArcAjout = ListeArc.get(i);
            if(!FormeCycle.FC(this.listeArcs, ArcAjout)) {
            	this.listeArcs.add(ArcAjout);
            	this.poidsTotal += ArcAjout.getValeur();
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
