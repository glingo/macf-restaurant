package restaurant.service;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import restaurant.model.commande.Commande;
import restaurant.model.commande.LigneDeCommande;
import restaurant.model.salle.Emplacement;
import restaurant.model.administratif.Serveur;
import restaurant.model.commande.StatutCommande;
import restaurant.repository.CommandeRepository;

@Stateless(name="commande-manager")
public class CommandeManager implements CommandeManagerInterface{

    private static final Logger LOG = Logger.getLogger(CommandeManager.class.getName());
    
    @EJB
    private CommandeRepository repository;
    
    @PostConstruct
    public void construct(){
        
    }
    
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
    
    //je récuoère toutes les commandes
    @Override
    public List<Commande> getAll() {
        Collection<Commande> all = repository.findAll();
        return (List<Commande>) all;
        
        
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
