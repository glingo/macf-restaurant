package restaurant.model.administratif;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Etablissement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 14, nullable = false, unique = true)
    private String numSiret;
    
    @Column(nullable = false)
    private String nom;
    private String numVoie;
    private String nomVoie;
    private String complementAdresse;
    private String codePostal;
    private String ville;
    private String tel;
    
    @OneToMany
    private List<Employe> employes = new ArrayList<>();

    public Etablissement() {
        this.employes = new ArrayList<>();
    }

    public Etablissement(String numSiret, String nom, String numVoie, String nomVoie, String complementAdresse, String codePostal, String ville, String tel) {
        this();
        this.numSiret = numSiret;
        this.nom = nom;
        this.numVoie = numVoie;
        this.nomVoie = nomVoie;
        this.complementAdresse = complementAdresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.tel = tel;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumSiret() {
        return numSiret;
    }

    public void setNumSiret(String numSiret) {
        this.numSiret = numSiret;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumVoie() {
        return numVoie;
    }

    public void setNumVoie(String numVoie) {
        this.numVoie = numVoie;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
    
    
}
