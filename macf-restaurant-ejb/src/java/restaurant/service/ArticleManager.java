package restaurant.service;

import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import restaurant.model.catalogue.Article;
import restaurant.model.catalogue.Categorie;
import restaurant.model.catalogue.Ingredient;

@Stateless(name="article-manager")
public class ArticleManager implements ArticleManagerInterface {
    private static final Logger LOG = Logger.getLogger(ArticleManager.class.getName());
    
//    @EJB
//    private ArticleRepository repository;
    
    @PostConstruct
    public void construct(){
        LOG.info("sdqjsdfksdfkjfdskjsfdkfsjk");
        System.out.println("sdjsdfjnsd");
    }

    @Override
    public Article create(String libelle, float prix, String image, int valeurNutritive, boolean choixCuisson) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Article update(Article article) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Article> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Article> getByCategorie(Categorie categorie) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Article> getByIngredient(Ingredient ingeredient) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDisponible(Article article) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Article article) {
        throw new UnsupportedOperationException();
    }
}
