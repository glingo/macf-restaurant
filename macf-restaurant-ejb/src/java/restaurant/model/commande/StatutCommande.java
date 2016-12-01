package restaurant.model.commande;

import java.util.ArrayList;
import java.util.List;

public enum StatutCommande {

    EN_SELECTION("", ""), EN_ATTENTE_AIDE("", "");

    private String libelle;
    private String code;

    private List<LigneDeCommande> commande = new ArrayList<>();

    private StatutCommande(String libelle, String code) {
        this.libelle = libelle;
        this.code = code;
    }
}
