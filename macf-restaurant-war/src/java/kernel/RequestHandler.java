package kernel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.ServiceLoader;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {""})
public class RequestHandler extends HttpServlet {
    
    private static final Logger LOG = Logger.getLogger(RequestHandler.class.getName());
    
    private final ServiceLoader<ControllerInterface> loader = ServiceLoader.load(ControllerInterface.class);
    
    private final String wrapParameterName = "section";
    private final String urlPrefix = "/WEB-INF/";
    private final String urlSufix  = ".jsp";
    
    private HashMap<String, ControllerInterface> controllers;

    @Override
    public void init() throws ServletException {
        super.init();
        
        // we reload and register controllers to this handler.
        registerControllers();
    }
    
    private void registerControllers(){
        this.controllers = new HashMap<>();
        this.loader.reload();
        LOG.info(this.loader.toString());
        this.loader.forEach((ControllerInterface controller) -> {
            
            LOG.info(controller.toString());
            
            if(controllers.containsKey(controller.getName())) {
                String msg = String.format(
                    "A controller is already registered with name %s", 
                    controller.getName());
                
                LOG.warning(msg);
                return;
            }
            
            controllers.put(controller.getName(), controller);
            LOG.info(String.format(
                "A controller has been registered with name %s", 
                controller.getName()));
        });
    }
    
    private void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String wrapParameter = request.getParameter(wrapParameterName);
        
        if(wrapParameter == null) {
            // we did not find a section parameter in request !
            // we may wanted to see the home page.
            // let's redirect to the home page :
            wrapParameter = "home";
        }
        
        if(!controllers.containsKey(wrapParameter)) {
            String msg = String.format(
                "No controller found for the %s section", 
                wrapParameter);

            LOG.warning(msg);

            // we send a not found error.
            // No controllerFound for this section.
            response.sendError(HttpServletResponse.SC_NOT_FOUND, msg);
        }
        
        if(response.isCommitted()) {
            return;
        }
        
        try {
            // get controller from controller pool.
            ControllerInterface controller = controllers.get(wrapParameter);

            // process controller and get the view name.
            String url = controller.handle(request, response);

            // encode url.
            url = response.encodeURL(urlPrefix + url + urlSufix);

            // include.
            getServletContext().getRequestDispatcher(url).include(request, response);
        
        } catch (FileNotFoundException notFoundException) {
            
            String msg = String.format("No jsp page found at %s.", 
                notFoundException.getMessage());

            LOG.warning(msg);
            
            // we send a not found error.
            response.sendError(HttpServletResponse.SC_NOT_FOUND, msg);
        } catch (Exception exc) {
            
            // handle exception.
            response.sendError(HttpServletResponse.SC_NOT_FOUND, exc.getMessage());
        }
        
    }
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        handle(request, response);
        
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        
        
        
        return "Short description";
    }

}
