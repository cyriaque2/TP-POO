package fr.univlemans.graphe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Représente un graphe simple composé de nœuds et d'arêtes.
 * <p>
 * Un graphe est une structure de données composée d'un ensemble de nœuds (vertices)
 * connectés par des arêtes (edges). Cette classe maintient deux listes : une pour les
 * nœuds et une pour les arêtes. Elle fournit des méthodes pour construire, modifier
 * et interroger le graphe.
 * </p>
 * <p>
 * <b>Caractéristiques :</b>
 * <ul>
 *   <li>Support des graphes orientés et non orientés</li>
 *   <li>Pas de nœuds ou arêtes dupliquées</li>
 *   <li>Pas de boucles autonomes (auto-edges)</li>
 *   <li>Utilise {@link LinkedList} pour l'efficacité des opérations</li>
 * </ul>
 * </p>
 * <p>
 * <b>Complexités :</b>
 * <ul>
 *   <li>Ajouter/retirer un nœud : O(n) où n est le nombre de nœuds</li>
 *   <li>Ajouter une arête : O(m) où m est le nombre d'arêtes (vérification de doublon)</li>
 *   <li>Trouver les voisins : O(m)</li>
 * </ul>
 * </p>
 *
 * @see Noeud
 * @see Arete
 * @see AretePonderee
 */
public class Graphe {
    /** Liste des nœuds du graphe. */
    LinkedList<Noeud> noeuds = new LinkedList<>();

    /** Liste des arêtes du graphe. */
    LinkedList<Arete> aretes = new LinkedList<>();

    /** Indique si le graphe est orienté ({@code true}) ou non orienté ({@code false}). */
    boolean oriente;

    /**
     * Crée un nouveau graphe vide.
     *
     * @param oriente {@code true} pour un graphe orienté, {@code false} pour un graphe non orienté
     */
    public Graphe(boolean oriente) {
        this.oriente = oriente;
    }

    /**
     * Crée un nouveau graphe avec les nœuds et arêtes fournis.
     * <p>
     * Cette méthode de construction permet d'initialiser un graphe avec un ensemble
     * prédéfini de nœuds et d'arêtes.
     * </p>
     *
     * @param oriente {@code true} pour un graphe orienté, {@code false} pour un graphe non orienté
     * @param noeuds la liste initiale des nœuds
     * @param aretes la liste initiale des arêtes
     */
    public Graphe(boolean oriente, LinkedList<Noeud> noeuds, LinkedList<Arete> aretes) {
        this.oriente = oriente;
        this.noeuds = noeuds;
        this.aretes = aretes;
    }

    /**
     * Ajoute un nœud au graphe.
     * <p>
     * Si le nœud existe déjà dans le graphe, il sera ajouté une deuxième fois
     * (pas de vérification de doublon).
     * </p>
     *
     * @param n le nœud à ajouter (ne doit pas être {@code null})
     */
    public void addNoeud(Noeud n){
        noeuds.add(n);
    } 

    /**
     * Retire un nœud du graphe.
     * <p>
     * La suppression d'un nœud ne supprime pas automatiquement les arêtes incidentes.
     * Il est de la responsabilité de l'utilisateur de nettoyer les arêtes associées.
     * </p>
     *
     * @param n le nœud à retirer
     * @return {@code true} si le nœud a été trouvé et supprimé, {@code false} sinon
     */
    public void removeNoeud(Noeud n){
        noeuds.remove(n);
    }

    /**
     * Ajoute une arête existante au graphe.
     * <p>
     * Cette méthode vérifie que l'arête n'existe pas déjà dans le graphe avant de l'ajouter.
     * Pour les graphes non orientés, les arêtes (a,b) et (b,a) sont considérées comme
     * identiques.
     * </p>
     *
     * @param a l'arête à ajouter (ne doit pas être {@code null})
     * 
     * @throws IllegalArgumentException si l'arête existe déjà dans le graphe
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
     * <p>
     * Cette méthode est un raccourci pour créer une nouvelle {@link Arete} et
     * l'ajouter au graphe en une seule opération.
     * </p>
     *
     * @param a le nœud source (ne doit pas être {@code null})
     * @param b le nœud destination (ne doit pas être {@code null})
     * 
     * @throws IllegalArgumentException si a et b sont le même nœud ou si l'arête existe déjà
     */
    public void addArete(Noeud a, Noeud b){
        addArete(new Arete(a,b));
    }

    /**
     * Retire une arête du graphe.
     *
     * @param a l'arête à retirer
     * @return {@code true} si l'arête a été trouvée et supprimée, {@code false} sinon
     */
    public void removeArete(Arete a){
        aretes.remove(a);
    }

    /**
     * Retourne la liste des nœuds voisins d'un nœud donné.
     * <p>
     * Pour un graphe non orienté, les voisins sont tous les nœuds reliés par une arête.
     * Pour un graphe orienté, les voisins sont les nœuds accessibles via une arête sortante.
     * </p>
     *
     * @param n le nœud dont on cherche les voisins
     * @return une liste contenant tous les nœuds voisins (vide si le nœud n'a pas de voisins)
     */
    public List<Noeud> voisins(Noeud n) {
        List<Noeud> v = new ArrayList<>();
        for (Arete a : aretes) {
            if (a.getSource().equals(n))
                v.add(a.getTarget());
            else if (!oriente && a.getTarget().equals(n))
                v.add(a.getSource());
        }
        return v;
    }

    /**
     * Retourne une représentation textuelle du graphe.
     * <p>
     * Le format affiche d'abord la liste des nœuds avec leurs labels,
     * puis la liste des arêtes avec leurs extrémités.
     * </p>
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
    public List<Noeud> getNoeuds() {
        return noeuds;
    }

    public List<Arete> getEdges(Noeud noeud) {
    List<Arete> result = new ArrayList<>();
    for (Arete a : aretes) {
        if (a.getSource().equals(noeud) || a.getTarget().equals(noeud)) {
            result.add(a);
        }
    }
    return result;
}

    public Set<Noeud> getNodes() {
        return new HashSet<>(noeuds);
    }

}

