
package restaurant.service;

import java.util.List;
import javax.ejb.Remote;
import restaurant.model.commande.Commande;

@Remote
public interface CommandeManagerInterface {

    public List<Commande> getAll();
    
    public Commande getByNumero(String numero);
    
    public List<Commande> getByOneStatus();

    public Commande create(Long idEmplacement);

    public Commande create(String idEmplacement);
    
}
