package kernel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerInterface {
    
    String getName();
    
    String handle(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
}
