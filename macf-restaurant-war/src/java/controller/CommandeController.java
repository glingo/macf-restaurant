
package controller;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.controller.ActionController;
import restaurant.service.CommandeManagerInterface;

//extends d'ActionController dans kernel/controller/action controller ( permet l'appel de plusieurs méthodes)
public class CommandeController extends ActionController{
    
    //appel du LOG pour pouvoir tester le controller 
      private static final Logger LOG = Logger.getLogger(CommandeController.class.getName());
    
    private final CommandeManagerInterface commandeManager;
      
       public CommandeController() {
        commandeManager = get("java:global/macf-restaurant/macf-restaurant-ejb/commande-manager");
    }
    
     public String listCommande(HttpServletRequest request, HttpServletResponse response) throws Exception{
         request.setAttribute("commandes", commandeManager.getAll());
         return "commande/commande";
     } 
     
       
}
