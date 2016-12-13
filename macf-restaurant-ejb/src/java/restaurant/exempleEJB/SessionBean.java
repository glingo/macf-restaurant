/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.exempleEJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi304
 */
@Stateless
public class SessionBean implements SessionBeanLocal {
    @PersistenceContext(unitName = "macf-restaurant-PU")
    private EntityManager em;

    @Override
    public void methode(){
        // to do
    }
    
    
}
