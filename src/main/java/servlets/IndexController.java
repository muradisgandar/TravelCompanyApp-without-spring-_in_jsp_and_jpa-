/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import config.LoginConfig;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author murad_isgandar
 */
@WebServlet(name = "IndexController", urlPatterns = {"/IndexController"})
public class IndexController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //load username and password for admin login from loginConfig.properties file
        Map<String, String> map = LoginConfig.getProperties();
        //next step : authentication process
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (action != null && !action.isEmpty()) {
            if ("admin".equals(action)) {
                if (username.equals(map.get("username")) && password.equals(map.get("password"))) {

                    response.sendRedirect("AdminController");
                } else {
                    response.sendRedirect("index.jsp");
                }

            } else if ("user".equals(action)) {
                if (!username.isEmpty() && !password.isEmpty()) {
                    response.sendRedirect("UserController");
                }
            }
        }

        username = "";
        password = "";

    }

}
