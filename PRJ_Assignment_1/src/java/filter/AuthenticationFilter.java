/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filter;

import dal.RoleDBContext;
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
import object.Feature;
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

        if (debug) {
            log("AuthenticationFilter:doFilter()");
        }

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String loginURI = req.getContextPath() + "/login";
        String requestURI = req.getRequestURI();

        if (requestURI.indexOf("/css") > 0
                || requestURI.indexOf("/image") > 0
                || requestURI.indexOf("/js") > 0
                || requestURI.indexOf("Filter") > 0) {
            chain.doFilter(request, response);
        } else {
            if (session == null || session.getAttribute("user") == null) {
                if (!req.getRequestURI().equals(loginURI)) {
                    res.sendRedirect(loginURI);
                } else {
                    chain.doFilter(request, response);
                }
            } else {
                String homeURI = req.getContextPath() + "/home";

                RoleDBContext roleDBC = new RoleDBContext();
                User user = (User) session.getAttribute("user");
                Feature feature = new Feature();
                feature.setUrl(req.getServletPath());
//                System.out.println(feature.getUrl());
//                System.out.println(roleDBC.list(feature).size());
//                System.out.println(user.getUserRole());
//                System.out.println(roleDBC.list(feature).contains(user.getUserRole()));

                if (roleDBC.list(feature).contains(user.getUserRole())
                        || req.getServletPath().equals("/logout")) {
                    chain.doFilter(request, response);
                } else {
                    if (req.getRequestURI().equals(homeURI)) {
                        chain.doFilter(request, response);
                    } else {
                        res.sendRedirect(homeURI);
                    }
                }

            }
//            chain.doFilter(request, response);
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
        if (filterConfig == null) {
            return ("AuthenticationFilter()");
        }
        StringBuffer sb = new StringBuffer("AuthenticationFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
