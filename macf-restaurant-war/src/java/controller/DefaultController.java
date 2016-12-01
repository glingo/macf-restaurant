package controller;

import kernel.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultController extends Controller {

    @Override
    public String handle(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        
        return "lol";
    }
    
}
