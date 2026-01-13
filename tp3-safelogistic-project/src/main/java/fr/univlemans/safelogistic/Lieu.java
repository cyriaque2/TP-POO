package fr.univlemans.safelogistic;
import fr.univlemans.graphe.Noeud;

/**
 * Concept abstrait de Lieu (LocationNode).
 * Utilise l'héritage pour spécialiser le concept de Noeud.
 */
public abstract class Lieu extends Noeud {
    public Lieu(String label) {
        super(label);
    }
}