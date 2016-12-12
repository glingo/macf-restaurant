package controller;

import kernel.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends Controller {

    @Override
    public String handle(HttpServletRequest request, HttpServletResponse response) {
        
        // il faut paser par la verification du user.
        
        return "home";
    }

}
