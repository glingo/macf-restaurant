package controller;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kernel.controller.ActionController;
import restaurant.model.administratif.Employe;
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
        
        // validation de la request.
        Object submit = request.getParameter("login_submit");
        
        if(submit == null) {
            LOG.info("on renvois vers le formulaire.");
            // on renvois vers le formulaire.
            return "login";
        }
        
        String code = (String) request.getParameter("code");
        
        // on appelle le code métier (ejb)
        
        Employe employe = employeManager.login(code);
        
        // on met des objets dans la request ( pour la jsp )
        // request.setAttribute("emp", employe);
        
        if(employe == null) {
            LOG.info("Nous ne nous connaissons pas !");
            // on renvois vers le formulaire.
            danger("Votre code est inconnu !");
            return "login";
        }
        
        // on met un message pour l'utilisateur.
        success("Bienvenue !");
        
        // store in session :
        getSession().setAttribute("user", employe);
        
        // on traite la request.
        redirect();
        
        LOG.exiting("SecurityController", "login");
        return null;
    }
    
    public void logout(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        
        HttpSession session = request.getSession(false);

        if(session != null) {
            session.removeAttribute("user");
            session.invalidate();
            success("Vous etes bien déconnecté !");
        }
        
        redirect(request.getContextPath());
    }
    
}