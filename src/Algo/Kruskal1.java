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
    	Sommet s1 = a.getArrivee(); // on recupere les deux sommets des extrémites de l'arête
    	Sommet s2 = a.getOrigine();
    	Set<Sommet> set = null;
    	Set<Sommet> set1 = null;
    	Set<Sommet> set2 = null;
    	int i1 = 0;
    	int i = 0;
    	boolean find = false;
    	while(!find && i < this.connexes.size()) { // tant qu'on pas trouve les graphes dans lesquels sont les deux sommets (s1 et s2)
    		set = this.connexes.get(i); // on donne assigne le ieme graphe à set
    		if(set.contains(s1) || set.contains(s2)) { // si le graphe contient l'un des deux sommets
    			if(set1 == null) { // si le set1 n'a pas encore de valeur
    				set1 = set; // set1 prend la valeur de l'ensemble
    				i1 = i; // et on enregistre l'indice de l'ensemble 
    			}
    			else { // sinon on a deja set1
    				set2 = set; // donc set2 prend la valeur de l'ensemble
    				find = true; // et on a donc trouvé les deux graphes dans lesquels qont s1 et s2
    			}
    		}
    		i++;
    	}
    	if(set1 == null) { // si les deux sommets sont dans aucun ensemble
    		set = new HashSet<Sommet>(); // on cree un nouvel ensemble qui represente un graph connexes
    		set.add(s1); // dans lequel on ajoute les deux sommets
    		set.add(s2);
    		this.connexes.add(set); // on ajoute le graphe connexes dans la liste de graphes connexes
    	}
    	else if (set2 == null) {
			if(this.connexes.get(i1).contains(s1) && this.connexes.get(i1).contains(s2)){ // si les deux sommets sont deja dans le même graphe
				return true; // on return true est le programme s'arrete la 
			}
			else if (this.connexes.get(i1).contains(s2)) { // si il y a uniquement le sommet d'origine de l'arc dans l'ensemble 1
				this.connexes.get(i1).add(s1); // on ajoute le sommet d'arrivé de l'arc
			}
			else {
				this.connexes.get(i1).add(s2); // sinon on ajoute le sommet d'origine de l'arc
			}
		}
    	else {
    		for (Sommet sommet : set2) {// pour tout les sommets du deuxieme ensemble
				if(set1.contains(sommet)) {  // si l'un des sommets du set2 est dans aussi l'ensemble 1 
					return true; // on return true et le programme s'arrete la
				}
				else { // sinon on ajout le sommet à l'ensemble 1
					set1.add(sommet);
				}
			}
    		this.connexes.remove(i1); // on enlève les deux anciens graphes connexes
    		this.connexes.remove(set2);
    		this.connexes.add(set1); // et on ajoute le nouveau graphe qui est la fusion des deux anciens graphes
    	}
    	return false; // si on arrive jusqu'ici c'est qu'il n'y a pas de cycle
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
