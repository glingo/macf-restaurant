package kernel.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kernel.session.FlashBag;

public abstract class Controller implements ControllerInterface {

    private static final Logger LOG = Logger.getLogger(Controller.class.getName());
    
    private final String urlPrefix = "/WEB-INF/jsp/";
    private final String urlSufix = ".jsp";

    private InitialContext ctx;

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public final void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
        this.response = response;

        try {
            
            String view = doHandle(request, response);

            if (view == null) {
                return;
            }

            render(view, request, response);
        
        } catch (Exception ex) {
            sendNotFoundException(ex.getMessage());
        }
    }

    public abstract String doHandle(HttpServletRequest request, HttpServletResponse response) throws Exception;

    private void render(String url, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        if (response.isCommitted()) {
            return;
        }
        
        try {
            // encode url.
            url = response.encodeURL(urlPrefix + url + urlSufix);

            request.getRequestDispatcher(url).forward(request, response);
        } catch (FileNotFoundException notFoundException) {

            String msg = String.format("No jsp page found at %s.",
                    notFoundException.getMessage());

            LOG.warning(msg);
            sendNotFoundException(msg);
        }

    }

    @Override
    public String getName() {
        return getClass().getSimpleName().replace("Controller", "").toLowerCase();
    }

    protected HttpSession getSession() {
        return request.getSession(true);
    }

    protected void redirect(String location) throws IOException {
        this.response.sendRedirect(location);
    }

    protected void sendNotFoundException(String msg) throws IOException {
        this.response.sendError(HttpServletResponse.SC_NOT_FOUND, msg);
    }
    
    private FlashBag getFlashBag() {
        FlashBag bag = (FlashBag) getSession().getAttribute("flashbag");
        
        if(bag == null) {
            bag = new FlashBag();
            getSession().setAttribute("flashbag", bag);
        }
        
        return bag;
    }

    protected void danger(String message) {
        getFlashBag().addFlash("danger", message);
    }
    
    protected void success(String message) {
        getFlashBag().addFlash("success", message);
    }
    
    protected void info(String message) {
        getFlashBag().addFlash("info", message);
    }
    
    protected void warning(String message) {
        getFlashBag().addFlash("warning", message);
    }

    protected final <T> T get(String name) {
        T service;

        try {

            if (ctx == null) {
                ctx = new InitialContext();
            }

            service = (T) ctx.lookup(name);
        } catch (NamingException nex) {
            LOG.severe(nex.getMessage());
            return null;
        }

        return service;
    }

}
