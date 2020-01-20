/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import databases.UserDB;
import entities.Travelpackages;
import entities.Users;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author murad_isgandar
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.sendRedirect("userpage.jsp");
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        action = action == null ? "" : action;

        String name = request.getParameter("name");
        name = name == null ? "" : name;

        String surname = request.getParameter("surname");
        surname = surname == null ? "" : surname;

        String ageStr = request.getParameter("age");
        ageStr = ageStr == null ? "" : ageStr;
        Integer age = 0;
        if (ageStr != null && !ageStr.isEmpty()) {
            age = Integer.parseInt(ageStr);
        }

        String gender = request.getParameter("gender");
        gender = gender == null ? "" : gender;

        String mail = request.getParameter("mail");
        mail = mail == null ? "" : mail;

        String number = request.getParameter("number");
        number = number == null ? "" : number;

        String sId = request.getParameter("id");
        sId = sId == null ? "" : sId;

        Integer id = null;
        if (sId != null && !sId.isEmpty()) {
            id = Integer.parseInt(sId);
        }

        Travelpackages t = new Travelpackages(id);

        Users u = new Users(null, name, surname, age, gender, number, mail);
        u.setTourId(t);
        if ("add".equals(action)) {
            UserDB.add(u);
            response.sendRedirect("userpage.jsp");

        }

    }

}
