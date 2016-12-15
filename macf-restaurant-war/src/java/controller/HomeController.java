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
        
        // retrive in session :
        Employe employe = (Employe) getSession().getAttribute("user");
        
        if(employe == null) {
            // on a pas d'employé en session :
            // on devrait renvoyer vers le login ou home ?.
            //return "login";
            return "home";
        }
        
        // nous avons un employé connecté,
        // affichons lui sa page d'acceuil.
        
        String type = employe.getClass().getSimpleName().toLowerCase();
        return "employe/" + type;
    }
    
}
