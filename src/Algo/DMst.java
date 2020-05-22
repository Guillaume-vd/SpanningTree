package Algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Autre.ComparePoidsCroissant;
import Type.Arc;
import Type.Graphe;
import Type.Sommet;

public class DMst {
	private List<Arc> arbre;
	private int poidsTotal;


	public DMst(Graphe graphe, int d){
		this.poidsTotal = 0; // On initialise le poids de l'arbre à 0
		List<Arc> listeArcs = new ArrayList<Arc>(graphe.getArc()); // On récupere la liste d'arc du graphe
		List<Sommet> r = new ArrayList<Sommet>(graphe.getSommets().subList(0, 1)); // On crée une liste de sommet dans lequel on prend un sommet du graphe aléatoirement
		int n = graphe.getSommets().size(); // on définit le nombre de sommets cherche
		this.arbre = new ArrayList<Arc>();// On crée une liste d'arc qui représentera l'arbre
		Arc arc;
		Sommet s;
		int i;
		Collections.sort(listeArcs, new ComparePoidsCroissant());// On tri la liste d'arcs dans l'ordre decroissants de poids
		while(r.size() < n) { // tant qu'on a pas autant de sommets que le graphe
			i = 0;
			arc = listeArcs.get(i++); // on prend le premier arc de la liste 
			while(!((r.contains(arc.getArrivee())) ^ (r.contains(arc.getOrigine())))) { // tant qu'on ne trouve pas un arc avec une seule extrémite faisant partie de r
				arc = listeArcs.get(i++); // on prend l'arc suivant de la liste
			}
			this.arbre.add(arc); // on ajoute l'arc dans l'abre
			listeArcs.remove(arc); // on enleve l'arc de la liste d'arc
			this.poidsTotal += arc.getValeur(); // on incremente le poids de l'arbe avec le poids de l'arc
			if(r.contains(arc.getArrivee())) { //Si r contient le sommet de l'arrivée de l'arc
				r.add(arc.getOrigine()); // on ajoute l'autre sommet à r
				s = arc.getArrivee(); // on recupere le sommet qui etait deja dans la liste de sommet r
			}
			else { 
				r.add(arc.getArrivee()); // sinon on ajoute le sommet d'arrivée à r
				s = arc.getOrigine(); // on recupere le sommet qui etait deja dans la liste de sommet r
			}
			if(s.getVoisins().size() >= d) { // Si le sommet à atteteints le nombre d'arête maximum 
				i = 0;
				while(i < listeArcs.size()) { // on parcour toute la liste d'arc
					arc = listeArcs.get(i); // on prend le ième arc
					if(arc.getArrivee() == s || arc.getOrigine() == s) { // si l'arc contient le sommet s 
						listeArcs.remove(arc); // on enlève l'arc de la liste d'arcs
					}
					else {
						i++; // sinon on incremente i de 1
					}
				}
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