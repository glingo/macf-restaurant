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
    
    public String list (HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("articles", articleManager.getAll());
        return "article/list";
    }
    
    public String listByCategorie (HttpServletRequest request, HttpServletResponse response, Categorie categorie) throws Exception {
       request.setAttribute("articles", articleManager.getByCategorie(categorie));
        return "article/list";
    }
   
}
