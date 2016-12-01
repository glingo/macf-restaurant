package restaurant.model.administratif;

import java.util.ArrayList;
import java.util.List;

public class Etablissement {

    private String numSiret;
    private String nom;
    private String numVoie;
    private String nomVoie;
    private String complementAdresse;
    private String codePostal;
    private String ville;
    private String tel;
    
    private List<Employe> employes = new ArrayList<>();
}
