package restaurant.model.paiement;

import restaurant.model.commande.Commande;

import java.util.Date;

public class Paiement {

    private Date datePaiement;
    private float montant;
    
    private ModePaiement mode;
    private Commande commande;
}
