package restaurant.model.salle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Zone implements Serializable {
    
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

    public Collection<Emplacement> getEmplacements() {
        return emplacements;
    }

    public void setEmplacements(Collection<Emplacement> emplacements) {
        this.emplacements = emplacements;
    }

//    @Override
//    public String toString() {
//        return numero;
//    }
    
    
    
}
