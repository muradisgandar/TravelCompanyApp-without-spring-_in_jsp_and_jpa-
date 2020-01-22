/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import config.LoginConfig;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author murad_isgandar
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //load username and password for admin login from loginConfig.properties file
        Map<String, String> adminDetails = LoginConfig.getProperties();
        //next step : authentication process
        String action = request.getParameter("action");
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        if (action != null && !action.isEmpty()) {
            if ("admin".equals(action)) {
                if (username.equals(adminDetails.get("email")) && password.equals(adminDetails.get("password"))) {

                    request.getSession().setAttribute("loggedInAdmin", adminDetails);
                    response.sendRedirect("admin");
                } else {

                    request.setAttribute("error", "Wrong credentials for admin!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            } else if ("user".equals(action)) {
                if (!username.isEmpty() && !password.isEmpty()) {
                    response.sendRedirect("user");
                }
            }
        }

        username = "";
        password = "";

    }

}
