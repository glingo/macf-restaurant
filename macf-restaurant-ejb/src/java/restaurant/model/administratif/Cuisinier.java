package restaurant.model.administratif;

import javax.persistence.Entity;

@Entity
public class Cuisinier extends Employe {

    public Cuisinier() {
    }
    
    public Cuisinier(String nom, String penom, String code, Etablissement employeur) {
        super(nom, penom, code, employeur);
    }
    
}
