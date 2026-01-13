package fr.univlemans.safelogistic;

/**
 * Représente un dépôt (entrepôt) à partir duquel les livraisons sont effectuées.
 */
public class Depot extends Lieu {
    /**
     * Crée un dépôt avec le label fourni.
     *
     * @param label le nom/identifiant du dépôt
     */
    public Depot(String label) {
        super(label);
    }
}
