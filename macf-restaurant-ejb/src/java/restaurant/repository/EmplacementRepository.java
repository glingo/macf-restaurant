/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.repository;

import java.util.Collection;
import java.util.List;
import restaurant.model.salle.Emplacement;
import restaurant.model.salle.StatutEmplacement;
import restaurant.model.salle.Zone;

/**
 *
 * @author cdi309
 */
public class EmplacementRepository extends EntityRepository<Emplacement> {
    
    public EmplacementRepository(){
        super();
    }
    
    @Override
    protected Class<Emplacement> getManagedClass() {
        return Emplacement.class;
    }
    
    
//    public Collection<Emplacement> findByZone(Zone zone){
//         //to do requete JPQL
//    }
//    
//    public Collection<Emplacement> findByStatut(StatutEmplacement statut){
//        //to do requete JPQL
//        
//        
//        
//    }
    
    public void delete(Emplacement emplacement){
        //to do requete JPQL
    }
    
    public Emplacement update(Emplacement emplacement){
        //to do requete JPQL
        
        return emplacement;
    }
       
    public Emplacement updateStatut(Emplacement emplacement){
        
        StatutEmplacement statutActuel = emplacement.getStatut();
        
        if(statutActuel.equals(StatutEmplacement.LIBRE)){
            
            statutActuel = StatutEmplacement.OCCUPE;
            
        }else if(statutActuel.equals(StatutEmplacement.OCCUPE)){
            
            statutActuel = StatutEmplacement.EN_NETTOYAGE;
            
        }else if(statutActuel.equals(StatutEmplacement.EN_NETTOYAGE)){
            
            statutActuel = StatutEmplacement.LIBRE;
        }
        
        return emplacement;
        
    }    
    
    
    
    
}
