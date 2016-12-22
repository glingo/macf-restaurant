package restaurant.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import restaurant.model.administratif.Caissier;
import restaurant.model.administratif.Cuisinier;
import restaurant.model.administratif.Etablissement;
import restaurant.model.administratif.Serveur;
import restaurant.model.catalogue.Article;
import restaurant.model.catalogue.Categorie;
import restaurant.model.catalogue.Ingredient;
import restaurant.model.catalogue.Menu;
import restaurant.model.catalogue.Tva;
import restaurant.model.commande.Commande;
import restaurant.model.commande.LigneDeCommande;
import restaurant.model.commande.StatutCommande;
import restaurant.model.commande.TypeCuisson;
import restaurant.model.salle.Emplacement;
import restaurant.model.salle.StatutEmplacement;
import restaurant.model.salle.Zone;

@Stateless(name = "data-provider")
public class DataProvider implements Provider {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void provide() {
        System.out.println("=========================>>>> dans provide()");

        // creation de l'etablissement:
        Etablissement etablissement = new Etablissement("45196258700010", "La tablée", "14", "Rue fictive", "", "75016", "Paris", "0102030405");

        em.persist(etablissement);

        em.flush();
        // creation du staff:

        // les serveurs :
        Serveur michel = new Serveur("Jean", "michel", "0101", etablissement);
        Serveur jack = new Serveur("Martin", "jack", "0102", etablissement);
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
        em.persist(entrecote);
        em.persist(choucroute);
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
        Article coca = new Article("Coca", 3f, null, 0, false, Categorie.BOISSON, tva);
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

        //creation des zones 
        Zone z01 = new Zone("1");
        Zone z02 = new Zone("2");
        Zone z03 = new Zone("3");
        Zone z04 = new Zone("4");

        em.persist(z01);
        em.persist(z02);
        em.persist(z03);
        em.persist(z04);

        em.flush();

        //création des emplacements
        Emplacement empl01 = new Emplacement("1-4", 4, StatutEmplacement.LIBRE, z01);
        Emplacement empl02 = new Emplacement("2-2", 2, StatutEmplacement.EN_NETTOYAGE, z01);
        Emplacement empl03 = new Emplacement("3-6", 6, StatutEmplacement.OCCUPE, z03);
        Emplacement empl04 = new Emplacement("4-2", 2, StatutEmplacement.LIBRE, z01);
        Emplacement empl05 = new Emplacement("5-2", 2, StatutEmplacement.OCCUPE, z03);
        Emplacement empl06 = new Emplacement("6-4", 4, StatutEmplacement.LIBRE, z02);
        Emplacement empl07 = new Emplacement("7-6", 6, StatutEmplacement.EN_NETTOYAGE, z04);
        Emplacement empl08 = new Emplacement("8-2", 2, StatutEmplacement.LIBRE, z02);
        Emplacement empl09 = new Emplacement("9-4", 4, StatutEmplacement.OCCUPE, z04);
        Emplacement empl10 = new Emplacement("10-2", 2, StatutEmplacement.OCCUPE, z02);

        em.persist(empl01);
        em.persist(empl02);
        em.persist(empl03);
        em.persist(empl04);
        em.persist(empl05);
        em.persist(empl06);
        em.persist(empl07);
        em.persist(empl08);
        em.persist(empl09);
        em.persist(empl10);

        em.flush();

        //création de commandes
        Date d01 = new GregorianCalendar(2016, 12, 12).getTime();
        Commande c01 = new Commande(d01, "1", empl10, daniel, StatutCommande.EN_SELECTION);
        Date d02 = new GregorianCalendar(2016, 12, 13).getTime();
        Commande c02 = new Commande(d02, "2", empl02, michel, StatutCommande.EN_ATTENTE_AIDE);
        Date d03 = new GregorianCalendar(2016, 12, 15).getTime();
        Commande c03 = new Commande(d03, "3", empl04, jack, StatutCommande.EN_SELECTION);

