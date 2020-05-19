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
    
    public boolean estConnexe(Arc c) {
    	c.getOrigine().enleverVoisin(c.getArrivee());
    	c.getArrivee().enleverVoisin(c.getOrigine());
    	List<Sommet> s = this.getSommetsClone();
    	List<Sommet> res = parcour(new ArrayList<Sommet>(), c.getOrigine());
    	boolean fini = false;
    	while(!fini || !s.isEmpty()) {
    		if(!res.contains(s.remove(0))) {
    			fini = true;
    		}
    	}
    	if(fini) {
    		c.getOrigine().ajouterVoisin(c.getArrivee());
    		c.getArrivee().ajouterVoisin(c.getOrigine());
    	}
    	return !fini;
    }
    
    public List<Sommet> parcour(List<Sommet> l, Sommet s){
    	List<Sommet> voisins = s.getVoisins();
    	List<Sommet> res;
    	int i = 0;
    	l.add(s);
    	while(i < voisins.size()) {
    		if(l.contains(voisins.get(i))) {
    			voisins.remove(i);
    		}
    		else {
    			res = parcour(l, voisins.get(i));
    			while(!res.isEmpty()) {
    				if(l.contains(res.get(0))) {
    					res.remove(0);
    				}
    				else {
    					l.add(res.remove(0));
    				}
    			}
    			i++;
    		}
    	}
    	return l;
    }
}
