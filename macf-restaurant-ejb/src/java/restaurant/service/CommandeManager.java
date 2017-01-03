package restaurant.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import restaurant.model.commande.Commande;
import restaurant.model.commande.LigneDeCommande;
import restaurant.model.salle.Emplacement;
import restaurant.model.administratif.Serveur;
import restaurant.model.commande.StatutCommande;
import restaurant.repository.CommandeRepository;
import restaurant.repository.EmplacementRepository;

@Stateless(name="commande-manager")
public class CommandeManager implements CommandeManagerInterface{
    

    private static final Logger LOG = Logger.getLogger(CommandeManager.class.getName());
   
    @EJB
    private CommandeRepository repository;
    
    @EJB
    private EmplacementRepository emplacementRepository;
    
    @PostConstruct
    public void construct(){
        
    }
    
    public float calculerTotal(Commande commande) {
        throw new UnsupportedOperationException();
    }

    private float calculerSousTotal(LigneDeCommande ligneDeCommande) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Commande create(Long idEmplacement) {
        Date date = new Date(); 
        Emplacement emplacement = emplacementRepository.findById(idEmplacement);
        
        // numero de commande temporaire
        String numero = String.valueOf(date.getTime());

         // essayer de recuperer une commande EN_SELECTION sur l'emplacement
        // si on en trouve unn on l'utilise
        // sinon il n'y a pas de commande EN_SELECTION sur l'emplacement, on créé un nouveau et le persister
        Commande commande = new Commande(date, numero, emplacement, StatutCommande.EN_SELECTION);
        repository.save(commande);
    
        return commande;
    }
     
    public Commande create(Emplacement emplacement, Serveur serveur) {
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

    @Override
    public Commande getByNumero(String numero) {
        
        // verification d'usage ...
        // numero != null ( peut etre fait dans le controller)
        
        if(numero == null) {
            return null;
        }
        
        return repository.findByNumero(numero);
    }
   
    public List<Commande> getByStatut(String codeStatut) {
        throw new UnsupportedOperationException();
    }

    public List<Commande> getByEmplacement(String numTable) {
        throw new UnsupportedOperationException();
    }

    public List<Commande> getByServeur(int code) {
        throw new UnsupportedOperationException();
    }

    public List<Commande> getByEmplacementAndStatut(Emplacement emplacement, StatutCommande statut) {
        throw new UnsupportedOperationException();
    }

    public List<Commande> getUnpaidByEmplacement(Emplacement emplacement) {
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

    @Override
    public Commande create(String idEmplacement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
