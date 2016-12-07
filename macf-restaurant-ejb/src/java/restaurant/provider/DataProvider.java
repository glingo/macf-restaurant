package restaurant.provider;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import restaurant.model.administratif.Caissier;
import restaurant.model.administratif.Cuisinier;
import restaurant.model.administratif.Etablissement;
import restaurant.model.administratif.Serveur;
import restaurant.model.catalogue.Article;
import restaurant.model.catalogue.Categorie;
import restaurant.model.catalogue.Menu;
import restaurant.model.catalogue.Tva;

@Stateless(name = "data-provider")
public class DataProvider implements Provider {
    
    @PersistenceContext
    protected EntityManager em;
    
    @Override
    public void provide(){
        
        // creation de l'etablissement:
        Etablissement etablissement = new Etablissement("45196258700010", "La tablée", "14", "Rue fictive", "", "75016", "Paris", "0102030405");
        
        em.persist(etablissement);
        
        em.flush();
        // creation du staff:
        
        // les serveurs :
        Serveur michel = new Serveur("Jean", "michel", "0101", etablissement);
        Serveur jack   = new Serveur("Martin", "jack", "0102", etablissement);
        Serveur daniel = new Serveur("Bernard", "daniel", "0103", etablissement);
        
        em.persist(michel);
        em.persist(jack);
        em.persist(daniel);
        
        // les cuisiniers:
        Cuisinier jean = new Cuisinier("Petit", "jean", "0201", etablissement);
        Cuisinier laurent = new Cuisinier("Robert", "laurent", "0202", etablissement);
        Cuisinier david = new Cuisinier("Durand", "david", "0203", etablissement);
        
        em.persist(jean);
        em.persist(laurent);
        em.persist(david);
        
        // les caissiers :
        Caissier louise = new Caissier("Dubois", "louise", "0301", etablissement);
        Caissier hugo = new Caissier("Leroy", "hugo", "0302", etablissement);
        
        em.persist(louise);
        em.persist(hugo);
        
        em.flush();
        
        //creation de TVA:
        Tva tvaBasse = new Tva(5.5f);
        Tva tva = new Tva(10f);
        Tva tvaHaute = new Tva(20f);
        
        em.persist(tvaBasse);
        em.persist(tva);
        em.persist(tvaHaute);
        
        em.flush();
        
        
        // creation des entree :
        Article salade = new Article("Salade de gésiers de volailles", 5f, null, 0, false, Categorie.ENTREE, tvaBasse);
        Article croque = new Article("Croque Monsieur", 5f, null, 0, false, Categorie.ENTREE, tvaBasse);
        Article quiche = new Article("Quiche lorraine", 5f, null, 0, false, Categorie.ENTREE, tvaBasse);
        Article flamiche = new Article("Flamiches aux poireaux", 5f, null, 0, false, Categorie.ENTREE, tvaBasse);
        Article tarte = new Article("Tarte aux poireaux", 5f, null, 0, false, Categorie.ENTREE, tvaBasse);
        
        
        em.persist(salade);
        em.persist(croque);
        em.persist(quiche);
        em.persist(flamiche);
        em.persist(tarte);
        
        em.flush();
        
        // creation des plats :
        Article steack = new Article("Steack", 10f, null, 0, true, Categorie.PLAT, tvaBasse);
        Article entrecote = new Article("Entrecôte bordelaise", 15f, null, 0, true, Categorie.PLAT, tvaBasse);
        Article choucroute = new Article("Choucroute", 12f, null, 0, false, Categorie.PLAT, tvaBasse);
        
        Article lotte = new Article("Filets de lotte provencale", 12f, null, 0, false, Categorie.PLAT, tvaBasse);
        Article bar = new Article("Filets de bar au four", 12f, null, 0, false, Categorie.PLAT, tvaBasse);
        Article saumon = new Article("Pavé de saumon à l’oseille", 12f, null, 0, false, Categorie.PLAT, tvaBasse);
        
        em.persist(steack);
        em.persist(lotte);
        em.persist(bar);
        em.persist(saumon);
        
        em.flush();
        
        // creation des desserts :
        Article clafouti = new Article("Clafoutis aux cerises", 6f, null, 0, false, Categorie.DESSERT, tvaBasse);
        Article cremeCaramel = new Article("Crème caramel", 6f, null, 0, false, Categorie.DESSERT, tvaBasse);
        Article cremeVanille = new Article("Crème à la vanille", 6f, null, 0, false, Categorie.DESSERT, tvaBasse);
        Article cremeChocolat = new Article("Crème au chocolat", 6f, null, 0, false, Categorie.DESSERT, tvaBasse);
        Article ile = new Article("Ile flottante", 6f, null, 0, false, Categorie.DESSERT, tvaBasse);
        Article flan = new Article("Flan pâtissier", 6f, null, 0, false, Categorie.DESSERT, tvaBasse);
        
        em.persist(clafouti);
        em.persist(cremeCaramel);
        em.persist(cremeVanille);
        em.persist(cremeChocolat);
        em.persist(ile);
        em.persist(flan);
        
        // creation des boissons :
        Article coca      = new Article("Coca", 3f, null, 0, false, Categorie.BOISSON, tva);
        Article cocaLight = new Article("Coca light", 3.5f, null, 0, false, Categorie.BOISSON, tva);
        Article icetea = new Article("Icetea", 3f, null, 0, false, Categorie.BOISSON, tva);
        Article orangina = new Article("Orangina", 3f, null, 0, false, Categorie.BOISSON, tva);
        
        Article heineken = new Article("Heineken", 4f, null, 0, false, Categorie.BOISSON, tva);
        
        em.persist(coca);
        em.persist(cocaLight);
        em.persist(icetea);
        em.persist(orangina);
        em.persist(heineken);
        
        em.flush();
        
        // creation des menus :
        Menu midi = new Menu("Menu midi", 15f, 
                salade, croque, quiche,
                steack, choucroute, lotte, 
                clafouti, ile, flan);
        
        em.persist(midi);
        
        em.flush();
        
        Menu enfant = new Menu("Menu enfant", 10f,
                steack,
                cremeCaramel, cremeChocolat, cremeVanille);
        
        em.persist(enfant);
        
        em.flush();
        
        Menu soir = new Menu("Menu soir", 20f,
                flamiche, tarte, quiche,
                entrecote, choucroute, saumon, bar,
                clafouti, ile, flan, cremeCaramel, cremeChocolat, cremeVanille);
        
        em.persist(soir);
        
        em.flush();
        
    }
    
}
