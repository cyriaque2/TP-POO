package fr.univlemans.graphe;

/**
 * Représente une arête pondérée reliant deux nœuds avec un poids associé.
 * <p>
 * Une arête pondérée étend {@link Arete} en ajoutant un poids (entier) qui peut
 * représenter une distance, un coût, un temps de trajet, ou toute autre métrique
 * numérique associée à la relation entre deux nœuds.
 * </p>
 * <p>
 * <b>Cas d'utilisation :</b>
 * <ul>
 *   <li>Réseaux routiers : poids = distance ou temps</li>
 *   <li>Réseaux informatiques : poids = latence ou bande passante</li>
 *   <li>Graphes de coûts : poids = prix ou dépense</li>
 *   <li>Algorithmes de plus court chemin : Dijkstra, Bellman-Ford</li>
 * </ul>
 * </p>
 *
 * @see Arete
 * @see Noeud
 */
public class AretePonderee extends Arete {
    
    /** Le poids (coût/distance/métrique) associé à cette arête. */
    int poids;

    /**
     * Crée une nouvelle arête pondérée reliant les deux nœuds avec le poids fourni.
     * <p>
     * Les contraintes de la classe parente {@link Arete} s'appliquent : les deux nœuds
     * doivent être différents. Le poids peut être négatif (selon l'algorithme utilisé).
     * </p>
     *
     * @param a le premier nœud (ne doit pas être {@code null})
     * @param b le deuxième nœud (ne doit pas être {@code null})
     * @param p le poids de l'arête (peut être négatif selon l'utilisation)
     * 
     * @throws IllegalArgumentException si a et b sont le même nœud
     * @throws NullPointerException si a ou b est {@code null}
     */
    public AretePonderee(Noeud a, Noeud b, int p){
        super(a, b);
        poids = p;
    }

    /**
     * Retourne le poids de l'arête.
     * <p>
     * Le poids reste constant après la création de l'arête (immutable).
     * </p>
     *
     * @return le poids de cette arête pondérée
     */
    public int getPoids(){
        return poids;
    }

    /**
     * Retourne une représentation textuelle de l'arête pondérée.
     * <p>
     * Le format est [a,b|poids] où a et b sont les labels des nœuds et poids est sa valeur.
     * </p>
     *
     * @return une chaîne au format [a,b|poids]
     */
    @Override
    public String toString(){
        return "["+a+","+b+"|"+poids+"]";
    }
    
}
