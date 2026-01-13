package fr.univlemans.graphe;

/**
 * Représente un nœud (vertex) dans un graphe.
 * <p>
 * Un nœud est identifié par un label (étiquette) textuelle unique qui le distingue
 * des autres nœuds du graphe. Un nœud peut être relié à d'autres nœuds via des arêtes.
 * </p>
 * <p>
 * <b>Invariants :</b>
 * <ul>
 *   <li>Le label d'un nœud ne peut pas être {@code null}</li>
 *   <li>Deux nœuds avec le même label sont considérés comme différents (identité d'objet)</li>
 * </ul>
 * </p>
 *
 * @see Arete
 * @see Graphe
 */
public class Noeud {
    /** Le label (étiquette) unique identifiant ce nœud. */
    String label;

    /**
     * Crée un nouveau nœud avec le label fourni.
     * <p>
     * Le label doit être fourni lors de la création et ne peut pas être modifié après.
     * </p>
     *
     * @param s le label du nœud (ne doit pas être {@code null})
     * 
     * @throws NullPointerException si s est {@code null}
     */
    public Noeud(String s){
        label = s;
    }

    /**
     * Retourne le label du nœud.
     * <p>
     * Le label est l'identifiant principal du nœud et est utilisé dans les affichages
     * et les représentations textuelles du graphe.
     * </p>
     *
     * @return le label du nœud
     */
    public String getLabel(){
        return this.label;
    }

    /**
     * Retourne une représentation textuelle du nœud.
     * <p>
     * La représentation textuelle est simplement le label du nœud.
     * </p>
     *
     * @return le label du nœud
     */
    @Override
    public String toString(){
        return this.label;
    }
}
