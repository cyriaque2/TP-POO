package fr.univlemans.algo;

import fr.univlemans.graphe.*;
import java.util.*;         

/**
     * Implémentation de l'algorithme de Dijkstra pour calculer des plus courts chemins
     * dans un graphe pondéré. Utilise une file de priorité pour visiter les nœuds
     * par distance croissante.
     * <p>
     * La méthode {@link #calculerChemin(Graphe, Noeud, Noeud)} retourne la liste des
     * nœuds composant le plus court chemin entre une source et une destination.
     * Le coût du dernier calcul est accessible via {@link #getDernierCout()}.
     */
    public class DijkstraAlgorithm implements Algorithme {

    private int dernierCout = 0;

    /**
     * Retourne le coût (distance) du dernier chemin calculé par
     * {@link #calculerChemin(Graphe, Noeud, Noeud)}.
     * Si aucun calcul n'a été effectué, retourne la valeur par défaut (0).
     *
     * @return le coût du dernier chemin calculé
     */
    public int getDernierCout() {
        return dernierCout;
    }

    @Override
    /**
     * Méthode d'interface pour exécuter l'algorithme depuis un nœud de départ.
     * Cette implémentation affiche simplement le nœud de départ. Pour obtenir
     * le chemin réel, utiliser {@link #calculerChemin(Graphe, Noeud, Noeud)}.
     *
     * @param g le graphe sur lequel exécuter l'algorithme
     * @param start le nœud de départ
     */
    public void executer(Graphe g, Noeud start) {
        System.out.println("Exécution de Dijkstra depuis : " + start.getLabel());
    }

    /**
     * Calcule le plus court chemin entre une source et une destination en utilisant
     * l'algorithme de Dijkstra. Les arêtes doivent être des instances de
     * {@link fr.univlemans.graphe.AretePonderee} pour tenir compte des poids.
     * Si la destination est inatteignable, la liste renvoyée sera vide.
     *
     * @param g le graphe contenant les nœuds et arêtes
     * @param source le nœud source
     * @param destination le nœud destination
     * @return la liste ordonnée de nœuds formant le plus court chemin (vide si aucun chemin)
     */
    public List<Noeud> calculerChemin(Graphe g, Noeud source, Noeud destination) {
        Map<Noeud, Integer> distances = new HashMap<>();
        Map<Noeud, Noeud> parents = new HashMap<>();
        PriorityQueue<NoeudDistance> pq = new PriorityQueue<>(Comparator.comparingInt(nd -> nd.distance));

        for (Noeud n : g.getNoeuds()) {
            distances.put(n, Integer.MAX_VALUE);
        }
        
        distances.put(source, 0);
        pq.add(new NoeudDistance(source, 0));

        while (!pq.isEmpty()) {
            Noeud current = pq.poll().noeud;
            if (current.equals(destination)) break;

            for (Arete a : g.getEdges(current)) {
                if (a instanceof AretePonderee ap) {
                    Noeud voisin = (a.getSource().equals(current)) ? a.getTarget() : a.getSource();
                    
                    if (!distances.containsKey(voisin)) {
                        distances.put(voisin, Integer.MAX_VALUE);
                    }

                    Integer distCourante = distances.get(current);
                    if (distCourante == null) continue; 

                    int nouvelleDist = distCourante + ap.getPoids();

                    if (nouvelleDist < distances.get(voisin)) {
                        distances.put(voisin, nouvelleDist);
                        parents.put(voisin, current);
                        pq.add(new NoeudDistance(voisin, nouvelleDist));
                    }
                }
            }
        }

        this.dernierCout = distances.getOrDefault(destination, 0);
        return reconstruireChemin(parents, destination);
    }   

    /**
     * Reconstruit le chemin à partir de la table des parents produite par l'algorithme.
     *
     * @param parents table de correspondance enfant -> parent
     * @param dest nœud destination
     * @return liste ordonnée des nœuds du chemin (vide si introuvable)
     */
    private List<Noeud> reconstruireChemin(Map<Noeud, Noeud> parents, Noeud dest) {
        LinkedList<Noeud> chemin = new LinkedList<>();
        if (!parents.containsKey(dest) && dest != null) return chemin;
        
        Noeud etape = dest;
        while (etape != null) {
            chemin.addFirst(etape);
            etape = parents.get(etape);
        }
        return chemin;
    }

    /**
     * Classe utilitaire associant un nœud à sa distance courante pour la file de priorité.
     */
    private static class NoeudDistance {
        Noeud noeud;
        int distance;
        NoeudDistance(Noeud n, int d) { this.noeud = n; this.distance = d; }
    }
}