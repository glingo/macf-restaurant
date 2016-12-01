package restaurant.service;

import java.util.List;
import restaurant.model.commande.Commande;
import restaurant.model.commande.LigneDeCommande;
import restaurant.model.salle.Emplacement;
import restaurant.model.administratif.Serveur;
import restaurant.model.commande.StatutCommande;

public class CommandeManager {

    public float calculerTotal(Commande commande) {
        throw new UnsupportedOperationException();
    }

    private float calculerSousTotal(LigneDeCommande ligneDeCommande) {
        throw new UnsupportedOperationException();
    }

    public Commande create(Emplacement emplacement, Serveur serveur) {
        throw new UnsupportedOperationException();
    }

    public Commande create(Emplacement emplacement) {
        throw new UnsupportedOperationException();
    }

    public Commande update(Object commande) {
        throw new UnsupportedOperationException();
    }

    public List<Commande> getAll() {
        throw new UnsupportedOperationException();
    }

    public List<Commande> getCommandesByStatut(String codeStatut) {
        throw new UnsupportedOperationException();
    }

    public List<Commande> getCommandesByEmplacement(String numTable) {
        throw new UnsupportedOperationException();
    }

    public List<Commande> getCommandesByServeur(int code) {
        throw new UnsupportedOperationException();
    }

    public List<Commande> getCommandeByEmplacementAndStatut(Emplacement emplacement, StatutCommande statut) {
        throw new UnsupportedOperationException();
    }

    public List<Commande> getCommandeUnpaidByEmplacement(Emplacement emplacement) {
        throw new UnsupportedOperationException();
    }

    public Commande passToSelecting(LigneDeCommande ligneDeCommande) {
        throw new UnsupportedOperationException();
    }

    public Commande passToWaiting(LigneDeCommande ligneDeCommande) {
        throw new UnsupportedOperationException();
    }

    public Commande passToValidating(LigneDeCommande ligneDeCommande) {
        throw new UnsupportedOperationException();
    }

    public Commande passToConfirmed(LigneDeCommande ligneDeCommande) {
        throw new UnsupportedOperationException();
    }

    public Commande passToCancelled(LigneDeCommande ligneDeCommande) {
        throw new UnsupportedOperationException();
    }

    public Commande passToViewed(LigneDeCommande ligneDeCommande) {
        throw new UnsupportedOperationException();
    }

    public Commande passToPreparing(LigneDeCommande ligneDeCommande) {
        throw new UnsupportedOperationException();
    }

    public Commande passToReady(LigneDeCommande ligneDeCommande) {
        throw new UnsupportedOperationException();
    }

    public Commande passToPaid(LigneDeCommande ligneDeCommande) {
        throw new UnsupportedOperationException();
    }
}
