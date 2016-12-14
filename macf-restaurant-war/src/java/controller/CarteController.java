package controller;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.controller.ActionController;
import restaurant.model.catalogue.Categorie;
import restaurant.model.catalogue.Ingredient;
import restaurant.service.ArticleManagerInterface;
import restaurant.service.MenuManager;
import restaurant.service.MenuManagerInterface;

public class CarteController extends ActionController{
    
    private static final Logger LOG = Logger.getLogger(CarteController.class.getName());
    
    private final ArticleManagerInterface articleManager;
    private final MenuManagerInterface menuManager;
    
    public CarteController(){
        articleManager = get("java:global/macf-restaurant/macf-restaurant-ejb/article-manager");
        menuManager = get("java:global/macf-restaurant/macf-restaurant-ejb/menu-manager");
    }
    
    public String listArticle (HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("articles", articleManager.getAll());
        return "article/list";
    }
    
    public String listArticleByCategorie (HttpServletRequest request, HttpServletResponse response, Categorie categorie) throws Exception {
       request.setAttribute("articles", articleManager.getByCategorie(categorie));
        return "article/list";
    }
    
    public String listArticleByIngredient (HttpServletRequest request, HttpServletResponse response, Ingredient ingredient) throws Exception {
        request.setAttribute("articles", articleManager.getByIngredient(ingredient));
        return "article/list";
    }
    
    public String listMenu (HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("articles", menuManager.getAll());
        return "article/list";
    }
   
}
