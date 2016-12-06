package restaurant.model.commande;

public enum StatutCommande {

    EN_SELECTION("en sélection", "ES"), EN_ATTENTE_AIDE("en attente d'aide", "EA");

    private String libelle;
    private String code;

    private StatutCommande() {
    }
    
    private StatutCommande(String libelle, String code) {
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
