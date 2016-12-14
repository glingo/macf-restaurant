
package restaurant.repository;

import javax.ejb.Stateless;
import restaurant.model.commande.Commande;

@Stateless
public class CommandeRepository extends EntityRepository<Commande>{
    
     public CommandeRepository() {
        super();
    }
    
     @Override
    protected Class<Commande> getManagedClass() {
        return Commande.class;
    }
    
    
}
