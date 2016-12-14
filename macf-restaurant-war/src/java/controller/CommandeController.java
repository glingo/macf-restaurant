
package controller;

import java.util.logging.Logger;
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
      
}
