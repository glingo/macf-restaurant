package controller;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.controller.ActionController;
import restaurant.model.catalogue.Article;
import restaurant.model.catalogue.Categorie;
import restaurant.service.ArticleManager;

public class CarteController extends ActionController{
    
    private static final Logger LOG = Logger.getLogger(CarteController.class.getName());
    
    private final ArticleManager articleManager;
    
    public CarteController(){
        articleManager = get("java:global/macf-restaurant/macf-restaurant-ejb/article-manager");
    }
    
    public List<Article> getAll(){
        Collection<Article> all;
        all = articleManager.getAll();
        return (List<Article>) all;
    }
    
    public List<Article> getByCat (Categorie cat){
        Collection<Article> byCat;
        byCat = articleManager.getByCategorie(cat);
        return (List<Article>) byCat;
    }
   
}
