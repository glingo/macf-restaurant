package restaurant.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
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
    
//    public List<StatutEmplacement> getAllStatut(){
//        Collection<StatutEmplacement> allStatus = repository.findAllStatut();
//        return(List<StatutEmplacement>) allStatus;
//    }

    @Override
    public List<Emplacement> getByZone(Zone zone) {
        
        Collection<Emplacement> emplByZone = repository.findByZone(zone);
        return (List<Emplacement>) emplByZone;
        
    }
    
    @Override
    public Emplacement getById(Long id){
        if(id == null){
            return null;
        }
        
        return repository.findById(id);
    }
    
    
    @Override
    public Emplacement getByNumero(String numero){
        
        if(numero == null){
            return null;
            
        }
        
        return repository.findByNumero(numero);
        
        
    }
    
    
    
    public List<Emplacement> getByStatut(StatutEmplacement statut){
        
        Collection<Emplacement> emplByStatut = repository.findByStatut(statut);
        return (List<Emplacement>) emplByStatut;
    }
    
   
   
    @Override
   public Emplacement updateStatus(Long idEmplacement, String statut){
        if(statut == null || idEmplacement == null){
            return null;
        }
        
        statut = statut.trim();
        StatutEmplacement statuts[] = StatutEmplacement.values();
        Emplacement emplacement = getById(idEmplacement);
        
//        si jamais c'est pas le nom de l'enum mais libelle
//        if(emplacement != null){
//            for(StatutEmplacement s : statuts){
//                if(s.getLibelle().equals(statut)){
//                    System.out.println("================================>>> nouveau statut : "+s.getLibelle());
//                    emplacement.setStatut(s);
//                    emplacement = repository.update(emplacement);
//                }
//            }
            
//        }
        
        // ici c'est le nom de l'enum
        StatutEmplacement st = StatutEmplacement.valueOf(statut);
        if(emplacement != null && st != null){
            emplacement.setStatut(st);
            emplacement = repository.update(emplacement);
        }   
        return emplacement;                
    }

   
}
