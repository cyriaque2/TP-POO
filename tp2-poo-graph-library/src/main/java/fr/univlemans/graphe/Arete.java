package fr.univlemans.graphe;

/**
 * Représente une arête (edge) reliant deux nœuds dans un graphe.
 * <p>
 * Une arête non orientée relie deux nœuds distincts (a et b) sans direction spécifique.
 * Les arêtes sont utilisées pour modéliser les relations entre les nœuds. Une arête
 * ne peut pas relier un nœud à lui-même (pas de boucle autonome).
 * </p>
 * <p>
 * <b>Invariants :</b>
 * <ul>
 *   <li>Les deux nœuds d'une arête doivent être différents (a ≠ b)</li>
 *   <li>Une arête ne peut pas être modifiée après sa création (immutable)</li>
 * </ul>
 * </p>
 *
 * @see Noeud
 * @see AretePonderee
 * @see Graphe
 */
public class Arete {
    /** Le premier nœud de l'arête. */
    Noeud a;
    
    /** Le deuxième nœud de l'arête. */
    Noeud b;

    /**
     * Crée une nouvelle arête reliant les deux nœuds fournis.
     * <p>
     * Les deux nœuds doivent être différents. Une tentative de créer une arête
     * reliant un nœud à lui-même lèvera une exception.
     * </p>
     *
     * @param a le premier nœud (ne doit pas être {@code null})
     * @param b le deuxième nœud (ne doit pas être {@code null})
     * 
     * @throws IllegalArgumentException si a et b sont le même nœud
     * @throws NullPointerException si a ou b est {@code null}
     */
    public Arete(Noeud a, Noeud b){
        if(a==b){
            throw new IllegalArgumentException("Une arête ne peut pas relier un nœud à lui-même.");
        }
        this.a = a;
        this.b = b;
    }

    /**
     * Retourne le premier nœud de l'arête.
     *
     * @return le premier nœud (a)
     */
    public Noeud getA() {
        return a;
    }

    /**
     * Retourne le deuxième nœud de l'arête.
     *
     * @return le deuxième nœud (b)
     */
    public Noeud getB() {
        return b;
    }
    
    /**
     * Retourne une représentation textuelle de l'arête.
     * <p>
     * Le format est [a,b] où a et b sont les labels des nœuds.
     * </p>
     *
     * @return une chaîne au format [a,b]
     */
    @Override
    public String toString(){
        return "["+a+","+b+"]";
    }
}
