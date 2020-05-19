package Type;

import java.util.ArrayList;
import java.util.List;

public class Sommet {
    private int id;
    private int degre;
    private List<Sommet> voisins;
    private int poid;

    public Sommet(int id) {
        this.id = id;
        this.degre = 0;
        this.voisins = new ArrayList<Sommet>();
        this.poid = 0;
    }

    public boolean equals(Sommet autreSommet){
        return super.equals(autreSommet);
    }

    public List<Sommet> getVoisins() {
        return this.voisins;
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

    public int getPoid(){
        return this.poid;
    }

    public void setPoid(int poid){
        this.poid = poid;
    }

}
