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
        
        Object submit = request.getParameter("login_submit");
        
        if(submit == null) {
            LOG.info("on renvois vers le formulaire.");
            // on renvois vers le formulaire.
            return "login";
        }
        
        String code = (String) request.getParameter("code");
        
        Employe employe = employeManager.login(code);
        
        if(employe == null) {
            LOG.info("Nous ne nous connaissons pas !");
            // on renvois vers le formulaire.
            danger("Votre code est inconnu !");
            return "login";
        }
        
        success("Bienvenue !");
        
        // store in session :
        getSession().setAttribute("user", employe);
        
        redirect(request.getContextPath() + "?section=home");
        
        // dispatch to jsp :
        String type = employe.getClass().getSimpleName().toLowerCase();
        
        LOG.info(String.format("c'est un %s !", type));
        
        LOG.exiting("SecurityController", "login");
        
        return "employe/" + type;
    }
    
    public void logout(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        
        HttpSession session = request.getSession(false);

        if(session != null) {
            session.removeAttribute("user");
            session.invalidate();
        }
        
        redirect(request.getContextPath());
    }
    
}