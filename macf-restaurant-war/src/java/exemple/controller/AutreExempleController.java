package exemple.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.controller.ActionController;
import restaurant.exempleEJB.SessionBeanLocal;

public class AutreExempleController extends ActionController {
    
    private SessionBeanLocal sessionBean ;

    private static final Logger LOG = Logger.getLogger(AutreExempleController.class.getName());

    
    
    public AutreExempleController() {
        sessionBean = lookupSessionBeanLocal();
        System.out.println("=============================================>>>>>>>  dans AutreExempleController !!!");
    }
    
    public String create(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        
        // on appelle un ejb via son nom en remote.
//        ArticleManagerInterface articleManager = get("java:global/macf-restaurant/macf-restaurant-ejb/article-manager");
        
        // l'ejb devient viable
//        LOG.info(articleManager == null ? "null !!!!" : articleManager.toString());
        
        
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
        
       
        
        return "article/list";
    }

    private SessionBeanLocal lookupSessionBeanLocal() {
        try {
            Context c = new InitialContext();
            return (SessionBeanLocal) c.lookup("java:global/macf-restaurant/macf-restaurant-ejb/SessionBean!restaurant.exempleEJB.SessionBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
