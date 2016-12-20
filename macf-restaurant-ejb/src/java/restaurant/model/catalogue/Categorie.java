package restaurant.model.catalogue;

public enum Categorie {
    
    ENTREE("Entrée", "ENT"), 
    PLAT("Plat", "PLT"), 
    DESSERT("Dessert", "DSR"), 
    BOISSON("Boisson", "BSN");
//    BOISSON_ALCOOL("Boisson alcoolisée", "BSA");

    private String libelle;
    private String code;

    private Categorie() {
    }

    private Categorie(String libelle, String code) {
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
