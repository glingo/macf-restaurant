package restaurant.repository;

import restaurant.model.catalogue.Article;

public class ArticleRepository extends EntityRepository<Article> {

    public ArticleRepository() {
        super();
    }

    @Override
    protected Class<Article> getManagedClass() {
        return Article.class;
    }
    
}
