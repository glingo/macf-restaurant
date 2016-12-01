package restaurant.service;

import java.util.List;
import javax.ejb.Stateless;
import restaurant.model.catalogue.Article;
import restaurant.model.catalogue.Categorie;
import restaurant.model.catalogue.Ingredient;

@Stateless
public class ArticleManager implements ArticleManagerInterface {

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
