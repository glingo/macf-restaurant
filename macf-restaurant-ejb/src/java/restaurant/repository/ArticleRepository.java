package restaurant.repository;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import restaurant.model.catalogue.Article;
import restaurant.model.catalogue.Categorie;
import restaurant.model.catalogue.Ingredient;

@Stateless
public class ArticleRepository extends EntityRepository<Article> {

    public ArticleRepository() {
        super();
    }

    @Override
    protected Class<Article> getManagedClass() {
        return Article.class;
    }

    public Collection<Article> findByCategorie(Categorie cat) {
        CriteriaBuilder cb = getBuilder();
        CriteriaQuery<Article> q = cb.createQuery(this.getManagedClass());
        Root<Article> c = q.from(this.getManagedClass());
        Predicate equal = cb.equal(c.get("categorie"), cat);
        q.select(c).where(equal);
        TypedQuery<Article> query = em.createQuery(q);

        return query.getResultList();
    }

    public Collection<Article> findByIngredient(Ingredient ing) {
        CriteriaBuilder cb = getBuilder();
        CriteriaQuery<Article> q = cb.createQuery(this.getManagedClass());
        Root<Article> c = q.from(this.getManagedClass());
        Predicate equal = cb.equal(c.get("ingredient"), ing);
        q.select(c).where(equal);
        TypedQuery<Article> query = em.createQuery(q);

        return query.getResultList();
    }

}
