package restaurant.service;

import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import restaurant.model.salle.Emplacement;
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
        throw new UnsupportedOperationException();
    }

    public List<Emplacement> getAll() {
        throw new UnsupportedOperationException();
    }

    public List<Emplacement> getByZone(Zone zone) {
        throw new UnsupportedOperationException();
    }

    public Emplacement passToVacant(Emplacement emplacement) {
        throw new UnsupportedOperationException();
    }

    public Emplacement passToOccupied(Emplacement emplacement) {
        throw new UnsupportedOperationException();
    }

    public Emplacement passToCleaning(Emplacement emplacement) {
        throw new UnsupportedOperationException();
    }
}
