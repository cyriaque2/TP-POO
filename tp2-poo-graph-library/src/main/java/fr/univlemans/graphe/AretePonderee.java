package fr.univlemans.graphe;

/**
 * Représente une arête pondérée reliant deux nœuds avec un poids.
 * <p>
 * Une arête pondérée étend {@link Arete} en ajoutant un poids (entier) qui peut
 * représenter une distance, un coût, ou toute autre métrique associée à l'arête.
 */
public class AretePonderee extends Arete {
    
    /** Le poids (coût/distance) de l'arête. */
    int poids;

    /**
     * Crée une nouvelle arête pondérée reliant les deux nœuds avec le poids fourni.
     *
     * @param a le premier nœud
     * @param b le deuxième nœud
     * @param p le poids de l'arête
     */
    public AretePonderee(Noeud a, Noeud b, int p){
        super(a, b);
        poids = p;
    }

    /**
     * Retourne le poids de l'arête.
     *
     * @return le poids de cette arête pondérée
     */
    public int getPoids(){
        return poids;
    }

    /**
     * Retourne une représentation textuelle de l'arête pondérée.
     *
     * @return une chaîne au format [a,b|poids|
     */
    @Override
    public String toString(){
        return "["+a+","+b+"|"+poids+"|";
    }
    
}
