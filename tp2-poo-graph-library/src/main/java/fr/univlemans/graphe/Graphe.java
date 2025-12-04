package fr.univlemans.graphe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Représente un graphe simple composé de nœuds et d'arêtes.
 * <p>
 * Cette classe maintient deux listes : une pour les nœuds (`noeuds`) et
 * une pour les arêtes (`aretes`). Elle fournit des méthodes basiques pour
 * ajouter et retirer des nœuds et des arêtes, ainsi qu'une représentation
 * textuelle du graphe via {@code toString()}.
 */
public class Graphe {
    /** Liste des nœuds du graphe. */
    LinkedList<Noeud> noeuds = new LinkedList<>();

    /** Liste des arêtes du graphe. */
    LinkedList<Arete> aretes = new LinkedList<>();

    boolean oriente;

    public Graphe(boolean oriente) {
        this.oriente = oriente;
    }

    public Graphe(boolean oriente, LinkedList<Noeud> noeuds, LinkedList<Arete> aretes) {
        this.oriente = oriente;
        this.noeuds = noeuds;
        this.aretes = aretes;
    }

    /**
     * Ajoute un nœud au graphe.
     *
     * @param n le nœud à ajouter (ne doit pas être {@code null})
     */
    public void addNoeud(Noeud n){
        noeuds.add(n);
    } 

    /**
     * Retire un nœud du graphe.
     *
     * @param n le nœud à retirer
     */
    public void removeNoeud(Noeud n){
        noeuds.remove(n);
    }

    /**
     * Ajoute une arête existante au graphe.
     *
     * @param a l'arête à ajouter
     */
    public void addArete(Arete a){
        for (Arete test : aretes) {
            if ((test.a == a.a && test.b == a.b) || (!oriente && test.a == a.b && test.b == a.a)) {
                throw new IllegalArgumentException("L'arête existe déjà dans le graphe.");
            }
        }
        aretes.add(a);
    }

    /**
     * Crée et ajoute une arête reliant les deux nœuds fournis.
     *
     * @param a le nœud source
     * @param b le nœud destination
     */
    public void addArete(Noeud a, Noeud b){
        addArete(new Arete(a,b));
    }

    /**
     * Retire une arête du graphe.
     *
     * @param a l'arête à retirer
     */
    public void removeArete(Arete a){
        aretes.remove(a);
    }

    public List<Noeud> voisins(Noeud n) {
        List<Noeud> v = new ArrayList<>();
        for (Arete a : aretes) {
            if (a.getA().equals(n))
                v.add(a.getB());
            else if (!oriente && a.getB().equals(n))
                v.add(a.getA());
        }
        return v;
    }

    /**
     * Retourne une représentation textuelle du graphe, listant les nœuds
     * puis les arêtes.
     *
     * @return une chaîne décrivant les nœuds et les arêtes du graphe
     */
    @Override
    public String toString() {
        String res = "Liste des Noeuds:\n ";
        for (Noeud n : noeuds) {
            res += "\""+n+"\" ";
        }
        res += "\nListe des Arêtes:\n ";
        for (Arete a : aretes) {
            res += a+"\n ";
        }
        return res;
    }

}

