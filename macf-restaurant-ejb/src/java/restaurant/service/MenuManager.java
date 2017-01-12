
package restaurant.service;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import restaurant.model.catalogue.Menu;
import restaurant.repository.MenuRepository;

@Stateless(name="menu-manager")
public class MenuManager implements MenuManagerInterface{
    
    private static final Logger LOG = Logger.getLogger(MenuManager.class.getName());
    
    @EJB
    private MenuRepository repository;
    
    @Override
    public List<Menu> getAll(){
        Collection<Menu> all = repository.findAll();
        return (List<Menu>) all;
    }
    
   
    @Override
    public Menu getArticleByMenu (Long idMenu){
        Menu menu = repository.findMenuWithArticles(idMenu);
        return menu;
    } 
    
}
