package restaurant.service;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import restaurant.model.catalogue.Article;
import restaurant.model.catalogue.Categorie;
import restaurant.model.catalogue.Ingredient;
import restaurant.repository.ArticleRepository;

@Stateless(name="article-manager")
public class ArticleManager implements ArticleManagerInterface {
    
    private static final Logger LOG = Logger.getLogger(ArticleManager.class.getName());
    
    @EJB
    private ArticleRepository repository;
    
    @PostConstruct
    public void construct(){
    }

    @Override
    public Article create(String libelle, float prix, String image, int valeurNutritive, boolean choixCuisson) {
        
        Article article = new Article(libelle, prix, image, valeurNutritive, choixCuisson);
        
        if(repository != null) {
            repository.save(article);
        }
        
        return article;
    }

    @Override
    public Article update(Article article) {
        
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Article> getAll() {
        Collection<Article> all = repository.findAll();
        return (List<Article>) all;
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
