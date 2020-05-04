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
        
        Collections.sort(ListeArc, new ComparePoids());
        this.ListeArcsAjouter.add(ListeArc.remove(0));
        while (ListeArc.size() > 0){
            ArcAjout = ListeArc.remove(0);
            if(!FormeCycle.FC(this.ListeArcsAjouter, ArcAjout)) {
            	this.ListeArcsAjouter.add(ArcAjout);
            }
        }
    }
    
    public List<Arc> getListeArcsAjouter(){
    	return this.ListeArcsAjouter;
    }

}
