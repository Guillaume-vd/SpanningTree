import Algo.Kruskal1;
import Autre.FabriquerGraph;
import Type.Graphe;

import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {
        long debut;
        long fin;
        int nbCouleur;

        //Pour chosir son fichier parmis les fichiers contenu dans graph
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du fichier avec l'extention:");
        String NomFichier = sc.nextLine();

        //Création du graphe
        debut = System.currentTimeMillis();
        Graphe graphe = new Graphe();
        FabriquerGraph FG = new FabriquerGraph(NomFichier);
        graphe = FG.getGraphe();
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le graphe à été générer en " + fin+"ms");

        //Algorithme de Kruskal1
        debut = System.currentTimeMillis();
        Kruskal1 K1 = new Kruskal1(graphe);
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le graphe à été générer en " + fin+"ms");

    }
}



