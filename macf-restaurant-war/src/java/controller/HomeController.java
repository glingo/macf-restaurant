package controller;

import kernel.controller.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import restaurant.model.administratif.Employe;

public class HomeController extends Controller {

    @Override
    public String doHandle(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }
    
}
