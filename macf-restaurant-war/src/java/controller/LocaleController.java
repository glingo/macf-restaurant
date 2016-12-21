package controller;

import java.util.Locale;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import kernel.controller.Controller;

public class LocaleController extends Controller {
    private static final Logger LOG = Logger.getLogger(LocaleController.class.getName());

    @Override
    public String doHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String lang = request.getParameter("lang");
        Locale locale = Locale.getDefault();
        
        if(lang != null) {
            locale = new Locale(lang);
        }
        
        Config.set(getSession(), Config.FMT_LOCALE, locale);
        getSession().setAttribute("lang", locale.getLanguage());
        
        String url = request.getHeader("referer");
        
        if(url == null) {
            return "home";
        }
        
        redirect(url);
        return null;
        
    }
    
}
