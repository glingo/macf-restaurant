package exemple.controller;

import java.util.logging.Logger;
import kernel.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import restaurant.service.ArticleManagerInterface;

public class DefaultController extends Controller {
    
    private static final Logger LOG = Logger.getLogger(DefaultController.class.getName());
    
    @Override
    public String handle(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        
        // on appelle un ejb via son nom en remote.
        ArticleManagerInterface articleManager = get("java:global/macf-restaurant/macf-restaurant-ejb/article-manager");
        
        // l'ejb devient viable
        LOG.info(articleManager == null ? "null !!!!" : articleManager.toString());
        
        return "home";
    }
}
