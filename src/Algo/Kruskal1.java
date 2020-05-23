package Algo;

import Autre.ComparePoidsCroissant;
import Type.Arc;
import Type.Graphe;
import Type.Sommet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kruskal1 {
	private List<Arc> arbre;
    private int poidsTotal;
    private List<Set<Sommet>> connexes;

    public Kruskal1(Graphe graphe){
    	this.connexes = new ArrayList<Set<Sommet>>();
    	this.poidsTotal = 0; // On initialise le poids de l'arbre à 0
    	List<Arc> ListeArc = graphe.getArc(); //  On recupère les arcs du graphe
        this.arbre = new ArrayList<Arc>(); // On crée une liste d'arc qui représentera l'arbre
        Arc ArcAjout;
        int i;
        Collections.sort(ListeArc, new ComparePoidsCroissant()); // On tri la liste d'arcs dans l'ordre croissants de poids
        Set<Sommet> s = new HashSet<Sommet>(); // On instancie un ensemble de sommet
        s.add(ListeArc.get(0).getArrivee()); // dans lequel on met
        s.add(ListeArc.get(0).getOrigine()); // les deux sommets du premier arc de la liste
        this.connexes.add(s); // on ajoute l'ensemble à la liste 
        this.arbre.add(ListeArc.get(0)); // on ajoute l'arête avec le plus petit poids à l'arbre
        this.poidsTotal += ListeArc.get(0).getValeur(); // incremente le poids de l'abre par le poids de l'arête
        for(i = 1; this.arbre.size() < graphe.getSommets().size() - 1; i++) { // boucle jusqu'à avoir n - 1 d'arêtes
        	ArcAjout = ListeArc.get(i); // on stock le ième arc dans la variable arcAjout
            if(!this.cycle(ArcAjout)) { // Si le graph ne contient pas de cycle malgré l'arc ajouter
            	this.arbre.add(ArcAjout); // on ajoute l'arc à l'abre
            	this.poidsTotal += ArcAjout.getValeur(); // on incremente le poids de l'abre par le poids de l'arête
            }
        }
    }
    
    
    public boolean cycle(Arc a) {
    	Sommet s1 = a.getArrivee();
    	Sommet s2 = a.getOrigine();
    	Set<Sommet> set = null;
    	Set<Sommet> set1 = null;
    	Set<Sommet> set2 = null;
    	int i1 = 0;
    	int i = 0;
    	boolean find = false;
    	while(!find && i < this.connexes.size()) {
    		set = this.connexes.get(i);
    		if(set.contains(s1) || set.contains(s2)) {
    			if(set1 == null) {
    				set1 = set;
    				i1 = i;
    			}
    			else {
    				set2 = set;
    				find = true;
    			}
    		}
    		i++;
    	}
    	if(set1 == null) {
    		set = new HashSet<Sommet>();
    		set.add(s1);
    		set.add(s2);
    		this.connexes.add(set);
    	}
    	else if (set2 == null) {
			if(this.connexes.get(i1).contains(s1) && this.connexes.get(i1).contains(s2)){
				return true;
			}
			else if (this.connexes.get(i1).contains(s2)) {
				this.connexes.get(i1).add(s1);
			}
			else {
				this.connexes.get(i1).add(s2);
			}
		}
    	else {
    		for (Sommet sommet : set2) {
				if(set1.contains(sommet)) {
					return true;
				}
				else {
					set1.add(sommet);
				}
			}
    		this.connexes.remove(i1);
    		this.connexes.remove(set2);
    		this.connexes.add(set1);
    	}
    	return false;
    }
    
    public int getNbArete(){
        return this.getArbre().size();
    }
    
    public List<Arc> getArbre(){
    	return this.arbre;
    }

    public int getPoidsTotal(){
    	return this.poidsTotal;
    }
}
