package restaurant.model.catalogue;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {

    private String nom;
    private boolean disponible;
    
    private List<Article> articles = new ArrayList<>();
}
