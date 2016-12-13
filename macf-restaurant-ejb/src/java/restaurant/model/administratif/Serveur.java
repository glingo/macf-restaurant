package restaurant.model.administratif;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import restaurant.model.commande.Commande;

@Entity
public class Serveur extends Caissier {

    @OneToMany
    public Collection<Commande> commandes = new ArrayList<>();

    public Serveur() {
    }

    public Serveur(String nom, String penom, String code, Etablissement employeur) {
        super(nom, penom, code, employeur);
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }
}
