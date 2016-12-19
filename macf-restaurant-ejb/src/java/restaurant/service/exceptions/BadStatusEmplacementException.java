
package restaurant.service.exceptions;

import restaurant.model.salle.Emplacement;
import restaurant.model.salle.StatutEmplacement;


public class BadStatusEmplacementException extends EmplacementException {
    
    
    public BadStatusEmplacementException (Emplacement emplacement, StatutEmplacement statutEmplacement){
        //super(emplacement);
  
    }
    
    //methode d'affichage du message derreur en fonction du statut et de lemplacement.
    
    public String messageErreur(Emplacement emplacement, StatutEmplacement statutEmplacement){
        String message = null;
        System.out.println("La table "+emplacement+" ne peut pas changé de statut.Elle doit être en "+statutEmplacement);
        
        return message;
    }
    
}
