package fr.univlemans.algo;
import fr.univlemans.graphe.Graphe;
import fr.univlemans.graphe.Noeud;

public interface Algorithme {
    void executer(Graphe g, Noeud start);
}
