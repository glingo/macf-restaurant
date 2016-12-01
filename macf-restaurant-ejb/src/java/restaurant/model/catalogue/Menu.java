package restaurant.model.catalogue;

import java.util.ArrayList;
import java.util.List;
import restaurant.model.commande.LigneDeCommande;

public class Menu {

    private float prix;
    
    private List<Article>         articles         = new ArrayList<>();
    private List<LigneDeCommande> ligneDeCommandes = new ArrayList<>();
}
