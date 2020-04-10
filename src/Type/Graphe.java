package Type;

import java.util.ArrayList;
import java.util.List;

public class Graphe {
    protected List<Sommet> sommets;
    protected List<Arc> arcs;

    public Graphe(){
        this.sommets = new ArrayList<Sommet>();
        this.arcs = new ArrayList<Arc>();
    }

    public Graphe(List<Arc> arcs) {
        this.arcs = arcs;
        this.sommets = new ArrayList<Sommet>();

        // Pour chaque arête de la liste on construit le nouveau graphe
        for (Arc a : arcs) {
            // Si l'origine d'une des arêtes est déja présente, inutile de la
            // réajouter
            if (!this.sommets.contains(a.getOrigine()))
                this.sommets.add(a.getOrigine());
            // Si l'arrivée d'une des arêtes est déja présente, inutile de la
            // réajouter
            if (!this.sommets.contains(a.getArrivee()))
                this.sommets.add(a.getArrivee());
            // Ajout de l'arc
        }
    }

    public String toString() {
        String retour = "";
        retour += "Nombre d'arêtes : " + this.arcs.size() + "\n";
        retour += "Nombre de sommets : " + this.sommets.size() + "\n";
        return retour;
    }

    public void ajoutSommet(Sommet s) {
        this.sommets.add(s);
    }

    public List<Arc> getArc() {
        return this.arcs;
    }

    public List<Sommet> getSommets() {
        return this.sommets;
    }
    
    public List<Sommet> getSommetsClone() {
    	List<Sommet> s = this.getSommets();
        List<Sommet> s2 = new ArrayList<Sommet>();
        for (Sommet sommet : s) {
			s2.add(sommet);
		}
        return s2;
    }

    public void ajoutArc(Arc a) {
        this.arcs.add(a);
    }

}
