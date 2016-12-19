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
import restaurant.service.exceptions.EmplacementException;

@Stateless(name = "emplacement-manager")
public class EmplacementManager implements EmplacementManagerInterface {

    private static final Logger LOG = Logger.getLogger(EmplacementManager.class.getName());
   

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

    @Override
    public List<Emplacement> getByZone(Zone zone) {
        
        Collection<Emplacement> emplByZone = repository.findByZone(zone);
        return (List<Emplacement>) emplByZone;
        
    }
    
    public List<Emplacement> getByStatut(StatutEmplacement statut){
        
        Collection<Emplacement> emplByStatut = repository.findByStatut(statut);
        return (List<Emplacement>) emplByStatut;
    }
    
    @Override
    public Emplacement passToVacant(Emplacement emplacement) throws EmplacementException{

        if (!emplacement.getStatut().equals(StatutEmplacement.EN_NETTOYAGE)){

        throw new EmplacementException("Impossible de changer le statut", EmplacementException.STATUS_EX);
                   
        }

        repository.updateStatut(emplacement, StatutEmplacement.LIBRE);
        LOG.info("Pass to vacant");
        return emplacement;

    }

    @Override
    public Emplacement passToOccupied(Emplacement emplacement) throws EmplacementException{
        
        if(!emplacement.getStatut().equals(StatutEmplacement.LIBRE)){
            throw new EmplacementException("Impossible de changer le statut", EmplacementException.STATUS_EX);
        }
        
        repository.updateStatut(emplacement, StatutEmplacement.OCCUPE);
        LOG.info("pass to occupied");
        return emplacement;

    }

    @Override
    public Emplacement passToCleaning(Emplacement emplacement) throws EmplacementException {
        if(!emplacement.getStatut().equals(StatutEmplacement.OCCUPE)){
            throw new EmplacementException("Impossible de changer le statut", EmplacementException.STATUS_EX);
        }
        
        repository.updateStatut(emplacement, StatutEmplacement.EN_NETTOYAGE);
        LOG.info("pass to cleaning");
        return emplacement;
    }

   
}
