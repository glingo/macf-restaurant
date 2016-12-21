package restaurant.repository;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
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
    
    public Article findArticleWithIngredients(Long idArticle){
        if(idArticle == null){
            return null;
        }
        Article a = findById(idArticle);
        if(a != null){
            Collection<Ingredient> ingredients = findIngredientsByArticle(idArticle);
            a.setIngredients(ingredients);
        }
        return a;
    }
    
    private List<Ingredient> findIngredientsByArticle(Long idArticle){
        String rq01 = "select a.ingredients from Article a where a.id = :paramId";
        Query qr01 = em.createQuery(rq01);
        qr01.setParameter("paramId", idArticle);
        List<Ingredient> ingredients = qr01.getResultList();
        return ingredients;
    }

}
