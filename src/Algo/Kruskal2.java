package Algo;

import Autre.ComparePoid;
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

        Collections.sort(ListeArc, new ComparePoid());
        Collections.reverse(ListeArc);
        this.ListeArcsAjouter.add(ListeArc.remove(0));
        while (ListeArc.size() > 0){
            ArcAjout = ListeArc.remove(0);
            if(!FormeCycle.FC(this.ListeArcsAjouter, ArcAjout)) {
                this.ListeArcsAjouter.add(ArcAjout);
                this.nbArc++;
                this.Poidtotal += ArcAjout.getPoid();
            }
        }
    }

    public List<Arc> getListeArcsAjouter(){
        return this.ListeArcsAjouter;
    }

    public int getNbArc(){
        return this.nbArc;
    }

    public int getPoidtotal(){return this.Poidtotal; }
}
