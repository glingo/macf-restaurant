package restaurant.model.paiement;

public enum ModePaiement {
    
    CB("", ""), TICKET_RESTAURANT("", ""), ESPECE("", "");

    private String libelle;
    private String code;
    
    private ModePaiement(String libelle, String code) {
        this.libelle = libelle;
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
