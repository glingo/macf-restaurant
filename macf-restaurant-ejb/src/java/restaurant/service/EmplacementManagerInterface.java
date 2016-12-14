
package restaurant.service;

import java.util.List;
import restaurant.model.salle.Emplacement;
import restaurant.model.salle.Zone;


public interface EmplacementManagerInterface {
    
    Emplacement create(String numero, int nombrePlaces, String numeroZone);
    
    List<Emplacement> getAll();
    
    List<Emplacement> getByZone(Zone zone);
    
    Emplacement passToVacant(Emplacement emplacement);
    
    Emplacement passToOccupied(Emplacement emplacement);
    
    Emplacement passToCleaning(Emplacement emplacement);
            
    
}
