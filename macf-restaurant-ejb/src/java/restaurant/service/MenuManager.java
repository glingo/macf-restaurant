
package restaurant.service;

import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import restaurant.repository.MenuRepository;

@Stateless(name="menu-manager")
public class MenuManager {
    
    private static final Logger LOG = Logger.getLogger(MenuManager.class.getName());
    
    @EJB
    private MenuRepository repository;
    
}
