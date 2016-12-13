package controller;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.controller.ActionController;
import restaurant.model.catalogue.Categorie;
import restaurant.model.catalogue.Ingredient;
import restaurant.service.ArticleManager;
import restaurant.service.ArticleManagerInterface;

public class CarteController extends ActionController{
    
    private static final Logger LOG = Logger.getLogger(CarteController.class.getName());
    
    private final ArticleManagerInterface articleManager;
    
    public CarteController(){
        articleManager = get("java:global/macf-restaurant/macf-restaurant-ejb/article-manager");
    }
    
    public String list (HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("articles", articleManager.getAll());
        return "article/list";
    }
    
    public String listByCategorie (HttpServletRequest request, HttpServletResponse response, Categorie categorie) throws Exception {
       request.setAttribute("articles", articleManager.getByCategorie(categorie));
        return "article/list";
    }
    
    public String listByIngredient (HttpServletRequest request, HttpServletResponse response, Ingredient ingredient) throws Exception {
        request.setAttribute("articles", articleManager.getByIngredient(ingredient));
        return "article/list";
    }
   
}
