package controller;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.controller.ActionController;
import restaurant.model.commande.Commande;
import restaurant.model.commande.LigneDeCommande;
import restaurant.service.CommandeManagerInterface;

//extends d'ActionController dans kernel/controller/action controller ( permet l'appel de plusieurs méthodes)
public class CommandeController extends ActionController {

    //appel du LOG pour pouvoir tester le controller 
    private static final Logger LOG = Logger.getLogger(CommandeController.class.getName());

    private final CommandeManagerInterface commandeManager;

    public CommandeController() {
        commandeManager = get("java:global/macf-restaurant/macf-restaurant-ejb/commande-manager");
    }

    public String listCommande(HttpServletRequest request, HttpServletResponse response) throws Exception {

        LOG.info("Dans le controller");

        List<Commande> commandes = commandeManager.getAll();

        request.setAttribute("commandes", commandes);
        
        Date d = new Date();
        request.setAttribute("today", d);
        
        return "commande/affichageCommande";
    }

    public String listDetailCommande(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // on recupère depuis la request le numero commande (qui doit etre unique)
        String numero = (String) request.getParameter("numero");
        
        LOG.info(String.format("Le numero dans la request est : %s", numero));
 
        // on utilise le manager pour recuperer la commande (Entity)
        Commande commande = commandeManager.getByNumero(numero);
               
        if(commande == null) {
            // dans le cas ou nous n'avons renseigné de numero de commande
            danger("La commande que vous demandez n'existe pas.");
            // on renvois l'utilisateur vers la liste avec un message d'erreur.
            return listCommande(request, response);
        }
        
        // on injecte la commande dans la request (setAttribute)
        // à partir d'ici nous sommes sûr que la commande existe.
        
        request.setAttribute("commande", commande);
        
        // on renvoie vers la jsp le détail commande.
        return "commande/detailCommande";
        
    }
    
    public String create(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        
        
    }
    
    
    
}