        //création de lignes de commande et sous lignes de commande (menu)
        LigneDeCommande ldc01 = new LigneDeCommande(1, StatutCommande.PRET, null, soir);
        Collection<LigneDeCommande> sousLignesDeCommande01 = new ArrayList<>();
        LigneDeCommande lcg01 = new LigneDeCommande(1, null, null, flamiche);
        LigneDeCommande lcg02 = new LigneDeCommande(1, null, null, choucroute);
        LigneDeCommande lcg03 = new LigneDeCommande(1, null, null, cremeCaramel);

        lcg01.setLigneDeCommande(ldc01);
        lcg02.setLigneDeCommande(ldc01);
        lcg03.setLigneDeCommande(ldc01);
        ldc01.setSousLigneDeCommande(sousLignesDeCommande01);

        LigneDeCommande ldc02 = new LigneDeCommande(1, StatutCommande.PRET, TypeCuisson.ROUGE, entrecote);


        ldc01.setCommande(c01);
        ldc02.setCommande(c01);

        LigneDeCommande ldc03 = new LigneDeCommande(1, StatutCommande.ENVOYE, null, midi);
        Collection<LigneDeCommande> sousLignesDeCommande03 = new ArrayList<>();
        LigneDeCommande lcg04 = new LigneDeCommande(1, null, null, salade);
        LigneDeCommande lcg05 = new LigneDeCommande(1, null, TypeCuisson.SAIGNANT, steack);
        LigneDeCommande lcg06 = new LigneDeCommande(1, null, null, ile);
        lcg04.setLigneDeCommande(ldc03);
        lcg05.setLigneDeCommande(ldc03);
        lcg06.setLigneDeCommande(ldc03);
        ldc03.setSousLigneDeCommande(sousLignesDeCommande03);

        LigneDeCommande ldc04 = new LigneDeCommande(1, StatutCommande.PRET, null, croque);


        ldc03.setCommande(c02);
        ldc04.setCommande(c02);
        
        LigneDeCommande ldc05 = new LigneDeCommande(1, null, null, saumon);

        LigneDeCommande ldc06 = new LigneDeCommande(1, StatutCommande.PRET, null, enfant);
        Collection<LigneDeCommande> sousLignesDeCommande06 = new ArrayList<>();
        LigneDeCommande lcg07 = new LigneDeCommande(1, null, null, cremeChocolat);
        LigneDeCommande lcg08 = new LigneDeCommande(1, null, TypeCuisson.SAIGNANT, steack);
        lcg07.setLigneDeCommande(ldc06);
        lcg08.setLigneDeCommande(ldc06);
        sousLignesDeCommande06.add(new LigneDeCommande(1, null, TypeCuisson.SAIGNANT, steack));
        ldc06.setSousLigneDeCommande(sousLignesDeCommande06);

        ldc05.setCommande(c03);
        ldc06.setCommande(c03);

        // en général tu vas plutot faire :
        // commande.addLigneDeCommande(ligne);
        em.persist(c01);
        em.persist(c02);
        em.persist(c03);
        em.persist(ldc01);
        em.persist(ldc02);
        em.persist(ldc03);
        em.persist(ldc04);
        em.persist(ldc05);
        em.persist(ldc06);
        
        em.persist(lcg01);
        em.persist(lcg02);
        em.persist(lcg03);
        em.persist(lcg04);
        em.persist(lcg05);
        em.persist(lcg06);
        em.persist(lcg07);
        em.persist(lcg08);
       
        em.flush();
        
        // Création des ingrédients
        Ingredient steackHache = new Ingredient("Steack haché", true);
        Ingredient frite = new Ingredient("Frites", true);
        
        
        Collection<Ingredient> ingredientSteack = new ArrayList<>();
        ingredientSteack.add(steackHache);
        ingredientSteack.add(frite);
        steack.setIngredients(ingredientSteack);
        
        em.persist(steackHache);
        em.persist(frite);
        em.flush();

        System.out.println("================== fin jeu de test !!");
    }

}
