package kernel;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class Controller implements ControllerInterface {

    @Override
    public String getName() {
        return getClass().getSimpleName().replace("Controller", "").toLowerCase();
    }
    
    protected <T> T get(String name){
        T ll = null;
        try {
            InitialContext ctx = new InitialContext();
            ll = (T) ctx.lookup(name);
        } catch (NamingException nex) {
            nex.printStackTrace();
        } finally {
            return ll;
        }
    }

}
