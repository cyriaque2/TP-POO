package fr.univlemans.graphe;

/**
 * Représente une arête pondérée reliant deux nœuds avec un poids associé.
 *
 * Transformation : classe -> interface avec une implémentation interne {@code Impl}
 * fournissant le même comportement qu'auparavant.
 *
 * @see Arete
 * @see Noeud
 */
public interface AretePonderee {

    /**
     * Retourne le poids de l'arête.
     *
     * @return le poids de cette arête pondérée
     */
    int getPoids();

    /**
     * Factory pour créer une arête pondérée.
     *
     * @throws IllegalArgumentException si a et b sont le même nœud
     * @throws NullPointerException si a ou b est {@code null}
     */
    static AretePonderee of(Noeud a, Noeud b, int p) {
        return new Impl(a, b, p);
    }

    /**
     * Implémentation concrète par défaut qui étend {@link Arete}.
     */
    class Impl extends Arete implements AretePonderee {
        private final int poids;

        public Impl(Noeud a, Noeud b, int p) {
            super(a, b);
            this.poids = p;
        }

        @Override
        public int getPoids() {
            return poids;
        }

        @Override
        public String toString() {
            return "[" + a + "," + b + "|" + poids + "]";
        }
    }
}   