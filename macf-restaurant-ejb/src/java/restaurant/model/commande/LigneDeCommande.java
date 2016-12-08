package restaurant.model.commande;

import java.io.Serializable;
import restaurant.model.catalogue.Menu;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import restaurant.model.catalogue.Article;

@Entity
public class LigneDeCommande implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantite;
    private float prix;
    
    @Enumerated(EnumType.STRING)
    private StatutCommande statut;
    @Enumerated(EnumType.STRING)
    private TypeCuisson cuisson;
    
    @OneToOne
    private Commande commande;
    @OneToOne
    private Menu menu;
    @OneToOne
    private LigneDeCommande ligneDeCommande;
    @OneToOne
    private Article article;
    
    @OneToMany
    private List<LigneDeCommande> sousLigneDeCommande = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
    }

    public TypeCuisson getCuisson() {
        return cuisson;
    }

    public void setCuisson(TypeCuisson cuisson) {
        this.cuisson = cuisson;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public LigneDeCommande getLigneDeCommande() {
        return ligneDeCommande;
    }

    public void setLigneDeCommande(LigneDeCommande ligneDeCommande) {
        this.ligneDeCommande = ligneDeCommande;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<LigneDeCommande> getSousLigneDeCommande() {
        return sousLigneDeCommande;
    }

    public void setSousLigneDeCommande(List<LigneDeCommande> sousLigneDeCommande) {
        this.sousLigneDeCommande = sousLigneDeCommande;
    }
    
    
}
