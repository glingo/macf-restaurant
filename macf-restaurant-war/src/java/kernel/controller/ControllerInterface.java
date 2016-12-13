package kernel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerInterface {
    
    String getName();
    
    void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
}
