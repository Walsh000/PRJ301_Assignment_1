/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */

package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import object.User;

/**
 *
 * @author fpt
 */
public class AuthenticationFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public AuthenticationFilter() {
    } 


    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
	throws IOException, ServletException {

	if (debug) log("AuthenticationFilter:doFilter()");
        
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        
        String loginURI = req.getContextPath() + "/login";
        
        if((session == null || session.getAttribute("user") == null) && !req.getRequestURI().equals(loginURI)) {
            res.sendRedirect(loginURI);
        } else {
            chain.doFilter(request, response);
        }

    }
    
    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
	return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
	this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter 
     */
    public void destroy() { 
    }

    /**
     * Init method for this filter 
     */
    public void init(FilterConfig filterConfig) { 
	this.filterConfig = filterConfig;
	if (filterConfig != null) {
	    if (debug) { 
		log("AuthenticationFilter:Initializing filter");
	    }
	}
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
	if (filterConfig == null) return ("AuthenticationFilter()");
	StringBuffer sb = new StringBuffer("AuthenticationFilter(");
	sb.append(filterConfig);
	sb.append(")");
	return (sb.toString());
    }

    public void log(String msg) {
	filterConfig.getServletContext().log(msg); 
    }

}