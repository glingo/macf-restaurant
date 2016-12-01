package restaurant.model.commande;

import restaurant.model.salle.Emplacement;
import restaurant.model.paiement.Paiement;
import restaurant.model.administratif.Serveur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {

    private Date    date;
    private String  numero;
    
    private Emplacement emplacement;
    private Serveur     serveur;
    
    private List<LigneDeCommande> ligneDeCommandes = new ArrayList<>();
    private List<Paiement>        paiements        = new ArrayList<>();
}
