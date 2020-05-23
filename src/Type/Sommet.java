package Type;

import java.util.ArrayList;
import java.util.List;

public class Sommet {
    private int id;
    private int degre;
    private List<Sommet> voisins;
    private boolean marque;

    public Sommet(int id) {
        this.id = id;
        this.degre = 0;
        this.marque = false;
        this.voisins = new ArrayList<>();
    }

    public boolean equals(Sommet autreSommet){
        return super.equals(autreSommet);
    }

    public List<Sommet> getVoisins() {
        return this.voisins;
    }
    
    public boolean estMarque() {
    	return this.marque;
    }

    public void marquer() {
    	this.marque = true;
    }
    
    public void unmarquer() {
    	this.marque = false;
    }

    public void incrementerDegre() {
        this.degre++;
    }
    
    public void decrementerDegre() {
        this.degre--;
    }

    public void ajouterVoisin(Sommet sommet) {
        incrementerDegre();
        this.voisins.add(sommet);
    }
    
    public void enleverVoisin(Sommet sommet) {
    	decrementerDegre();
        this.voisins.remove(sommet);
    }

    public int getDegre() {
        return this.degre;
    }

    public int getId(){
        return id;
    }
}
