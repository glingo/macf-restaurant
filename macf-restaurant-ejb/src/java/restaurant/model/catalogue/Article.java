package restaurant.model.catalogue;

import java.io.Serializable;
import restaurant.model.commande.LigneDeCommande;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Article implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String      libelle;
    private float       prix;
    private String      image;
    private int         valeursNutritives;
    private boolean     choixCuisson;
    
    @Enumerated
    private Categorie   categorie;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Tva         tva;
    
    @OneToMany
    private List<Ingredient>      ingredients      = new ArrayList<>();
    
    @ManyToMany
    private List<Menu>            menus            = new ArrayList<>();
    
    @OneToMany
    private List<LigneDeCommande> ligneDeCommandes = new ArrayList<>();

    public Article() {
    }
    
    public Article(String libelle, float prix, String image, int valeursNutritives, boolean choixCuisson) {
        this();
        this.libelle = libelle;
        this.prix = prix;
        this.image = image;
        this.valeursNutritives = valeursNutritives;
        this.choixCuisson = choixCuisson;
    }

    public Article(String libelle, float prix, String image, int valeursNutritives, boolean choixCuisson, Categorie categorie, Tva tva) {
        this(libelle, prix, image, valeursNutritives, choixCuisson);
        this.categorie = categorie;
        this.tva = tva;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getValeursNutritives() {
        return valeursNutritives;
    }

    public void setValeursNutritives(int valeursNutritives) {
        this.valeursNutritives = valeursNutritives;
    }

    public boolean isChoixCuisson() {
        return choixCuisson;
    }

    public void setChoixCuisson(boolean choixCuisson) {
        this.choixCuisson = choixCuisson;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
    
    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }

    public List<LigneDeCommande> getLigneDeCommandes() {
        return ligneDeCommandes;
    }

    public void setLigneDeCommandes(List<LigneDeCommande> ligneDeCommandes) {
        this.ligneDeCommandes = ligneDeCommandes;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", categorie=" + categorie + '}';
    }

    
}
