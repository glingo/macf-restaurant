package restaurant.service;

import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import restaurant.model.administratif.Employe;
import restaurant.repository.EmployeRepository;

@Stateless(name="employe-manager")
public class EmployeManager {
    
    private static final Logger LOG = Logger.getLogger(EmployeManager.class.getName());
    
    @EJB
    private EmployeRepository repository;
    
    
    public Employe login(String code) {
        
        LOG.info("Tentative de login");
        
        // verification d'usage ...
        // code != null
        // code.length = 4
        
        Employe employe = repository.login(code);
        
        LOG.info(String.format("Tentative de login %s", 
                employe != null ? "reussie" : "échouée"));

        return employe;
    }
    
    
}
