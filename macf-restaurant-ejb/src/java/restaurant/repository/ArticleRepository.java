package restaurant.repository;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import restaurant.model.catalogue.Article;
import restaurant.model.catalogue.Categorie;

@Stateless
public class ArticleRepository extends EntityRepository<Article> {

    private Class<Article> clazz;
    
    public ArticleRepository() {
        super();
    }

    @Override
    protected Class<Article> getManagedClass() {
        return Article.class;
    }

    public Collection<Article> findByCategorie(Categorie cat) {
        CriteriaQuery q = getBuilder().createQuery(this.clazz);
        Root c = q.from(this.clazz);
        q.select(c);

        TypedQuery query = em.createQuery(q);
        return query.getResultList();
    }

}
