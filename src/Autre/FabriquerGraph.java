package Autre;

import Type.Arc;
import Type.Graphe;
import Type.Sommet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FabriquerGraph {
	private Graphe graphe;

    public FabriquerGraph(String NomFichier) throws IOException{
    	Graphe graphe = new Graphe();
        List<Sommet> listSommet = new ArrayList<>();

        BufferedReader in = new BufferedReader(new FileReader("src/Graphe/" + NomFichier));
        String line;
        String[] Sommet;
        int nbS = 0;
        int Sommettrouver = 0;
        boolean cont = true;
        int k;

        //Connaitre le nombre total de sommet
        line = in.readLine();
        while((line != null) && (line.charAt(0) != 'p')){
        	line = in.readLine();
        }
        nbS = Integer.parseInt(line.split(" ")[1]);
        in.close();

        //Initialisation de tous les sommets
        Sommet[] tabSommet = new Sommet[nbS+1];
        for(int i=1; i<=nbS; i++){
            Sommet sommet = new Sommet(i);
            graphe.ajoutSommet(sommet);
            listSommet.add(sommet);
            tabSommet[i] = sommet;
        }

        //Ajout des sommets au graph
        BufferedReader file = new BufferedReader(new FileReader("src/Graphe/" + NomFichier));
        while ((line = file.readLine()) != null){
            //Si la ligne contient un arc
            if(line.contains("e")){
                Sommet = line.split(" ");
                //Si la premiière lettre est bien un e
                if(Sommet[0].contains("e")){
                    for (int i=1; i<=tabSommet.length; i++) {
                        if(Integer.parseInt(Sommet[1]) == tabSommet[i].getId()){
                            Sommettrouver = i;
                            break;
                        }
                    }
                    cont = true;
                    k = 1;
                    //Création de arc et ajout voisins
                    while((k <= tabSommet.length) && cont){
                        //Recherche dans le tableau de sommet la coreespondace
                        if(Integer.parseInt(Sommet[2]) == tabSommet[k].getId()){
                            tabSommet[Sommettrouver].ajouterVoisin(tabSommet[k]);
                            tabSommet[k].ajouterVoisin(tabSommet[Sommettrouver]);
                            tabSommet[k].setPoid(Integer.parseInt(Sommet[3]));
                            Arc arc = new Arc(tabSommet[Sommettrouver],tabSommet[k]);
                            graphe.ajoutArc(arc);
                            cont = false;
                        }
                        k++;
                    }
                }
            }
        }
        file.close();
        this.graphe = graphe;
    }

    public Graphe getGraphe() throws IOException {
        return this.graphe;
    }
}
