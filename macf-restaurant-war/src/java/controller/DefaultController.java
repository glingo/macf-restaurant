package controller;

import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Startup;
import kernel.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import restaurant.service.ArticleManager;
//import restaurant.service.ArticleManager;
import restaurant.service.ArticleManagerInterface;

public class DefaultController extends Controller {
    
    private static final Logger LOG = Logger.getLogger(DefaultController.class.getName());
    
    @EJB
    private ArticleManagerInterface articleManager;

    @Override
    public String handle(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        
//        System.out.println(articleManager);
        LOG.info(articleManager == null ? "null !!!!" : articleManager.toString());
        return "lol";
    }
    
}
