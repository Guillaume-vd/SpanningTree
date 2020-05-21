package Algo;

import Autre.ComparePoidsCroissant;
import Type.Arc;
import Type.Graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal1 {
	private List<Arc> arbre;
    private int poidsTotal;

    public Kruskal1(Graphe graphe){
    	this.poidsTotal = 0; // On initialise le poids de l'arbre à 0
    	List<Arc> ListeArc = graphe.getArc(); //  On recupère les arcs du graphe
    	graphe.removeVoisins(); // On enleve touts les arcs du graphe
        this.arbre = new ArrayList<Arc>(); // On crée une liste d'arc qui représentera l'arbre
        Arc ArcAjout;
        int i;
        Collections.sort(ListeArc, new ComparePoidsCroissant()); // On tri la liste d'arcs dans l'ordre croissants de poids
        this.arbre.add(ListeArc.get(0)); // on ajoute l'arête avec le plus petit poids à l'arbre
        ListeArc.get(0).getArrivee().ajouterVoisin(ListeArc.get(0).getOrigine()); // on ajoute la connexion entre 
        ListeArc.get(0).getOrigine().ajouterVoisin(ListeArc.get(0).getArrivee()); // les deux sommets de l'arête
        this.poidsTotal += ListeArc.get(0).getValeur(); // incremente le poids de l'abre par le poids de l'arête
        for(i = 1; this.arbre.size() < graphe.getSommets().size() - 1; i++) { // boucle jusqu'à avoir n - 1 d'arêtes
        	ArcAjout = ListeArc.get(i); // on stock le ième arc dans la variable arcAjout
            if(!graphe.contientCycle(ArcAjout)) { // Si le graph ne contient pas de cycle malgré l'arc ajouter
            	this.arbre.add(ArcAjout); // on ajoute l'arc à l'abre
            	this.poidsTotal += ArcAjout.getValeur(); // on incremente le poids de l'abre par le poids de l'arête
            }
        }
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
