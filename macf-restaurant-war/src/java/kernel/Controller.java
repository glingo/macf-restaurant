package kernel;

import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class Controller implements ControllerInterface {

    private static final Logger LOG = Logger.getLogger(Controller.class.getName());
    
    private InitialContext ctx;
    
    @Override
    public String getName() {
        return getClass().getSimpleName().replace("Controller", "").toLowerCase();
    }
    
    protected final <T> T get(String name){
        T service;
        
        try {
            
            if(ctx == null) {
                ctx = new InitialContext();
            }
            
            service = (T) ctx.lookup(name);
        } catch (NamingException nex) {
            LOG.severe(nex.getMessage());
            return null;
        }
        
        return service;
    }

}
