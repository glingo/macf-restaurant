package restaurant.model.commande;

import java.io.Serializable;
import restaurant.model.salle.Emplacement;
import restaurant.model.paiement.Paiement;
import restaurant.model.administratif.Serveur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date    date;
    
    @Column(unique = true)
    private String  numero;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Emplacement emplacement;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Serveur     serveur;
    
  
    @OneToMany(mappedBy = "commande", fetch = FetchType.EAGER)
    private Collection<LigneDeCommande> ligneDeCommandes;
    @OneToMany (mappedBy = "commande")
    private Collection<Paiement>        paiements;
    
    @Enumerated(EnumType.ORDINAL)
    private StatutCommande statut;

    public Commande(){
        this.ligneDeCommandes = new ArrayList<>();
        this.paiements = new ArrayList<>();
    }
    
    public Commande(Date date, String numero){
        this();
        this.date = date;
        this.numero = numero;
    }
    
    public Commande(Date date, String numero, Emplacement emplacement, Serveur serveur, StatutCommande statut){
        this(date, numero);
        this.emplacement = emplacement;
        this.serveur = serveur;
        this.statut = statut;
    }
    
    public Commande(Date date, String numero, Emplacement emplacement, StatutCommande statut){
        this(date, numero);
        this.emplacement = emplacement;
        this.statut = statut;
    }
    
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

    public Collection<LigneDeCommande> getLigneDeCommandes() {
        return ligneDeCommandes;
    }

    public void setLigneDeCommandes(Collection<LigneDeCommande> ligneDeCommandes) {
        this.ligneDeCommandes = ligneDeCommandes;
    }

    public Collection<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(Collection<Paiement> paiements) {
        this.paiements = paiements;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
    }
    
}
