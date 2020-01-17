<%-- 
    Document   : userpage
    Created on : Sep 15, 2019, 8:44:05 PM
    Author     : murad_isgandar
--%>

<%@page import="databases.UserDB"%>
<%@page import="entities.Users"%>
<%@page import="databases.TravelPackagesDB"%>
<%@page import="entities.Travelpackages"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>User packet</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <style>
            body{
                background: linear-gradient( #7f7fd5, #86a8e7, #91eae4);
            }
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


        <script>
            function getById(id) {
                document.getElementById("getNameById").value = id;
            }
        </script>

        <script>

            function informUser() {
                alert("Thank you for applying! Your information will be sent our database");
            }

        </script>


    </head>
    <body>
        <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
            <a class="navbar-brand" href="#">
                <img src="images2.jpeg" style="width:150px; height:60px;border-radius: 10px;"   class="d-inline-block align-top"
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



        <div class="row" style="margin-left: 10px">
            <form class="col-md-3" method="POST" action="UserController">
                <div class="form-group">
                    <label for="name">Name</label><br>
                    <input type="text" name="name" class="form-control" required="required" placeholder="Name">
                </div>
                <div class="form-group">
                    <label for="surname">Surname</label><br>
                    <input type="text" name="surname" class="form-control" required="required"  placeholder="Surname">
                </div>
                <div class="form-group">
                    <label for="age">Age</label><br>
                    <input type="number" name="age" class="form-control" required="required"  placeholder="Age">
                </div>
                <div class="form-group">
                    <label for="mail">Mail</label><br>
                    <input type="text" name="mail" class="form-control" required="required"  placeholder="example@gmail.com">
                </div>
                <div class="form-group">
                    <label for="phonenumber">Phone Number</label><br>
                    <input type="number" name="number" class="form-control" required="required"  placeholder="+994557696787">
                </div>

                <div class="form-group">
                    Man<input type="radio" name="gender" value="Man">
                </div>
                <div class="form-group">
                    Woman <input type="radio" name="gender" value="Woman">
                </div>
                <div class="form-group">
                    Other<input type="radio" name="gender" value="Other">
                </div>
                <%
                    List<Travelpackages> list = TravelPackagesDB.getAll();
                %>

                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>#</th>    
                            <th>Country</th>    
                            <th>Date</th>
                            <th>Order</th>
                        </tr>

                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < list.size(); i++) {
                                Travelpackages tt = list.get(i);
                        %>    
                    <td>
                        <%=i + 1%>
                    </td>

                    <td>
                        <%=tt.getCountryname()%>
                    </td>

                    <td>
                        <%=tt.getDate()%>
                    </td>
                    <td>

                        <button type="button" class="btn btn-primary"
                                onclick="getById('<%=tt.getId()%>')">
                            Choose</button>    
                    </td>

                    </tbody>
                    <%
                        }
                    %>
                </table>

                <input type="hidden" name="id" id="getNameById"/>
                <input type="hidden" name="action" value="add"/>
                <input type="submit" class="btn btn-success" onclick="informUser()" value="Submit">

            </form>

        </div>
        <div>

        </div>    

    </body>
</html>
