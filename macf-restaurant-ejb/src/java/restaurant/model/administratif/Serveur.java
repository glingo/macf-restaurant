package restaurant.model.administratif;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import restaurant.model.commande.Commande;

@Entity
public class Serveur extends Caissier {

    @OneToMany
    public List<Commande> commandes = new ArrayList<>();

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
