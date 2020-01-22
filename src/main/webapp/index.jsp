<%-- 
    Document   : index.jsp
    Created on : Sep 14, 2019, 4:31:20 PM
    Author     : murad_isgandar
--%>

<%@page import="config.LoginConfig"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Properties"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Travel Company</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Murad Isgandarli">

        <style>
            body{
                background: linear-gradient( #7f7fd5, #86a8e7, #91eae4);
            }
        </style>

        <link rel="stylesheet" href="index.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-info static-top">
            <div class="container">
                <a class="navbar-brand" href="home">
                    <img src="index6.jpeg"alt="" style="width: 200px;height: 80px;border-radius: 50%">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="home">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login">Log In
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="card-deck">
            <div class="card">
                <img class="card-img-top" src="download.jpg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Pisa Tower</h5>
                    <p class="card-text">
                        Welcome,We have travel packet to Italy,
                        you have great chance to see Pisa Tower 
                        only paying 100 euro.We think that it will
                        be very interesting for you.If you think
                        like us, be quick
                    </p>

                    <a class="btn btn-primary" href="https://en.wikipedia.org/wiki/Leaning_Tower_of_Pisa" target="blank" role="button">About Pisa</a>
                </div>
            </div>
            <div class="card">
                <img class="card-img-top" src="index7.jpeg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Egypt Pyramids</h5>
                    <p class="card-text">
                        Welcome,We have travel packet to Egypt,
                        you have great chance to see Egypt Pyramids 
                        only paying 100 euro.We think that it will
                        be very interesting for you.If you think
                        like us, be quick
                    </p>

                    <a class="btn btn-primary" href="https://en.wikipedia.org/wiki/Egyptian_pyramids" target="blank" role="button">About Pyramids</a>
                </div>
            </div>
            <div class="card">
                <img class="card-img-top" src="images1.jpeg" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">Eiffel Tower</h5>
                    <p class="card-text">
                        Welcome,We have travel packet to France,
                        you have great chance to see Eiffel Tower 
                        only paying 100 euro.We think that it will
                        be very interesting for you.If you think
                        like us, be quick
                    </p>
                    <br>
                    <br>
                    <a class="btn btn-primary" href="https://en.wikipedia.org/wiki/Eiffel_Tower" target="blank" role="button">About Eiffel</a>
                </div>
            </div>

        </div>

        <div class="container-fluid p-3 p-md-5">
            <ul class="bd-footer-links" >
                <p>Copyright © 2019.&nbsp;All rights are reserved!</p>
                <p>Developed by &nbsp;<a href="https://github.com/muradisgandar" target="blank">Murad Isgandarli</a></p>
            </ul>

        </div>



    </body>

</html>
