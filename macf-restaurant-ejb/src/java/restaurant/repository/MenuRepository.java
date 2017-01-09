
package restaurant.repository;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import restaurant.model.catalogue.Article;
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
    
    public Menu findMenuWithArticles (Long idMenu){
        if(idMenu == null){
            return null;
        }
        Menu m = findById(idMenu);
        if(m != null){
            Collection<Article> articles = findArticleByMenu(idMenu);
            m.setArticles(articles);
        }
        return m;
    }
    
    public List<Article> findArticleByMenu (Long idMenu){
        String rq01 = "select m.articles from Menu m where m.id = :paramId";
        Query qr01 = em.createQuery(rq01);
        qr01.setParameter("paramId", idMenu);
        List<Article> articles = qr01.getResultList();
        return articles;
    }
    
}
