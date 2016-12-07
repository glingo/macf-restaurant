package restaurant.model.administratif;

import javax.persistence.Entity;

@Entity
public class Caissier extends Employe {

    public Caissier() {
    }

    public Caissier(String nom, String penom, String code, Etablissement employeur) {
        super(nom, penom, code, employeur);
    }
    
}
