
package restaurant.repository;

import javax.ejb.Stateless;
import restaurant.model.catalogue.Menu;

@Stateless
public class MenuRepository extends EntityRepository<Menu>{
    
    public MenuRepository(){
        super();
    }

    @Override
    protected Class<Menu> getManagedClass() {
        return Menu.class;
    }
    
}
