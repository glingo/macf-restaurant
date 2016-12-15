/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.service.exception;

import restaurant.model.salle.Emplacement;
import restaurant.model.salle.StatutEmplacement;

/**
 *
 * @author cdi309
 */
public class BadStatusEmplacementException extends EmplacementException {
    
    
    public BadStatusEmplacementException (Emplacement emplacement, StatutEmplacement statutEmplacement){
        super(emplacement);
  
    }
    
    //methode d'affichage du message derreur en fonction du statut et de lemplacement.
    
    
    
}
