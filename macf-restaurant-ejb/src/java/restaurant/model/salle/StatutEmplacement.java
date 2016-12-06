package restaurant.model.salle;

import javax.persistence.Entity;

public enum StatutEmplacement {

    LIBRE("", ""), OCCUPE("", ""), EN_NETTOYAGE("", "");

    private String code;
    private String libelle;
    
    private StatutEmplacement(){
        
    }
            
    private StatutEmplacement(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    

}
