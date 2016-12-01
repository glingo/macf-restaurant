package restaurant.service;

import java.util.List;
import restaurant.model.catalogue.Article;
import restaurant.model.catalogue.Categorie;
import restaurant.model.catalogue.Ingredient;

public class ArticleManager {

    public Article create(String libelle, float prix, String image, int valeurNutritive, boolean choixCuisson) {
        throw new UnsupportedOperationException();
    }

    public Article update(Article article) {
        throw new UnsupportedOperationException();
    }

    public List<Article> getAll() {
        throw new UnsupportedOperationException();
    }

    public List<Article> getByCategorie(Categorie categorie) {
        throw new UnsupportedOperationException();
    }

    public List<Article> getByIngredient(Ingredient ingeredient) {
        throw new UnsupportedOperationException();
    }

    public boolean isDisponible(Article article) {
        throw new UnsupportedOperationException();
    }

    public void delete(Article article) {
        throw new UnsupportedOperationException();
    }
}
