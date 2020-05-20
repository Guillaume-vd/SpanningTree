package Algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Autre.ComparePoidsCroissant;
import Type.Arc;
import Type.Graphe;
import Type.Sommet;

public class Prim {
	private List<Arc> listeArcs;
	private int poidsTotal;


	public Prim(Graphe graphe){
		this.poidsTotal = 0;
		List<Arc> listeArcs = new ArrayList<Arc>(graphe.getArc());
		List<Sommet> r = new ArrayList<Sommet>(graphe.getSommets().subList(0, 1));
		int taille = graphe.getSommets().size();
		this.listeArcs = new ArrayList<Arc>();
		Arc arc;
		int i;
		Collections.sort(listeArcs, new ComparePoidsCroissant());
		while(r.size() < taille) {
			i = 0;
			arc = listeArcs.get(i++);
			while(!((r.contains(arc.getArrivee())) ^ (r.contains(arc.getOrigine())))) {
				arc = listeArcs.get(i++);
			}
			this.listeArcs.add(arc);
			listeArcs.remove(arc);
			if(r.contains(arc.getArrivee())) {
				r.add(arc.getOrigine());
			}
			else {
				r.add(arc.getArrivee());
			}
			this.poidsTotal += arc.getValeur();
		}
	}

	public int getNbArc(){
		return this.getArcs().size();
	}

	public List<Arc> getArcs(){
		return this.listeArcs;
	}

	public int getPoidsTotal(){
		return this.poidsTotal;
	}
}