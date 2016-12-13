package restaurant.model.salle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Zone {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    
    @OneToMany
    //on créer l'arraylist ici plutot que dans le constructeur par défault. Reviens au même. 
    private Collection<Emplacement> emplacements = new ArrayList<>();
    
    public Zone(){
        
    }
    
    public Zone(String numero){
        this();
        this.numero = numero;
    }
}
