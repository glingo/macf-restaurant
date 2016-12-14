/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.repository;

import restaurant.model.salle.Emplacement;

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
    
}
