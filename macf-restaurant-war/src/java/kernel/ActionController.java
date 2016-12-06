package kernel;

import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ActionController extends Controller {
    
    private final String ACTION_PARAMETER = "action";

    @Override
    public String handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String action = request.getParameter(ACTION_PARAMETER);
        
        if(action == null) {
            // we did not find an action parameter in request !
            String msg = String.format(
                "No action parameter found for the %s section", getName());
            
            response.sendError(HttpServletResponse.SC_NOT_FOUND, msg);
        }
        
        Method method = ReflectionUtils.findMethod(this.getClass(), action, new Class[]{HttpServletRequest.class, HttpServletResponse.class});
        
        if(method == null) {
            // we did not find any method !
            String msg = String.format(
                "No method named %s found in %s controller", action, getName());
            
            throw new Exception(msg);
        }
        
        Object returned = method.invoke(this, request, response);
        
        if(!(returned instanceof String)) {
            String msg = String.format(
                "The method should return String, got %s", returned == null ? method.getReturnType() : returned.getClass());
            throw new Exception(msg);
        }
        
        return (String) returned;
    }
    
}
