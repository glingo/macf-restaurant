
package restaurant.service;

import java.util.List;
import javax.ejb.Remote;
import restaurant.model.salle.Emplacement;
import restaurant.model.salle.Zone;

@Remote
public interface EmplacementManagerInterface {
    
    public Emplacement create(String numero, int nombrePlaces, String numeroZone);
    
    public Emplacement update(Emplacement emplacement);
    
    public Emplacement updateStatus(Long idEmplacement, String statut);
    
    public void delete(Emplacement emplacement);
    
    public List<Emplacement> getAll();
    
    public List<Emplacement> getByZone(Zone zone);
    
    public Emplacement getByNumero(String numero);
    
    public Emplacement getById(Long id);
            
    
}
