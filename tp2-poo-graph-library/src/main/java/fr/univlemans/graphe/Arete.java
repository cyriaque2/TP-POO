package fr.univlemans.graphe;

/**
 * Représente une arête (edge) reliant deux nœuds.
 * <p>
 * Une arête non orientée relie deux nœuds (a et b) sans direction spécifique.
 * Cette classe fournit les méthodes basiques pour accéder aux nœuds et afficher l'arête.
 */
public class Arete {
    /** Le premier nœud de l'arête. */
    Noeud a;
    
    /** Le deuxième nœud de l'arête. */
    Noeud b;

    /**
     * Crée une nouvelle arête reliant les deux nœuds fournis.
     *
     * @param a le premier nœud
     * @param b le deuxième nœud
     */
    public Arete(Noeud a, Noeud b){
        if(a==b){
            throw new IllegalArgumentException("Une arête ne peut pas relier un nœud à lui-même.");
        }
        this.a = a;
        this.b = b;
    }


    public Noeud getA() {
        return a;
    }

    public Noeud getB() {
        return b;
    }
    
    /**
     * Retourne une représentation textuelle de l'arête.
     *
     * @return une chaîne au format [a,b]
     */
    @Override
    public String toString(){
        return "["+a+","+b+"]";
    }
}
