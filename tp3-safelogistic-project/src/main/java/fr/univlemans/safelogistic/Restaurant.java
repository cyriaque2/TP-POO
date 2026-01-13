package fr.univlemans.safelogistic;

/**
 * Représente un restaurant d'où proviennent les commandes. Contient
 * le temps moyen de préparation d'une commande (en minutes).
 */
public class Restaurant extends Lieu {
    private final int tempsPreparation;

    /**
     * Crée un restaurant avec son label et son temps de préparation.
     *
     * @param label le nom ou identifiant du restaurant
     * @param tempsPreparation temps moyen de préparation (minutes)
     */
    public Restaurant(String label, int tempsPreparation) {
        super(label);
        this.tempsPreparation = tempsPreparation;
    }

    /**
     * Retourne le temps moyen de préparation des commandes.
     *
     * @return le temps de préparation en minutes
     */
    public int getTempsPreparation() {
        return tempsPreparation;
    } 
}
