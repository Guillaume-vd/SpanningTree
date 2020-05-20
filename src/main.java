import Algo.Kruskal1;
import Algo.Kruskal2;
import Algo.Prim;
import Autre.FabriquerGraph;
import Autre.Reset;
import Type.Graphe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {
    	long debut;
        long fin;
        int nbCouleur;

        //Pour chosir son fichier parmi les fichiers contenus dans le graph
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du fichier avec l'extention:");
        String NomFichier = sc.nextLine();
        sc.close();

        //Création du graphe
        debut = System.currentTimeMillis();
        FabriquerGraph FG = new FabriquerGraph(NomFichier);
        Graphe graphe = FG.getGraphe();
        fin = System.currentTimeMillis() - debut;
        System.out.println("Le graphe à été générer en " + fin+"ms");


        //Algorithme de Kruskal1
        debut = System.currentTimeMillis();
        Kruskal1 k1 = new Kruskal1(graphe);
        fin = System.currentTimeMillis() - debut;
        System.out.println("L'arbre avec l'algo Krustal1 a été générer en " + fin+"ms, avec un total de " + k1.getNbArc() + " arcs et une taille et un poids total de " + k1.getPoidsTotal());

        new Reset(graphe);
/*
        //Algorithme de Kruskal2
        debut = System.currentTimeMillis();
        Kruskal2 K2 = new Kruskal2(graphe);
        fin = System.currentTimeMillis() - debut;
        System.out.println("L'arbre avec l'algo Krustal2 a été générer en " + fin+"ms, avec un total de " + K2.getNbArc() + " arcs et une taille et un poids total de " + K2.getPoidsTotal());
     
        
        //Algorithme de Prim
        debut = System.currentTimeMillis();
        Prim p = new Prim(graphe);
        fin = System.currentTimeMillis() - debut;
        System.out.println("L'arbre avec l'algo Prim a été générer en " + fin+"ms, avec un total de " + p.getNbArc() + " arcs et une taille et un poids total de " + p.getPoidsTotal());
*/
    }

}



