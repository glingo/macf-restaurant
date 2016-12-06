package restaurant.model.commande;

public enum TypeCuisson {
    
    BIEN_CUIT("Bien cuit", "BC"), ROUGE("Rouge", "R"), BLEU("Bleu", "B"), SAIGNANT("Saignant", "S");

    private String libelle;
    private String code;
    
    private TypeCuisson(){
        
    }
    
    private TypeCuisson(String libelle, String code) {
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
