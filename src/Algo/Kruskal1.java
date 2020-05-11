package Algo;

import Autre.ComparePoids;
import Autre.FormeCycle;
import Type.Arc;
import Type.Graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal1 {
	private List<Arc> ListeArcsAjouter;

    public Kruskal1(Graphe graphe){
        this.ListeArcsAjouter = new ArrayList<>();
        List<Arc> ListeArc = graphe.getArc();
        Arc ArcAjout;
        int i;
        Collections.sort(ListeArc, new ComparePoids());
        this.ListeArcsAjouter.add(ListeArc.get(0));
        for(i = 0; i  < ListeArc.size(); i++) {
        	ArcAjout = ListeArc.get(i);
            if(!FormeCycle.FC(this.ListeArcsAjouter, ArcAjout)) {
            	this.ListeArcsAjouter.add(ArcAjout);
            }
        }
    }
    
    public List<Arc> getListeArcsAjouter(){
    	return this.ListeArcsAjouter;
    }

}
