package restaurant.model.commande;

import java.io.Serializable;
import restaurant.model.salle.Emplacement;
import restaurant.model.paiement.Paiement;
import restaurant.model.administratif.Serveur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date    date;
    private String  numero;
    
    @OneToOne
    private Emplacement emplacement;
    @OneToOne
    private Serveur     serveur;
    
    @OneToMany
    private List<LigneDeCommande> ligneDeCommandes = new ArrayList<>();
    @OneToMany
    private List<Paiement>        paiements        = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }

    public List<LigneDeCommande> getLigneDeCommandes() {
        return ligneDeCommandes;
    }

    public void setLigneDeCommandes(List<LigneDeCommande> ligneDeCommandes) {
        this.ligneDeCommandes = ligneDeCommandes;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }
    
}
