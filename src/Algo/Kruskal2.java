package Algo;

import Autre.ComparePoidsDecroissant;
import Autre.FormeCycle;
import Type.Arc;
import Type.Graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal2 {
    private List<Arc> ListeArcsAjouter;
    private int nbArc = 0;
    private int Poidtotal = 0;


    public Kruskal2(Graphe graphe){
        this.ListeArcsAjouter = new ArrayList<>();
        List<Arc> ListeArc = graphe.getArc();
        Arc ArcAjout;
        int i;
        
        Collections.sort(ListeArc, new ComparePoidsDecroissant());
        this.ListeArcsAjouter.add(ListeArc.remove(0));
        for(i = 0; i  < ListeArc.size(); i++) {
        	ArcAjout = ListeArc.get(i);
            if(!FormeCycle.FC(this.ListeArcsAjouter, ArcAjout)) {
            	this.ListeArcsAjouter.add(ArcAjout);
                this.nbArc++;
                //this.Poidtotal += ArcAjout.getPoid();
                this.Poidtotal += ArcAjout.getValeur();
            }
        }
    }

    public List<Arc> getListeArcsAjouter(){
        return this.ListeArcsAjouter;
    }

    public int getNbArc(){
        return this.nbArc;
    }

    public int getPoidtotal(){
    	return this.Poidtotal;
    }
}
