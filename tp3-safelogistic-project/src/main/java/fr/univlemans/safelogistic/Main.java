package fr.univlemans.safelogistic;
import fr.univlemans.graphe.Graphe;

/**
 * Classe de test pour valider les fonctionnalités du TP3
 **/
public class Main {

    public static void main(String[] args) {
        Depot depotPrincipal = new Depot("DEPOT_SUD");
        Restaurant burgerPalace = new Restaurant("BURGER_PALACE", 15);
        Client clientMarius = new Client("CLIENT_MARIUS", "12 Rue de la Paix");

        Lieu intersectionA = new Depot("INTER_A");
        Lieu intersectionB = new Depot("INTER_B");

        Graphe ville = new Graphe(false);

        ville.addArete(new StreetSegment(depotPrincipal, intersectionA, 5));
        ville.addArete(new StreetSegment(intersectionA, burgerPalace, 3));
        ville.addArete(new StreetSegment(burgerPalace, intersectionB, 10));
        ville.addArete(new StreetSegment(intersectionB, clientMarius, 4));
        ville.addArete(new StreetSegment(depotPrincipal, burgerPalace, 15));

        DeliveryManager manager = new DeliveryManager(ville);

        System.out.println("--- Simulation SafeLogistic en cours ---");
        manager.planDelivery(depotPrincipal, burgerPalace, clientMarius);

    }
}