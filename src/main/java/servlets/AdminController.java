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
@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
                if ("add".equals(action)) {
                    TravelPackagesDB.add(new Travelpackages(null, countryName, date));
                    TravelPackagesDB.getAll();
                } else if ("delete".equals(action)) {
                    TravelPackagesDB.delete(id);
                } else if ("update".equals(action)) {
                    TravelPackagesDB.update(new Travelpackages(id, countryName, date));
                }

                if (!"search".equals(action)) {
                    countryName = null;
                    date = null;
                    response.sendRedirect("adminpage.jsp");

                }
                
                //burda problem varrrr!
                request.setAttribute("list", TravelPackagesDB.getAll());
                RequestDispatcher rd = request.getRequestDispatcher("adminpage.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {

        }

//        Travelpackages tr = new Travelpackages(null, countryName, date);
//
//        List<Travelpackages> list = TravelPackagesDB.getAllByParameters(tr);
//
//        if (list.size() > 0) {
//            request.setAttribute("list", list);
//        }
//        request.setAttribute("list", TravelPackagesDB.getAll());
//        RequestDispatcher rd = request.getRequestDispatcher("adminpage.jsp");
//        rd.forward(request, response);

    }

}
