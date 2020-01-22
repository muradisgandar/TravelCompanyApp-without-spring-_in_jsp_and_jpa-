///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package filter;
//
//import java.io.IOException;
//import java.io.PrintStream;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author murad_isgandar
// */
//@WebFilter(filterName = "Filter", urlPatterns = {"*"})
//public abstract class SecurityFilter implements Filter {
//
//    public void doFilter(ServletRequest request, ServletResponse response,
//            FilterChain chain) {
//        
//        
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) request;
//
//        try {
//            if ((!req.getRequestURI().contains("/login") || !req.getRequestURI().contains("/index")) && req.getSession().getAttribute("loggedInAdmin") == null) {
//                res.sendRedirect("login");
//
//            } else {
//                chain.doFilter(request, response);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//    }
//
//}


/*
SecurityFilter is used in https://www.youtube.com/watch?v=UVdR_gT7cuo&list=PLm5YQvYcib_uS2LFXZmBkmfktBDGQ89d3&index=61  by Sarkhan Rasullu
It is used for control urls for authentication 

But ,Filter didn't work in Apache Tomcat 8.0.27 ,Netbeans 8.2 ,because tomcat throws (org.apache.catalina.core.StandardContext.filterStart Exception starting filter SecurityFilter
java.lang.InstantiationException)

I had searched but couldn't  find any solution(
*/