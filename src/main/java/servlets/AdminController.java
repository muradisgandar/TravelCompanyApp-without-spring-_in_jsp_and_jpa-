/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import databases.TravelPackagesDB;
import entities.Travelpackages;
import java.io.IOException;
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
@WebServlet(name = "AdminController", urlPatterns = {"/admin"}) 
public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        String countryName = request.getParameter("name");

        countryName = countryName == "" ? null : countryName;
        String date = request.getParameter("date");

        date = date == "" ? null : date;

        if (action == null) {

            request.setAttribute("list", TravelPackagesDB.getAll());

        } else if (action.equals("search")) {
            request.setAttribute("list", TravelPackagesDB.getAllByParameters(new Travelpackages(null, countryName, date)));

        }

        RequestDispatcher rd = request.getRequestDispatcher("adminpage.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        String countryName = request.getParameter("name");

        countryName = countryName == "" ? null : countryName;
        String date = request.getParameter("date");

        date = date == "" ? null : date;
        String sId = request.getParameter("id");
        sId = sId == null ? "" : sId;

        Integer id = null;
        if (sId != null && !sId.isEmpty()) {
            id = Integer.parseInt(sId);
        }

        try {
            if (action != null && !action.isEmpty()) {
                if ("Add".equals(action)) {
                    TravelPackagesDB.add(new Travelpackages(null, countryName, date));
                    TravelPackagesDB.getAll();
                } else if ("delete".equals(action)) {
                    TravelPackagesDB.delete(id);
                } else if ("update".equals(action)) {
                    TravelPackagesDB.update(new Travelpackages(id, countryName, date));
                }

                response.sendRedirect("admin");

            }
        } catch (Exception e) {

        }

    }

}
