package restaurant.model.administratif;

import java.util.ArrayList;
import java.util.List;
import restaurant.model.commande.Commande;

public class Serveur extends Caissier {

    public List<Commande> commandes = new ArrayList<>();
}
