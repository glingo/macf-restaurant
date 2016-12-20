package controller;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.controller.ActionController;
import restaurant.model.catalogue.Categorie;
import restaurant.service.ArticleManagerInterface;
import restaurant.service.MenuManagerInterface;

public class CarteController extends ActionController {

    private static final Logger LOG = Logger.getLogger(CarteController.class.getName());

    private final ArticleManagerInterface articleManager;
    private final MenuManagerInterface menuManager;

    public CarteController() {
        articleManager = get("java:global/macf-restaurant/macf-restaurant-ejb/article-manager");
        menuManager = get("java:global/macf-restaurant/macf-restaurant-ejb/menu-manager");
    }

    public String afficherCarte(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("categories", Categorie.values());
        if (request.getParameter("categorie") != null) {
            String cat = request.getParameter("categorie");
            Categorie categorie = Categorie.valueOf(cat);
            request.setAttribute("articles", articleManager.getByCategorie(categorie));
        }
        return "article/list";
    }

    public String listArticle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("articles", articleManager.getAll());
        return "article/list";
    }

    public String listArticleByCategorie(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            String cat = request.getParameter("categorie");
            Categorie categorie = Categorie.valueOf(cat);
            request.setAttribute("articles", articleManager.getByCategorie(categorie));
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return "article/list";
    }

//    public String listArticleByIngredient (HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String ing = request.getParameter("ingredient");
//        Ingredient ingredient = Ingredient.valueOf(ing);
//        request.setAttribute("articles", articleManager.getByIngredient(ingredient));
//        return "article/list";
//    }
    public String listMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("articles", menuManager.getAll());
        return "article/list";
    }

}
