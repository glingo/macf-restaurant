
package restaurant.service.exceptions;

import java.util.HashMap;

public class EmplacementException extends Exception{
    
    //attribution d'un numéro pour une exception.( à faire évoluer vers une classe par exception)
    //10 : erreur au niveau du changement de statut.
    public static final int STATUS_EX = 10;
    

    private int numException;
    //attribut HashMap : dans le cas où on veut afficher plusieurs messages d'erreurs.
    private HashMap<String, String> erreurs;
    
    //constructeur par défaut
    public EmplacementException() {
    }
    
    
    //constructeur avec parametre issu de Exception
    public EmplacementException(String message) {
        super(message);
    }

    public EmplacementException(int numException) {
        this.numException = numException;
    }


    public EmplacementException(int numException, String message) {
        super(message);
        this.numException = numException;
    }

    public EmplacementException(int numException, HashMap<String, String> erreurs, String message) {
        super(message);
        this.numException = numException;
        this.erreurs = erreurs;
    }

    public int getNumException() {
        return numException;
    }

    public void setNumException(int numException) {
        this.numException = numException;
    }

    public HashMap<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(HashMap<String, String> erreurs) {
        this.erreurs = erreurs;
    }
    
    
    
    
    
    
    
}
