package controller;

import javax.ejb.EJB;
import kernel.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import restaurant.service.ArticleManager;
import restaurant.service.ArticleManagerInterface;

public class DefaultController extends Controller {
    
    @EJB
    ArticleManagerInterface articleManager;

    @Override
    public String handle(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        
        System.out.println(articleManager);
        return "lol";
    }
    
}
