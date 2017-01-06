package controller;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.controller.ActionController;
import restaurant.model.salle.Emplacement;
import restaurant.model.salle.StatutEmplacement;
import restaurant.service.EmplacementManagerInterface;
import restaurant.service.exceptions.EmplacementException;

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
//        //List<StatutEmplacement> status = emplacement
//        Emplacement empl = new Emplacement();
//        request.setAttribute("emplacement", empl);
        LOG.info("Je crée un emplacement");
        
        // pour trouvre tout les statutEmplacement :
        request.setAttribute("statuts", StatutEmplacement.values());
        
        StatutEmplacement[] values = StatutEmplacement.values();
        
        
        for (StatutEmplacement value : values) {
            LOG.info(value.name() + " : " + value.getLibelle());
        }
        
        // pour trouver un statutEmplacement depuis la request.
        
        // pour afficher la valeur d'une enumeration dans la jsp on appelle name();
        StatutEmplacement statut = StatutEmplacement.EN_NETTOYAGE;
        
        // <select name="statut">
        //      <option value="${ statut.name()}"> ${ statut.libelle } </option>
        // </select>
        String st = statut.name();
        LOG.info("Le statut : " + st);
        
        // pour retrouver l'énum depuis la valeur string :
        StatutEmplacement autre = StatutEmplacement.valueOf(st);
        LOG.info("Le statut retrouvé avec le name : " + autre.getLibelle());

        return "emplacement/create";

    }

    public String delete(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        LOG.info("Je supprime un emplacement");
        return "emplacement/create";
    }

    public String list(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LOG.info("Afficher liste emplacement");
        
        LOG.info("test refresh");
        
        request.setAttribute("today", new Date());
        
        LOG.info("test réussi : rafraichissement de la page toutes les 5 minutes");
            
        List<Emplacement> emplacements= emplacementManager.getAll();
        request.setAttribute("emplacements", emplacements);
        
        LOG.info("affichage reussi");
        
        
        return "emplacement/list";
        
   
        
    }

    public String listZone(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        LOG.info("J'affiche la liste des emplacements par zone");

        return "emplacement/list";
    }
    
    public String listDetailEmplacement(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //on recupere le numero de l'emplacement en parametre ( emplacement qu'on a choisi)
        String idString = (String) request.getParameter("id");
        Long id = Long.valueOf(idString);
        LOG.info("afficher : "+ id);
        //on retrouve l'emplacement qui correspond à ce numero
        Emplacement emplacement = emplacementManager.getById(id);
        
        System.out.println("===============>>> emplacement : "+emplacement);
        
        //place l'objet emplacement identifié dans le scope request.
        request.setAttribute("empl01", emplacement);
        
        
        return "emplacement/detailEmplacement";
    }
    
    

    public String updateStatut(HttpServletRequest request, HttpServletResponse response)
            throws EmplacementException, Exception {
        
        
        
        
        //exemple scope application
        // request.getServletContext().setAttribute("clef", "dans scope application");
        
        //request.getParameter( idEmplacement ( contenu dans l'url ?section=""url="", id...).
        //ici on recupere les parametre donc l'id de lemplacement. 
        //ensuiteon appel la methode fibnd by id avec en parametre l'id des paramrtres
        //emplacement p = emplacementManager.findById(idPArametre)
        //enfin on stock dans le scope request l'objet emplacement sur lequel on a appliqué la methode update Statut.
        //la jsp peut donc y acceder via la clé "emplacement".
            //request.setAttribute("emplacement", emplacementManager.passToCleaning(p));
            
        //recupere id de l'emplacement choisi
        String idString = request.getParameter("id");
        //conversion String Long
        Long id = Long.valueOf(idString);
        //recuperation du futur statut choisi pour l'emplacement.
        String newStatus = request.getParameter("statut");
        
        LOG.info("afficher : " + id);
        LOG.info("afficher : " + newStatus);
        
        emplacementManager.updateStatus(id, newStatus);
        
 
       // System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< dans updateStatut !!!");
        
        //retour à la liste des emplacements. en appelant le methode list. 
        
        success("Le statut de l'emplacement a bien été changé (>.<)");
        return list(request, response);
       
        
    }

}
