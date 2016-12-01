package restaurant.model.paiement;

import java.util.ArrayList;
import java.util.List;

public enum ModePaiement {
    
    CB("", ""), TICKET_RESTAURANT("", ""), ESPECE("", "");

    private String libelle;
    private String code;
    private List<Paiement> paiements = new ArrayList<>();

    private ModePaiement(String libelle, String code) {
        this.libelle = libelle;
        this.code = code;
    }
    
}
