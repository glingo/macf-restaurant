package restaurant.model.administratif;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Employe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  nom;
    private String  penom;
    
    @Column(length = 4, unique = true)
    private String     code;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Etablissement employeur;

    public Employe() {
    }

    public Employe(String nom, String penom, String code, Etablissement employeur) {
        this.nom = nom;
        this.penom = penom;
        this.code = code;
        this.employeur = employeur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPenom() {
        return penom;
    }

    public void setPenom(String penom) {
        this.penom = penom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Etablissement getEmployeur() {
        return employeur;
    }

    public void setEmployeur(Etablissement employeur) {
        this.employeur = employeur;
    }
    
    
}
