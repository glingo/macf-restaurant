package controller;

import java.util.logging.Logger;
import kernel.controller.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import restaurant.model.administratif.Employe;

public class HomeController extends Controller {
    private static final Logger LOG = Logger.getLogger(HomeController.class.getName());

    @Override
    public String doHandle(HttpServletRequest request, HttpServletResponse response) {
        
        LOG.entering("HomeController", "doHandle");
        
        // retrieve from session :
        Employe employe = (Employe) getSession().getAttribute("user");
        
        if(employe == null) {
            // on a pas d'employé en session :
            // on devrait renvoyer vers le login ou home ?.
            //return "login";
            
            LOG.info("Nous n'avons pas d'employé en session, redirection vers home");
            LOG.exiting("HomeController", "doHandle");
            return "home";
        }
        
        // nous avons un employé connecté,
        // affichons lui sa page d'acceuil.
        String type = employe.getClass().getSimpleName().toLowerCase();
        
        
//        LOG.info(type);
//        LOG.info(isGranted(Serveur.class) ? "C'est un serveur" : "ce n'est pas un serveur");
        
        LOG.exiting("HomeController", "doHandle");
        return "employe/" + type;
    }
    
}
