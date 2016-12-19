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
    
    
    public Collection<Emplacement> findByZone(Zone zone){
         //to do requete JPQL
        /*
         System.out.println("\n2) Tous les " + espece);
        String req02 = "select a from Animal a where a.race= :paramRace";
        //: indicateur pour dire qu'on a le nom d'un parametre. pas d'espace entre : et nom param. 
        // :paramRAce = ? (en preparedstatement)

        Query qr02 = em.createQuery(req02);
        qr02.setParameter("paramRace", espece);
        // nom du parametre et valeur
//        //les requetes qui suivent : quand on ne veut pas tous remonter.
//        qr02.setFirstResult(2);
//        qr02.setMaxResults(2);
        List<Animal> la02 = qr02.getResultList();
        for (Animal a : la02) {
            System.out.println(a);
        }
        
        
        */
        
        
        
        
        return query.getResultList();
        
        
    }
    
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
       
    public Emplacement updateStatut(Emplacement emplacement, StatutEmplacement statut){
        
        emplacement.setStatut(statut);
        
        save(emplacement);
        
        return emplacement;
        
    }    
    
    
    
    
}
