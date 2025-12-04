package fr.univlemans.algo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import fr.univlemans.graphe.Graphe;
import fr.univlemans.graphe.Noeud;

/**
 * Implémentation de l'algorithme Breadth-First Search (BFS - Parcours en Largeur).
 * <p>
 * BFS est un algorithme de parcours de graphe qui explore tous les nœuds à la distance k
 * avant d'explorer les nœuds à la distance k+1. Cet algorithme utilise une file (FIFO)
 * pour gérer l'ordre de visite des nœuds.
 * </p>
 * <p>
 * <b>Complexité :</b>
 * <ul>
 *   <li>Temporelle : O(V + E) où V est le nombre de nœuds et E le nombre d'arêtes</li>
 *   <li>Spatiale : O(V) pour le stockage des nœuds visités et de la file</li>
 * </ul>
 * </p>
 * <p>
 * <b>Utilisations :</b>
 * <ul>
 *   <li>Trouver le plus court chemin entre deux nœuds</li>
 *   <li>Détection de cycles dans un graphe non orienté</li>
 *   <li>Exploration de voisinage (amis à distance k)</li>
 *   <li>Parcours par niveaux</li>
 *   <li>Composantes connexes</li>
 * </ul>
 * </p>
 *
 * @see Algorithme
 */
public class BFS implements Algorithme {

    /**
     * Exécute l'algorithme BFS sur le graphe fourni à partir du nœud de départ.
     * <p>
     * Cette méthode explore tous les nœuds accessibles à partir du nœud de départ
     * en utilisant un parcours par niveaux (largeur d'abord). Elle affiche sur la
     * console le label de chaque nœud visité dans l'ordre de parcours.
     * </p>
     *
     * @param g le graphe à parcourir (ne doit pas être {@code null})
     * @param start le nœud de départ du parcours (ne doit pas être {@code null})
     * 
     * @throws NullPointerException si g ou start est {@code null}
     */
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
