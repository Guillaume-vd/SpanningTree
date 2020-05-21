package Algo;

import Autre.ComparePoidsDecroissant;
import Type.Arc;
import Type.Graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal2 {
    private List<Arc> arbre;
    private int poidsTotal;


    public Kruskal2(Graphe graphe){
    	this.poidsTotal = 0; // On initialise le poids de l'arbre à 0
    	this.arbre = new ArrayList<>(graphe.getArc()); // On crée une liste d'arc qui représentera l'arbre
        Arc arc;
        int i = 0; 
        Collections.sort(arbre, new ComparePoidsDecroissant());// On tri la liste d'arcs dans l'ordre decroissants de poids
        while(arbre.size() > graphe.getSommets().size() - 1) {// boucle jusqu'à avoir n - 1 d'arêtes
        	arc = arbre.get(i); //on stock le ième arc dans la variable arcAjout
            if(graphe.parcourProfondeur(arc)) { // On regarde si le graph reste connexe meme si on enleve l'arc
            	arbre.remove(arc); // si oui on l'enleve
            }
            else { 
            	this.poidsTotal += arc.getValeur(); // sinon on incremente le poids de l'abre par le poids de l'arête
            	i++; // on incremente i de 1
            }
        }
        while(i < arbre.size()) { // pour toutes les arêtes restantes
        	this.poidsTotal += arbre.get(i++).getValeur(); // on incremente le poids de l'abre par le poids de l'arête
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
