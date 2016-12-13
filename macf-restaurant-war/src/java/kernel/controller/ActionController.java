package kernel.controller;

import java.lang.reflect.Method;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kernel.util.ReflectionUtils;

public abstract class ActionController extends Controller {

    private static final Logger LOG = Logger.getLogger(ActionController.class.getName());
    
    private final String ACTION_PARAMETER = "action";

    @Override
    public String doHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        LOG.entering("ActionController", "doHandle");
        
        String action = request.getParameter(ACTION_PARAMETER);
        
        if(action == null) {
            // we did not find an action parameter in request !
            String msg = String.format(
                "No action parameter found for the %s section", getName());
            
            LOG.info(msg);
            
            throw new Exception(msg);
        }
        
        Method method = ReflectionUtils.findMethod(this.getClass(), action, new Class[]{HttpServletRequest.class, HttpServletResponse.class});
        
        if(method == null) {
            // we did not find any method !
            String msg = String.format(
                "No method named %s found in %s controller", action, getName());
            
            LOG.info(msg);
            
            throw new Exception(msg);
        }
        
        Object url = method.invoke(this, request, response);
        
        if(!(url instanceof String)) {
            
            if(response.isCommitted()) {
                return null;
            }
        
            String msg = String.format(
                "The method should return String, got %s", url == null ? method.getReturnType() : url.getClass());
            
            LOG.info(msg);
            
            throw new Exception(msg);
        }
        
        return (String) url;
    }
    
}
