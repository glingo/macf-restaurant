package restaurant.service;

import java.util.Collection;
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
public class EmplacementManager {
    private static final Logger LOG = Logger.getLogger(EmplacementManager.class.getName());
    
    @EJB
    private EmplacementRepository repository;
    
    
    
    @PostConstruct
    public void construct(){
    }
    
    public Emplacement create(String numero, int nombrePlaces, String numeroZone) {
        Emplacement emplacement = new Emplacement(numero, nombrePlaces, StatutEmplacement.LIBRE, null);
        
        if(repository != null){
            repository.save(emplacement);
        }
        return emplacement;
    }
    
    public void delete(Emplacement emplacement){
        
        if(repository != null){
            repository.delete(emplacement);
        }
        
    }
    
    public Emplacement update(Emplacement emplacement){
        
        if(repository != null){
            repository.update(emplacement);
            
        }
        return emplacement;
    }

    public List<Emplacement> getAll() {
        
        Collection<Emplacement> all = repository.findAll();
        return (List<Emplacement>) all ;
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

    public Emplacement passToVacant(Emplacement emplacement) {
        if(repository != null){
            repository.updateStatut(emplacement);
        }
        return emplacement;
    }

    public Emplacement passToOccupied(Emplacement emplacement) {
         if(repository != null){
            repository.updateStatut(emplacement);
        }
        return emplacement;
    }

    public Emplacement passToCleaning(Emplacement emplacement) {
         if(repository != null){
            repository.updateStatut(emplacement);
        }
        return emplacement;
    }
}
