package controller;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.ActionController;
import restaurant.model.administratif.Caissier;
import restaurant.model.administratif.Cuisinier;
import restaurant.model.administratif.Employe;
import restaurant.model.administratif.Serveur;
import restaurant.service.EmployeManager;

public class SecurityController extends ActionController {

    private static final Logger LOG = Logger.getLogger(SecurityController.class.getName());
    
    private final EmployeManager employeManager;
    
    public SecurityController() {
        employeManager = get("java:global/macf-restaurant/macf-restaurant-ejb/employe-manager");
    }
    
    public String login(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        
        LOG.entering("SecurityController", "login");
        
        Object submit = request.getParameter("login_submit");
        LOG.info(submit != null ? submit.toString() : "login_submit : null");
        
        if(submit == null) {
            LOG.info("on renvois vers le formulaire.");
            // on renvois vers le formulaire.
            return "login";
        }
        
        String code = (String) request.getParameter("code");
        LOG.info(code != null ? code : "code : null");
        
        Employe employe = employeManager.login(code);
        
        LOG.exiting("SecurityController", "login");
        
        if(employe instanceof Serveur) {
            LOG.info("c'est un serveur !");
            LOG.info("on envois vers employe/serveur !");
            return "employe/serveur";
        }
        
        if(employe instanceof Cuisinier) {
            LOG.info("c'est un cuisinier !");
            return "employe/cuisinier";
        }
        
        if(employe instanceof Caissier) {
            LOG.info("c'est un caissier !");
            return "employe/caissier";
        }
        
        // on renvois vers le formulaire.
        return "login";
    }
    
}