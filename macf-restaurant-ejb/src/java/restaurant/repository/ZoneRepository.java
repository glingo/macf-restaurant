
package restaurant.repository;

import javax.ejb.Stateless;
import restaurant.model.salle.Zone;

@Stateless
public class ZoneRepository extends EntityRepository<Zone> {

    public ZoneRepository() {
    }
    
    
    @Override
    protected Class<Zone> getManagedClass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
