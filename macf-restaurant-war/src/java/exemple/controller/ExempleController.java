package exemple.controller;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.controller.ActionController;
import restaurant.model.catalogue.Article;
import restaurant.service.ArticleManagerInterface;

public class ExempleController extends ActionController {

    private static final Logger LOG = Logger.getLogger(ExempleController.class.getName());

    private final ArticleManagerInterface articleManager;
    
    public ExempleController() {
        articleManager = get("java:global/macf-restaurant/macf-restaurant-ejb/article-manager");
    }
    
    public String create(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        
        // on appelle un ejb via son nom en remote.
//        ArticleManagerInterface articleManager = get("java:global/macf-restaurant/macf-restaurant-ejb/article-manager");
        
        // l'ejb devient viable
//        LOG.info(articleManager == null ? "null !!!!" : articleManager.toString());
        
        Article article = articleManager.create("test", 0, "", 0, true);
        LOG.info(article.getId().toString());
        return "home";
    }
    
    public String delete(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        
        // on appelle un ejb via son nom en remote.
//        ArticleManagerInterface articleManager = get("java:global/macf-restaurant/macf-restaurant-ejb/article-manager");
        
        // l'ejb devient viable
//        LOG.info(articleManager == null ? "null !!!!" : articleManager.toString());
        
        return "home";
    }
    
    public String list(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        
        
        // on appelle un ejb via son nom en remote.
//        ArticleManagerInterface articleManager = get("java:global/macf-restaurant/macf-restaurant-ejb/article-manager");
        
        // l'ejb devient viable
//        LOG.info(articleManager == null ? "null !!!!" : articleManager.toString());
        
        request.setAttribute("articles", articleManager.getAll());
        
        return "article/list";
    }
}
