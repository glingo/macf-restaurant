package restaurant.model.catalogue;

import restaurant.model.commande.LigneDeCommande;

import java.util.ArrayList;
import java.util.List;

public class Article {

    private String      libelle;
    private float       prix;
    private String      image;
    private int         valeursNutritives;
    private boolean     choixCuisson;
    
    private Categorie   categorie;
    private Tva         tva;
    
    private List<Ingredient>      ingredients      = new ArrayList<>();
    private List<Menu>            menus            = new ArrayList<>();
    private List<LigneDeCommande> ligneDeCommandes = new ArrayList<>();
}
