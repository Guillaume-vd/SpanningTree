import Algo.DMst;
import Algo.Kruskal1;
import Algo.Kruskal2;
import Algo.Prim;
import Autre.FabriquerGraph;
import Type.Graphe;

import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {
    	long debut;
        long fin;

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
        System.out.println("Le graphe à été généré en " + fin+"ms");


        //Algorithme de Kruskal1
        debut = System.currentTimeMillis();
        Kruskal1 k1 = new Kruskal1(graphe);
        fin = System.currentTimeMillis() - debut;
        System.out.println("L'arbre avec l'algo Krustal1 a été généré en " + fin+"ms, avec un total de " + k1.getNbArete() + " arcs et une taille et un poids total de " + k1.getPoidsTotal());

        
        //Algorithme de Kruskal2
        debut = System.currentTimeMillis();
        Kruskal2 K2 = new Kruskal2(graphe);
        fin = System.currentTimeMillis() - debut;
        System.out.println("L'arbre avec l'algo Krustal2 a été généré en " + fin+"ms, avec un total de " + K2.getNbArete() + " arcs et une taille et un poids total de " + K2.getPoidsTotal());
     
        
        //Algorithme de Prim
        debut = System.currentTimeMillis();
        Prim p = new Prim(graphe);
        fin = System.currentTimeMillis() - debut;
        System.out.println("L'arbre avec l'algo Prim a été généré en " + fin+"ms, avec un total de " + p.getNbArete() + " arcs et une taille et un poids total de " + p.getPoidsTotal());
        
        
        //Algorithme de 2-mst
        debut = System.currentTimeMillis();
        DMst dMst = new DMst(graphe, 2);
        fin = System.currentTimeMillis() - debut;
        System.out.println("L'arbre avec l'algo 2-mst a été généré en " + fin+"ms, avec un total de " + dMst.getNbArete() + " arcs et une taille et un poids total de " + dMst.getPoidsTotal());
        
        
        //Algorithme de 3-mst
        debut = System.currentTimeMillis();
        dMst = new DMst(graphe, 3);
        fin = System.currentTimeMillis() - debut;
        System.out.println("L'arbre avec l'algo 3-mst a été généré en " + fin+"ms, avec un total de " + dMst.getNbArete() + " arcs et une taille et un poids total de " + dMst.getPoidsTotal());
        
        
        //Algorithme de 4-mst
        debut = System.currentTimeMillis();
        dMst = new DMst(graphe, 4);
        fin = System.currentTimeMillis() - debut;
        System.out.println("L'arbre avec l'algo 4-mst a été généré en " + fin+"ms, avec un total de " + dMst.getNbArete() + " arcs et une taille et un poids total de " + dMst.getPoidsTotal());
    
        
        //Algorithme de 5-mst
        debut = System.currentTimeMillis();
        dMst = new DMst(graphe, 5);
        fin = System.currentTimeMillis() - debut;
        System.out.println("L'arbre avec l'algo 5-mst a été généré en " + fin+"ms, avec un total de " + dMst.getNbArete() + " arcs et une taille et un poids total de " + dMst.getPoidsTotal());
    }

}



