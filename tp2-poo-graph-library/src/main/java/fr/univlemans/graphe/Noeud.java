package fr.univlemans.graphe;

/**
 * Représente un nœud dans un graphe.
 * <p>
 * Un nœud est identifié par un label (étiquette) textuelle.
 * Cette classe fournit les méthodes basiques pour accéder et afficher le label.
 */
public class Noeud {
    /** Le label (étiquette) du nœud. */
    String label;

    /**
     * Crée un nouveau nœud avec le label fourni.
     *
     * @param s le label du nœud
     */
    public Noeud(String s){
        label = s;
    }

    /**
     * Retourne le label du nœud.
     *
     * @return le label du nœud
     */
    public String getLabel(){
        return this.label;
    }

    /**
     * Retourne une représentation textuelle du nœud (son label).
     *
     * @return le label du nœud
     */
    @Override
    public String toString(){
        return this.label;
    }
}
