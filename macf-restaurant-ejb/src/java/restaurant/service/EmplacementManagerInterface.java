
package restaurant.service;

import java.util.List;
import javax.ejb.Remote;
import restaurant.model.salle.Emplacement;
import restaurant.model.salle.Zone;
import restaurant.service.exceptions.EmplacementException;

@Remote
public interface EmplacementManagerInterface {
    
    Emplacement create(String numero, int nombrePlaces, String numeroZone);
    
    Emplacement update(Emplacement emplacement);
    
    void delete(Emplacement emplacement);
    
    List<Emplacement> getAll();
    
    List<Emplacement> getByZone(Zone zone);
    
    Emplacement passToVacant(Emplacement emplacement) throws EmplacementException;
    
    Emplacement passToOccupied(Emplacement emplacement);
    
    Emplacement passToCleaning(Emplacement emplacement);
            
    
}
