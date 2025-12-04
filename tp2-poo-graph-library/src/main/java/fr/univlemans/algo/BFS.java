package fr.univlemans.algo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import fr.univlemans.graphe.Graphe;
import fr.univlemans.graphe.Noeud;

public class BFS implements Algorithme {

    @Override
    public void executer(Graphe g, Noeud start) {
        // Ensemble pour marquer les noeuds visités
        Set<Noeud> visited = new HashSet<>();

        // File FIFO pour BFS
        Queue<Noeud> queue = new LinkedList<>();

        // On démarre par le noeud de départ
        visited.add(start);
        queue.add(start);

        System.out.println("BFS starting from " + start.getLabel());

        while (!queue.isEmpty()) {
            Noeud current = queue.poll();
            System.out.println("Visit: " + current.getLabel());

            // Récupère les voisins à partir du graphe
            for (Noeud voisin : g.voisins(current)) {
                if (!visited.contains(voisin)) {
                    visited.add(voisin);
                    queue.add(voisin);
                }
            }
        }
    }
}
