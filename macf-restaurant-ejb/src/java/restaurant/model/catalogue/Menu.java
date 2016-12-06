package restaurant.model.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import restaurant.model.commande.LigneDeCommande;

@Entity
public class Menu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float prix;
    
    @OneToMany
    private List<Article>         articles         = new ArrayList<>();
    @OneToMany
    private List<LigneDeCommande> ligneDeCommandes = new ArrayList<>();
}
