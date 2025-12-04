package fr.univlemans.algo;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import fr.univlemans.graphe.Graphe;
import fr.univlemans.graphe.Noeud;

/**
 * Implémentation de l'algorithme Depth-First Search (DFS - Parcours en Profondeur).
 * <p>
 * DFS est un algorithme de parcours de graphe qui explore aussi loin que possible
 * le long de chaque branche avant de revenir en arrière. Cet algorithme utilise une
 * pile (LIFO) pour gérer l'ordre de visite des nœuds.
 * </p>
 * <p>
 * <b>Complexité :</b>
 * <ul>
 *   <li>Temporelle : O(V + E) où V est le nombre de nœuds et E le nombre d'arêtes</li>
 *   <li>Spatiale : O(V) pour le stockage des nœuds visités et de la pile</li>
 * </ul>
 * </p>
 * <p>
 * <b>Utilisations :</b>
 * <ul>
 *   <li>Détection de cycles dans un graphe</li>
 *   <li>Tri topologique</li>
 *   <li>Composantes connexes</li>
 *   <li>Chemin entre deux nœuds</li>
 * </ul>
 * </p>
 *
 * @see Algorithme
 */
public class DFS implements Algorithme {
    
    /** Ensemble des nœuds déjà visités durant le parcours. */
    private Set<Noeud> visited;

    /**
     * Exécute l'algorithme DFS sur le graphe fourni à partir du nœud de départ.
     * <p>
     * Cette méthode initialise l'ensemble des nœuds visités et lance le parcours
     * en profondeur itératif.
     * </p>
     *
     * @param g le graphe à parcourir (ne doit pas être {@code null})
     * @param start le nœud de départ du parcours (ne doit pas être {@code null})
     * 
     * @throws NullPointerException si g ou start est {@code null}
     */
    @Override
    public void executer(Graphe g, Noeud start) {
        visited = new HashSet<>();
        dfsIterative(g, start);
    }
    
    /**
     * Effectue le parcours DFS de manière itérative en utilisant une pile.
     * <p>
     * Cette implémentation utilise une {@link Stack} pour gérer les nœuds à visiter,
     * ce qui évite les risques de débordement de pile (stack overflow) en comparaison
     * avec une approche récursive.
     * </p>
     * <p>
     * Affiche sur la console :
     * <ul>
     *   <li>Le message de début du parcours avec le label du nœud de départ</li>
     *   <li>Le label de chaque nœud visité</li>
     *   <li>Le message de fin du parcours</li>
     * </ul>
     * </p>
     *
     * @param g le graphe à parcourir
     * @param start le nœud de départ du parcours
     */
    private void dfsIterative(Graphe g, Noeud start) {
        Stack<Noeud> pile = new Stack<>();
        pile.push(start);
        visited.add(start);
        
        System.out.println("Début du parcours DFS à partir de: " + start.getLabel());
        
        while (!pile.isEmpty()) {
            Noeud noeud = pile.pop();
            System.out.println("Visite: " + noeud.getLabel());
            
            // Parcourir les voisins du nœud courant
            for (Noeud voisin : g.voisins(noeud)) {
                if (!visited.contains(voisin)) {
                    visited.add(voisin);
                    pile.push(voisin);
                }
            }
        }
        
        System.out.println("Parcours DFS terminé");
    }
}
