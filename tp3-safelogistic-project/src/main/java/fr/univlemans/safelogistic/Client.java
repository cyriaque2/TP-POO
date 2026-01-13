package fr.univlemans.safelogistic;

/**
 * Représente un client destinataire d'une livraison et contenant son adresse.
 */
public class Client extends Lieu {
    /** Adresse de livraison du client. */
    private final String adresse;

    /**
     * Crée un client avec son label et son adresse.
     *
     * @param label le nom/identifiant du client
     * @param adresse l'adresse de livraison
     */
    public Client(String label, String adresse) {
        super(label);
        this.adresse = adresse;
    }

    /**
     * Retourne l'adresse de livraison du client.
     *
     * @return l'adresse du client
     */
    public String getAdresse() {
        return adresse;
    }
}
