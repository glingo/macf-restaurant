package restaurant.model.commande;

import restaurant.model.catalogue.Menu;
import java.util.ArrayList;
import restaurant.model.catalogue.Article;

public class LigneDeCommande {

    private int quantite;
    private float prix;
    public Commande commande;
    public StatutCommande statut;
    public TypeCuisson cuisson;
    public Menu menu;
    public LigneDeCommande ligneDeCommande;
    public ArrayList<LigneDeCommande> sousLigneDeCommande = new ArrayList<LigneDeCommande>();
    public Article article;
}
