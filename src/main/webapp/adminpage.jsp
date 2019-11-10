<%-- 
    Document   : adminlogin
    Created on : Sep 15, 2019, 6:06:02 PM
    Author     : murad_isgandar
--%>

<%@page import="entities.Travelpackages"%>
<%@page import="databases.TravelPackagesDB"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Admin Login</title>
        <style>
            body{
                background: linear-gradient( #7f7fd5, #86a8e7, #91eae4);
            }
            table {
                border-collapse: collapse;
            }

            table, th, td {
                border: 1px solid black;
            }
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


        <script>
            function getByIdDelete(id) {
                document.getElementById("getNameByIdForDelete").value = id;
            }

            function getByIdUpdate(id) {
                document.getElementById("getNameByIdForUpdate").value = id;
            }
        </script>
    </head>
    <body>

        <%
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
                }
            } catch (Exception e) {

            }

            Travelpackages tr = new Travelpackages(null, countryName, date);

            List<Travelpackages> list = TravelPackagesDB.getAllByParameters(tr);

        %>

        <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
            <a class="navbar-brand" href="#">
                <img src="images2.jpeg" style="width:100px; height:60px;border-radius: 10px;"class="d-inline-block align-top"
                     >
            </a>
            <div class="dropdown">
                <button style="margin-right:40px;" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Menu
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="index.jsp">Exit</a>
                </div>
            </div>

        </nav>


        <div class="modal" id="delete">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="adminpage.jsp" method="GET">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Delete</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            Are you sure to delete?
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <input type="hidden" name="action" value="delete"/>
                            <input type="hidden" name="id" id="getNameByIdForDelete"/>
                            <input type="submit" class="btn btn-success" value="Yes">
                            <input type="submit" class="btn btn-danger" data-dismiss="modal" value="Cancel">
                        </div>  
                    </form>
                </div>
            </div>
        </div>

        <div class="modal" id="update">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="adminpage.jsp" method="POST">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Edit</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="row" style="margin-left: 10px">

                                <div class="form-group">
                                    <label for="name">Name</label><br>
                                    <input type="text" name="name" class="form-control"  placeholder="Countryname">

                                    <label for="surname">Date</label><br>
                                    <input type="text" name="date" class="form-control"  placeholder="DD-MM-YY">
                                </div>


                            </div>

                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <input type="hidden" name="action" value="update"/>
                            <input type="hidden" name="id" id="getNameByIdForUpdate"/>
                            <input type="submit" class="btn btn-success" value="Yes">
                            <input type="submit" class="btn btn-danger" data-dismiss="modal" value="Cancel">
                        </div>  
                    </form>
                </div>
            </div>
        </div>

        <div class="row" style="margin-left: 10px">
            <form class="col-md-3" method="POST">
                <div class="form-group">
                    <label for="name">Name</label><br>
                    <input type="text" name="name" class="form-control"  placeholder="Countryname">
                </div>
                <div class="form-group">
                    <label for="surname">Date</label><br>
                    <input type="text" name="date" class="form-control"  placeholder="DD-MM-YY">
                </div>

                <button type="submit" class="btn btn-success" name="action" value="add">Add</button>
                <button type="submit" class="btn btn-success" name="action" value="search">Search</button>
            </form>
        </div>
        <br>

        <div class="col-">
            <table class="table table-bordered">
                <thead>


                    <tr>
                        <th>#</th>
                        <th>Countryname</th>
                        <th>Date</th>
                        <th>Options</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        for (int i = 0; i < list.size(); i++) {
                            Travelpackages t = list.get(i);

                    %>

                    <tr>
                        <td><%=i + 1%></td>
                        <td><%=t.getCountryname()%></td>
                        <td><%=t.getDate()%></td>
                        <td>
                            <button class="btn btn-warning" data-toggle="modal" data-target="#update"
                                    onclick="getByIdUpdate('<%=t.getId()%>')"
                                    >
                                <i class="fa fa-pencil" aria-hidden="true"></i>


                            </button>

                            <button class="btn btn-danger" data-toggle="modal" data-target="#delete"
                                    onclick="getByIdDelete('<%=t.getId()%>')"
                                    >
                                <i class="fa fa-trash" aria-hidden="true"></i>


                            </button>

                        </td>

                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table> 


        </div>
    </body>
</html>
