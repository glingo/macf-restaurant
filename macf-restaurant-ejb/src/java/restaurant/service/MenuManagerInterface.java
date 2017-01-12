
package restaurant.service;

import java.util.List;
import javax.ejb.Remote;
import restaurant.model.catalogue.Menu;

@Remote
public interface MenuManagerInterface {

    public List<Menu> getAll();

    public Menu getArticleByMenu(Long idMenu);

   
    
}
