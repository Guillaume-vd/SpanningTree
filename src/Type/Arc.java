package Type;

public class Arc {
    private Sommet origine;
    private Sommet arrivee;
    private int valeur;

    public Arc(Sommet origine, Sommet arrivee){
        this.arrivee = arrivee;
        this.origine = origine;
    }

    public Arc(Sommet origine, Sommet arrivee, int valeur) {
        this.origine = origine;
        this.arrivee = arrivee;
        this.valeur = valeur;

        origine.incrementerDegre();
        arrivee.incrementerDegre();

        origine.ajouterVoisin(arrivee);
        arrivee.ajouterVoisin(origine);
    }

    public boolean equals(Arc autreArete) {
        boolean endroit = this.origine.equals(autreArete.getOrigine())
                && this.arrivee.equals(autreArete.getArrivee());
        boolean envers = this.origine.equals(autreArete.getArrivee())
                && this.arrivee.equals(autreArete.getOrigine());
        return endroit || envers;
    }

    public Sommet getOrigine() {
        return origine;
    }

    public Sommet getArrivee() {
        return arrivee;
    }

    public int getValeur(){
        return this.valeur;
    }

}
