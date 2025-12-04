package fr.univlemans.graphe;

/**
 * Classe principale pour tester les fonctionnalités du graphe.
 */
public class Main {
    /**
     * Méthode principale : crée et affiche un graphe exemple avec 4 nœuds et 3 arêtes.
     *
     * @param args les arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        Noeud a = new Noeud("a");
        Noeud b = new Noeud("b");
        Noeud c = new Noeud("c");
        Noeud d = new Noeud("d");
        Arete ab = new Arete(a, b);
        Arete ad = new Arete(a, d);
        Arete cd = new Arete(c, d);
        Graphe g = new Graphe(false);
        g.addArete(ab);
        g.addArete(ad);
        g.addArete(cd);
        g.addNoeud(a);
        g.addNoeud(b);
        g.addNoeud(c);
        g.addNoeud(d);
        System.out.println(g);
    }
}