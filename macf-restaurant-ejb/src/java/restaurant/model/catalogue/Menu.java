package restaurant.model.catalogue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import restaurant.model.commande.LigneDeCommande;

@Entity
public class Menu implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private float prix;
    
    @ManyToMany(mappedBy = "menus", cascade = CascadeType.PERSIST)
    private List<Article>         articles         = new ArrayList<>();
    
    @OneToMany
    private List<LigneDeCommande> ligneDeCommandes = new ArrayList<>();

    public Menu() {
    }

    public Menu(String libelle, float prix) {
        this.libelle = libelle;
        this.prix = prix;
        this.articles = new ArrayList<>();
        this.ligneDeCommandes = new ArrayList<>();
    }
    
    public Menu(String libelle, float prix, Article... articles) {
        this.libelle = libelle;
        this.prix = prix;
        
        if(articles != null) {
            for (Article article : articles) {
                addArticle(article);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    
    public final void addArticle(Article article){
        getArticles().add(article);
        article.addMenu(this);
    }

    public List<LigneDeCommande> getLigneDeCommandes() {
        return ligneDeCommandes;
    }

    public void setLigneDeCommandes(List<LigneDeCommande> ligneDeCommandes) {
        this.ligneDeCommandes = ligneDeCommandes;
    }
    
}
