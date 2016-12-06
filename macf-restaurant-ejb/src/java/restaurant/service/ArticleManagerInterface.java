package restaurant.service;

import restaurant.model.catalogue.Article;
import restaurant.model.catalogue.Categorie;
import restaurant.model.catalogue.Ingredient;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ArticleManagerInterface {

    Article create(String libelle, float prix, String image, int valeurNutritive, boolean choixCuisson);

    void delete(Article article);

    List<Article> getAll();

    List<Article> getByCategorie(Categorie categorie);

    List<Article> getByIngredient(Ingredient ingeredient);

    boolean isDisponible(Article article);

    Article update(Article article);
    
}
