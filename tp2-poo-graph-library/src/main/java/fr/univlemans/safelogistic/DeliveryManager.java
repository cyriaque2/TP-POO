package fr.univlemans.safelogistic;

import fr.univlemans.graphe.*;
import fr.univlemans.algo.DijkstraAlgorithm;
import java.util.List;

/**
 * Gère la planification et le suivi des livraisons dans une ville représentée
 * par un graphe. Utilise un algorithme de plus courts chemins (Dijkstra)
 * pour calculer les trajets entre dépôt, restaurant et client.
 */
public class DeliveryManager {
    /** Compteur global des commandes traitées. */
    private static int compteurCommandes = 0;

    /** Graphe représentant la ville (intersections et segments de rue). */
    private final Graphe ville;
    /** Moteur de calcul des plus courts chemins. */
    private final DijkstraAlgorithm dijkstra;

    /**
     * Initialise le gestionnaire avec le graphe de la ville.
     *
     * @param g le graphe modélisant la ville
     */
    public DeliveryManager(Graphe g) {
        this.ville = g;
        this.dijkstra = new DijkstraAlgorithm();
    }

    /**
     * Planifie et affiche les trajets pour une commande : Dépôt -> Restaurant -> Client.
     * Calcule les chemins, récupère les coûts (temps estimé) et affiche un résumé.
     *
     * @param start le dépôt de départ
     * @param pickup le restaurant de préparation
     * @param dropoff le client destinataire
     */
    public void planDelivery(Depot start, Restaurant pickup, Client dropoff) {
        compteurCommandes++;
        
        List<Noeud> trajet1 = dijkstra.calculerChemin(ville, start, pickup);
        int cout1 = dijkstra.getDernierCout();

        List<Noeud> trajet2 = dijkstra.calculerChemin(ville, pickup, dropoff);
        int cout2 = dijkstra.getDernierCout();
        
        System.out.println("==========================================");
        System.out.println("COMMANDE SafeLogistic n°" + compteurCommandes);
        System.out.println("==========================================");
        System.out.println("1. Trajet Dépôt -> Restaurant : " + trajet1);
        System.out.println("2. Trajet Restaurant -> Client : " + trajet2);
        System.out.println("------------------------------------------");
        System.out.println("Temps total estimé : " + (cout1 + cout2) + " min");
        System.out.println("==========================================\n");
    }
}