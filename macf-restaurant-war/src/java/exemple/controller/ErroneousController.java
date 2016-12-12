package exemple.controller;

import kernel.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErroneousController extends Controller {

    @Override
    public String handle(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
