package restaurant.model.salle;

import java.util.ArrayList;

public enum StatutEmplacement {

    LIBRE("", ""), OCCUPE("", ""), EN_NETTOYAGE("", "");

    private String code;
    private String libelle;
    private ArrayList<Emplacement> emplacements = new ArrayList<>();

    private StatutEmplacement(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

}
