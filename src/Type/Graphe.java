package Type;

import java.util.ArrayList;
import java.util.List;

public class Graphe {
    private List<Sommet> sommets;
    private List<Arc> arcs;

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
    
    public boolean parcourProfondeur(Arc c) {
    	c.getOrigine().enleverVoisin(c.getArrivee());
    	c.getArrivee().enleverVoisin(c.getOrigine());
    	this.explorer(c.getOrigine());
    	boolean connexe = true;
    	for(int i = 0; i < this.getSommets().size(); i++) {
    		if(!(this.getSommets().get(i).estMarque())) {
    			connexe = false;
    		}
    		this.getSommets().get(i).unmarquer();
    	}
    	if(!connexe) {
    		c.getOrigine().ajouterVoisin(c.getArrivee());
    		c.getArrivee().ajouterVoisin(c.getOrigine());
    	}
    	return connexe;
    }
  
    
    public void explorer(Sommet s) {
    	s.marquer();
    	List<Sommet> voisins = s.getVoisins();
    	for(int i = 0; i < voisins.size(); i++) {
    		if(!voisins.get(i).estMarque()) {
    			explorer(voisins.get(i));
    		}
    	}
    }
    
    
    public void removeVoisins() {
    	for(int i = 0; i < this.getSommets().size(); i++) {
    		this.getSommets().get(i).removeVoisins();
    	}
    }
    
    
    public boolean contientCycle(Arc c) {
    	c.getOrigine().ajouterVoisin(c.getArrivee());
    	c.getArrivee().ajouterVoisin(c.getOrigine());
    	c.getOrigine().marquer();
    	boolean cycle = parcourCycle(c.getOrigine(), c.getArrivee());
    	if(cycle) {
    		c.getOrigine().enleverVoisin(c.getArrivee());
        	c.getArrivee().enleverVoisin(c.getOrigine());
    	}
    	for(int i = 0; i < this.getSommets().size(); i++) {
    		this.getSommets().get(i).unmarquer();
    	}
    	return cycle;
    }
    
    public boolean parcourCycle(Sommet arrive, Sommet s) {
    	boolean cycle = false;
    	s.marquer();
    	int i = 0;
    	List<Sommet> voisins = s.getVoisins();
    	while(i < voisins.size() && !cycle) {
    		if(voisins.get(i) != arrive) {
    			if(voisins.get(i).estMarque()) {
    				cycle = true;
    			}
    			else {
    				cycle = parcourCycle(s, voisins.get(i));
    			}
    		}
    		i++;
    	}
    	return cycle;
    }
}
