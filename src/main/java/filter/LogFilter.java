package filter;

import jdk.nashorn.internal.runtime.options.LoggingOption;
import sun.rmi.runtime.Log;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebFilter(urlPatterns = "*")
public class LogFilter implements Filter {
    private final Logger LOGGER = Logger.getLogger(LogFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.log(Level.FINE,"INIT filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.log(Level.SEVERE,"MiddleWare");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        LOGGER.log(Level.SEVERE, httpRequest.getParameter("username"));

        HttpSession session = httpRequest.getSession();
        session.setAttribute("hello","hello");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
