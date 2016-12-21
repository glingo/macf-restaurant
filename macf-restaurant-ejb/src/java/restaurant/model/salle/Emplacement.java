package restaurant.model.salle;

import java.io.Serializable;
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
import restaurant.model.commande.Commande;

@Entity
public class Emplacement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String numero;
    private int nombrePlace;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Zone zone;
    
    @Enumerated(EnumType.STRING)
    private StatutEmplacement statut;
    
    @OneToMany(mappedBy = "emplacement")
    private Collection<Commande> commandes = new ArrayList<>();
    
    
    public Emplacement(){
        
    }
    
    public Emplacement(String numero, int nombrePlace){
        this();
        this.numero = numero;
        this.nombrePlace = nombrePlace;
        
    }
    
    public Emplacement(String numero, int nombrePlace, StatutEmplacement statut, Zone zone){
        this(numero, nombrePlace);
        this.statut = statut;
        this.zone = zone;
    }
    
    public Emplacement(String numero, int nombrePlace, StatutEmplacement statut, Zone zone, Collection<Commande> commandes){
        this(numero, nombrePlace, statut, zone);
        this.commandes = commandes;
        
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public void setNombrePlace(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public StatutEmplacement getStatut() {
        return statut;
    }

    public void setStatut(StatutEmplacement statut) {
        this.statut = statut;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }
    
    
}
