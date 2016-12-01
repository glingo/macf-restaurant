package restaurant.model.salle;

import java.util.ArrayList;
import java.util.List;
import restaurant.model.commande.Commande;

public class Emplacement {

    private String numero;
    private int nombrePlace;
    
    private Zone zone;
    private StatutEmplacement statut;
    private List<Commande> commandes = new ArrayList<>();
}
