package fr.univlemans.safelogistic;
import fr.univlemans.graphe.Arete;
import fr.univlemans.graphe.AretePonderee;
import fr.univlemans.graphe.Noeud;

/**
 * Représente un segment de rue (arête pondérée) reliant deux intersections.
 * Le poids représente la distance (ou le temps estimé) entre les deux nœuds.
 */
public class StreetSegment extends Arete implements AretePonderee {
    private final int distance;

    public StreetSegment(Noeud a, Noeud b, int distance) {
        super(a, b);
        this.distance = distance;
    }

    /**
     * Retourne la distance (poids) de ce segment de rue.
     *
     * @return la distance associée à ce segment
     */
    @Override
    public int getPoids() {
        return distance;
    }
}
