package fr.univlemans.algo;
import fr.univlemans.graphe.Graphe;
import fr.univlemans.graphe.Noeud;

/**
 * Interface définissant le contrat pour les algorithmes de parcours de graphe.
 * <p>
 * Cette interface fournit une abstraction commune pour tous les algorithmes
 * de parcours et d'exploration de graphes (DFS, BFS, etc.). Les implémentations
 * doivent parcourir les nœuds du graphe à partir d'un nœud de départ.
 * </p>
 * <p>
 * Les implémentations sont responsables de :
 * <ul>
 *   <li>Parcourir l'ensemble des nœuds accessibles</li>
 *   <li>Gérer les états de visite des nœuds</li>
 *   <li>Fournir une trace du parcours (affichage console, logs, etc.)</li>
 * </ul>
 * </p>
 */
public interface Algorithme {
    
    /**
     * Exécute l'algorithme de parcours sur le graphe fourni.
     * <p>
     * Cette méthode lance le parcours à partir du nœud de départ spécifié.
     * L'implémentation doit parcourir tous les nœuds accessibles selon la stratégie
     * de l'algorithme (DFS, BFS, etc.).
     * </p>
     *
     * @param g le graphe à parcourir (ne doit pas être {@code null})
     * @param start le nœud de départ du parcours (ne doit pas être {@code null})
     * 
     * @throws NullPointerException si g ou start est {@code null}
     */
    void executer(Graphe g, Noeud start);
}
