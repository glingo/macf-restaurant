package restaurant.model.commande;

import java.io.Serializable;
import restaurant.model.catalogue.Menu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Commande commande;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Menu menu;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private LigneDeCommande ligneDeCommande;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Article article;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Collection<LigneDeCommande> sousLigneDeCommande;

    public LigneDeCommande() {
        this.sousLigneDeCommande = new ArrayList<>();
    }

    public LigneDeCommande(int quantite, StatutCommande statut, TypeCuisson cuisson, Menu menu) {
        this.quantite = quantite;
        this.statut = statut;
        this.cuisson = cuisson;
        this.menu = menu;
        prix = menu.getPrix();
    }

    public LigneDeCommande(int quantite, StatutCommande statut, TypeCuisson cuisson, Article article) {
        this.quantite = quantite;
        this.statut = statut;
        this.cuisson = cuisson;
        this.article = article;
        prix = article.getPrix();
    }

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

    public Collection<LigneDeCommande> getSousLigneDeCommande() {
        return sousLigneDeCommande;
    }

    public void setSousLigneDeCommande(Collection<LigneDeCommande> sousLigneDeCommande) {
        this.sousLigneDeCommande = sousLigneDeCommande;
    }
    
    public String getLibelle(){
        if(article != null ){
            return article.getLibelle();
        }else {
            return menu.getLibelle();
        }
    }

}
