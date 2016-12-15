package kernel.controller;

import kernel.session.FlashBag;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.logging.Logger;
import restaurant.model.administratif.Employe;

public abstract class Controller implements ControllerInterface {

    private static final Logger LOG = Logger.getLogger(Controller.class.getName());
    
    private final String NAMING_SUFFIX          = "Controller";
    
    private final String FLASHBAG_SESSION_ATTR  = "flashbag";
    
    private final String FLASHBAG_WARNING_TYPE  = "warning";
    private final String FLASHBAG_DANGER_TYPE   = "danger";
    private final String FLASHBAG_INFO_TYPE     = "info";
    private final String FLASHBAG_SUCCESS_TYPE  = "success";
    
    private final String USER_SESSION_ATTR      = "user";
    
    private final String URL_DISPATCHING_PRE    = "/WEB-INF/jsp/";
    private final String URL_DISPATCHING_SUF    = ".jsp";

    private InitialContext ctx;

    private HttpServletRequest request;
    private HttpServletResponse response;
    
    @Override
    public String getName() {
        return getClass().getSimpleName().replace(NAMING_SUFFIX, "").toLowerCase();
    }

    @Override
    public final void handle(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        this.request = request;
        this.response = response;

        try {
            String url = doHandle(request, response);

            render(url, request, response);
        
        } catch (Exception ex) {
            sendNotFoundException(ex.getMessage());
        }
    }

    /**
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception 
     */
    public abstract String doHandle(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 
     * @param url
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException 
     */
    private void render(String url, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        LOG.info(String.format("Trying to render a response to %s", url));
        
        // first look if response has been commited.
        if (response.isCommitted()) {
            LOG.info("The response has already been commited.");
            return;
        }
        
        // if we don't know where to forward, let's send a notfound.
        if (url == null) {
            String msg = "Controller returned a null as url.";
            LOG.warning(msg);
            sendNotFoundException(msg);
            return;
        }
        
        // else just try to forward.
        try {
            // encode url.
            url = response.encodeURL(concatURL(url));

            // forward to jsp.
            request.getRequestDispatcher(url).forward(request, response);
            
            LOG.info("The response has been rendered.");
            
        } catch (FileNotFoundException notFoundException) {

            String msg = String.format("No jsp page found at %s.",
                    notFoundException.getMessage());

            LOG.warning(msg);
            sendNotFoundException(msg);
        }
    }
    
    protected String concatURL(String url) {
        return URL_DISPATCHING_PRE + url + URL_DISPATCHING_SUF;
    }
    
    /***************************************** 
     *          Session proxy methods        *
     *****************************************/
    
    /**
     * 
     * @return 
     */
    protected HttpSession getSession() {
        return request.getSession(true);
    }
    
    /**
     * 
     * @param <T>
     * @param name
     * @param or
     * @return 
     */
    protected <T> T getFromSession(String name, T or){
        T attr = (T) getSession().getAttribute(name);
        
        if(attr == null) {
            attr = or;
            getSession().setAttribute(name, attr);
        }
        
        return attr;
    }
    
    /***************************************** 
     *       Employe proxy methods           *
     *****************************************/
    
    /**
     * 
     * @return 
     */
    protected Employe getEmploye(){
        return getFromSession(USER_SESSION_ATTR, null);
    }
    
    protected boolean isGranted(Class... roles){
        Employe employe = getEmploye();
        
        if (employe == null) {
            return false;
        }
        
        for (Class role : roles) {
            if(employe.getClass().isAssignableFrom(role)) {
                return true;
            }
        }
        
        return false;
    }
    
    
    /***************************************** 
     *       FlashBag proxy methods          *
     *****************************************/
    
    /**
     * 
     * @return 
     */
    private FlashBag getFlashBag() {
        return getFromSession(FLASHBAG_SESSION_ATTR, new FlashBag());
    }
    
    /**
     * 
     * @param type
     * @param message 
     */
    protected void addFlash(String type, String message){
        getFlashBag().addFlash(type, message);
    }

    /**
     * 
     * @param message 
     */
    protected void danger(String message) {
        addFlash(FLASHBAG_DANGER_TYPE, message);
    }
    
    /**
     * 
     * @param message 
     */
    protected void success(String message) {
        addFlash(FLASHBAG_SUCCESS_TYPE, message);
    }
    
    /**
     * 
     * @param message 
     */
    protected void info(String message) {
        addFlash(FLASHBAG_INFO_TYPE, message);
    }
    
    /**
     * 
     * @param message 
     */
    protected void warning(String message) {
        addFlash(FLASHBAG_WARNING_TYPE, message);
    }

    
    /***************************************** 
     *      Redirection proxy methods        *
     *****************************************/
    
    /**
     * 
     * @throws IOException 
     */
    protected void redirect() throws IOException {
        redirect("");
    }
    
    /**
     * 
     * @param location
     * @throws IOException 
     */
    protected void redirect(String location) throws IOException {
        this.response.sendRedirect(location);
    }

    /**
     * 
     * @param msg
     * @throws IOException 
     */
    protected void sendNotFoundException(String msg) throws IOException {
        this.response.sendError(HttpServletResponse.SC_NOT_FOUND, msg);
    }
    
    /***************************************** 
     *         Context proxy methods         *
     *****************************************/
    
    /**
     * 
     * @param <T>
     * @param name
     * @return 
     */
    protected final <T> T get(String name) {
        T service;

        try {

            // lazing init
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
