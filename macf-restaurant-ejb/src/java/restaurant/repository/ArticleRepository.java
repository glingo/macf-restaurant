package restaurant.repository;

import javax.ejb.Stateless;
import restaurant.model.catalogue.Article;

@Stateless
public class ArticleRepository extends EntityRepository<Article> {

    public ArticleRepository() {
        super();
    }

    @Override
    protected Class<Article> getManagedClass() {
        return Article.class;
    }
    
}
