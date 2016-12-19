package controller;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.controller.ActionController;
import restaurant.service.EmplacementManagerInterface;

//extends d'ActionController dans kernel/controller/action controller ( permet l'appel de plusieurs méthodes)
public class EmplacementController extends ActionController {

    //appel du LOG pour pouvoir tester le controller 
    private static final Logger LOG = Logger.getLogger(EmplacementController.class.getName());

    private final EmplacementManagerInterface emplacementManager;

    public EmplacementController() {
        //dans le contructeur on appelle la methode get ( presente dans l'interface controller). Elle est le lookup.
        emplacementManager = get("java:global/macf-restaurant/macf-restaurant-ejb/emplacement-manager");
    }

    //Première etape : LOG des trucs à faire + redirection vers les JSP. BUT : faire le lien entre les JSP et le controller/
    public String create(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //vérification de l'absence ( ou non ) des infos nécessaires à la création d'un emplacement.

        LOG.info("Je crée un emplacement");

        return "emplacement/create";

    }

    public String delete(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        LOG.info("Je supprime un emplacement");
        return "emplacement/create";
    }

    public String list(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        LOG.info("J'affiche la liste de tous les emplacement");

        return "emplacement/list";
    }

    public String listZone(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        LOG.info("J'affiche la liste des emplacements par zone");

        return "emplacement/list";
    }

    public String updateStatut(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LOG.info("je change le statut de l'emplacement");

        return "emplacement/list";
    }

}
