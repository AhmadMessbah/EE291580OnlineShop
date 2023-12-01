package com.mftplus.javaee04.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AllFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("All Filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (request.getRequestURI().equals("/login.do")) {
            filterChain.doFilter(servletRequest, servletResponse);}
        else if(request.getRequestURI().toLowerCase().equals("/jsp/error-404.jsp")){
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("/login.do");
        } else if(request.getRequestURI().toLowerCase().endsWith(".jsp")){
            request.getSession().setAttribute("error", "No Access to admin pages");
           response.sendRedirect ("/login.do");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
