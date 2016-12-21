/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.repository;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import restaurant.model.salle.Emplacement;
import restaurant.model.salle.StatutEmplacement;
import restaurant.model.salle.Zone;

@Stateless
public class EmplacementRepository extends EntityRepository<Emplacement> {
    
    public EmplacementRepository(){
        super();
    }
    
    @Override
    protected Class<Emplacement> getManagedClass() {
        return Emplacement.class;
    }
    
    
    public Collection<Emplacement> findByZone(Zone zone){
        
        String req = "select e from Emplacement where e.zone = :paramZone";
        Query query = em.createQuery(req);
        query.setParameter("paramZone", zone);

        return query.getResultList();
        
        
    }
    
    public Collection<Emplacement> findByStatut(StatutEmplacement statut){
        
        String req = "select e from Emplacement where e.statut = :paramStatutEmplacement";
        Query query = em.createQuery(req);
        query.setParameter("paramStatutEmplacement", statut);
        
        return query.getResultList();
        
        
    }
    
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
