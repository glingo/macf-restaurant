package restaurant.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import restaurant.model.salle.Emplacement;
import restaurant.model.salle.StatutEmplacement;
import restaurant.model.salle.Zone;
import restaurant.repository.EmplacementRepository;

@Stateless(name = "emplacement-manager")
public class EmplacementManager implements EmplacementManagerInterface {

    private static final Logger LOG = Logger.getLogger(EmplacementManager.class.getName());
    HashMap<String, String>erreurs = new HashMap<>();

    @EJB
    private EmplacementRepository repository;

    @PostConstruct
    public void construct() {
    }
  
    @Override
    public Emplacement create(String numero, int nombrePlaces, String numeroZone) {
        Emplacement emplacement = new Emplacement(numero, nombrePlaces, StatutEmplacement.LIBRE, null);

        if (repository != null) {
            repository.save(emplacement);
        }
        return emplacement;
    }

    @Override
    public void delete(Emplacement emplacement) {

        if (repository != null) {
            repository.delete(emplacement);
        }

    }

    @Override
    public Emplacement update(Emplacement emplacement) {

        if (repository != null) {
            repository.update(emplacement);

        }
        return emplacement;
    }

    @Override
    public List<Emplacement> getAll() {

        Collection<Emplacement> all = repository.findAll();
        return (List<Emplacement>) all;
    }

//    public List<Emplacement> getByZone(Zone zone) {
//        
//        Collection<Emplacement> emplByZone = repository.findByZone(zone);
//        return (List<Emplacement>) emplByZone;
//        
//    }
//    
//    public List<Emplacement> getByStatut(StatutEmplacement statut){
//        
//        Collection<Emplacement> emplByStatut = repository.findByStatut(statut);
//        return (List<Emplacement>) emplByStatut;
//    }
    @Override
    public Emplacement passToVacant(Emplacement emplacement){

        if (!emplacement.getStatut().equals(StatutEmplacement.EN_NETTOYAGE)){
            //une exception.
           //throw new BadStatusException bse(emplacement,StatutEmplacement.EN_NETTOYAGE);
        erreurs.put("StatutErreur", emplacement +" ne peut pas passer au statut :"+StatutEmplacement.LIBRE);
        
        
        
            
            /*
             public String creerUser(String nom, String email, String mdp) throws CustomException{
        HashMap<String, String> mp = new HashMap<>();
        if(nom == null || nom.trim().isEmpty()){
            mp.put("nomErr", "un nom est obligatoire");
        }
        
        
       
       if(mdp == null || mdp.length()<8){
            mp.put("mdpErr", "le mot de passe doit avoir au moins 8 caracteres");
        }
       
       if(!mp.isEmpty()){
           CustomException monException =new CustomException("echec de creation du client", CustomException.SAISIE_EX);
           monException.setErreurs(mp);
           throw  monException;
       
       }
       
       // code creation pour renvoyer un client
       
       // on triche on retourne un String pour l'exemple
       
       
       return "création du client terminée!";
        
    }
            
            
            */
                   
        }

        repository.updateStatut(emplacement, StatutEmplacement.LIBRE);
        LOG.info("Pass to vacant");
        return emplacement;

    }

    @Override
    public Emplacement passToOccupied(Emplacement emplacement) {

        if (emplacement.getStatut().equals(StatutEmplacement.OCCUPE) || emplacement.getStatut().equals(StatutEmplacement.EN_NETTOYAGE)) {
            LOG.warning("L'emplacement ne peut pas passer au statut demandé");
        } else {
            if (repository != null) {
                repository.updateStatut(emplacement, StatutEmplacement.OCCUPE);
                LOG.info("pass to occupied");
            } else {
                LOG.warning("Il manque la requète DAO");
            }
        }

        return emplacement;
    }

    @Override
    public Emplacement passToCleaning(Emplacement emplacement) {
        if (emplacement.getStatut().equals(StatutEmplacement.EN_NETTOYAGE) || emplacement.getStatut().equals(StatutEmplacement.LIBRE)) {
            LOG.warning("L'emplacement ne peut pas passer au statut demandé");
        } else {
            if (repository != null) {
                repository.updateStatut(emplacement, StatutEmplacement.EN_NETTOYAGE);
                LOG.info("pass to cleaning");
            } else {
                LOG.warning("Il manque la requète DAO");
            }
        }

        return emplacement;
    }

    @Override
    public List<Emplacement> getByZone(Zone zone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
