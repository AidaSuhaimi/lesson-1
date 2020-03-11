<%-- 
    Document   : addEmployee
    Created on : Nov 3, 2019, 9:23:29 PM
    Author     : Wan Aqeera
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <title>W3.CSS Template</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
    </style>
    <body class="w3-light-grey">

        <!-- Top container -->
        <div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
            <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
            <span class="w3-bar-item w3-right">Logo</span>
        </div>

        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
            <div class="w3-container w3-row">
                <div class="w3-col s4">
                    <img src="/images/adminIcon.png" class="w3-circle w3-margin-right" style="width:46px">
                </div>
                <div class="w3-col s8 w3-bar">
                    <span>Welcome, <strong>Admin</strong></span><br>
                    <a href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
                    <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
                </div>
            </div>
            <hr>
            <div class="w3-container">
                <h4>Dashboard</h4><br>
            </div>
            <div class="w3-bar-block">
                <a href="Homepage" class="w3-bar-item w3-button w3-padding"><i class="fa fa-diamond fa-fw"></i>    Main Page</a>
                <a href="UpdatePassword" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bell fa-fw"></i>  Update Password</a>
                <a href="ViewEmployee" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>  View Staff</a>
                <a href="ViewDepartment" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>  View Department</a>
                <a href="ViewSalary" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>  View Salary</a>
                <a href="ViewPosition" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>  View Position</a>
                <a href="ViewAdmin" class="w3-bar-item w3-button w3-padding"><i class="fa fa-users fa-fw"></i>  View Admin</a>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-cog fa-fw"></i>  Logout</a>

            </div>
        </nav>


        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">

            <!-- Header -->
            <header class="w3-container" style="padding-top:22px">
                <h5><b><i class="fa fa-dashboard"></i> Employee Registration</b></h5>
            </header>

            <div class="container">
                <form method="POST" action="AddEmployeeController" style="border:5px solid #ccc">


                    <p></p>
                    <p></p>
                    <br/>

                    <table align="center">
                        <input type="hidden" name="user_id" value="">

                        <tr><td><b>Employee ID</b></td>
                            <td>:</td>
                            <td><input type="text" name="empID" value="" required autocomplete="off"></td>
                        </tr>
                        
                        <tr><td><b>Name</b></td>
                            <td>:</td>
                            <td><input type="text" name="empName" value="" required autocomplete="off"></td>
                        </tr>
                        
                        <tr><td><b>IC Number</b></td>
                            <td>:</td>
                            <td><input type="text" name="empIC" value="" required autocomplete="off"></td>
                        </tr>
                        
                        <tr><td><b>Address</b></td>
                            <td>:</td>
                            <td><input type="text" name="address" value="" required autocomplete="off"></td>
                        </tr>

                        <tr><td><b>Email</b></td>
                            <td>:</td>
                            <td><input type="text" name="email" value="" required autocomplete="off"></td>
                        </tr>

                        <tr><td><b>Phone Number</b></td>
                            <td>:</td>
                            <td><input type="text" name="phoneNum" value="" required autocomplete="off"></td>
                        </tr>

                        <tr><td><b>Gender</b></td>
                            <td>:</td>
                            <td><input type="radio" name="gender" value="Male">Male</td>
                            <td><input type="radio" name="gender" value="Female">Female</td>
                        </tr>
                        
                        <tr><td><b>Date Of Birth</b></td>
                            <td>:</td>
                            <td><input type="date" name="dob" value="" required autocomplete="off"></td>
                        </tr>

                        <tr><td><b>Department</b></td>
                            <td>:</td>
                            <td>
                                <select name="department" id="department">
                                    <option value="">Select Department</option>
                                    <%
                                        String driver = "org.apache.derby.jdbc.ClientDriver";
                                        String connectionString = "jdbc:derby://localhost:1527/Administrator";

                                 try {
                                     Connection conn;
                                            conn = DriverManager.getConnection(connectionString);

                                     String query = "SELECT * FROM DEPARTMENT";

                         // create the java statement
                                     Statement st = conn.createStatement();

                                     // execute the query, and get a java resultset
                                     ResultSet rs = st.executeQuery(query);

                                    

                                        
                                        while (rs.next()) {%>

                                        <option value="<%=rs.getString("dep_id")%>"><%=rs.getString("dep_name")%>
                                        </option>

                                    <%
                                        }
                                     }

                                        catch (SQLException ex) {
                                            ex.getErrorCode();
                                    }
                                 
                                    %>
                                    
                                </select>
                            </td>
                        </tr>
                        <tr><td><b>Position</b></td>
                            <td>:</td>
                            <td>
                                <select name="position" id="position">
                                    <option value="">Select Position</option>
                                    <%
                                        driver = "org.apache.derby.jdbc.ClientDriver";
                                        connectionString = "jdbc:derby://localhost:1527/Administrator";

                                 try {
                                     Connection conn;
                                            conn = DriverManager.getConnection(connectionString);

                                     String query = "SELECT * FROM POSITION";

                         // create the java statement
                                     Statement st = conn.createStatement();

                                     // execute the query, and get a java resultset
                                     ResultSet rs = st.executeQuery(query);


                                        while (rs.next()) {%>

                                        <option value="<%=rs.getString("position_id")%>"><%=rs.getString("position_name")%>
                                        </option>

                                    <%
                                        }
                                     }

                                        catch (SQLException ex) {
                                            ex.getErrorCode();
                                    }
                                 
                                    %>
                                </select>
                            </td>
                        </tr>
                        
                        <tr><td><b>Salary</b></td>
                            <td>:</td>
                            <td><input type="text" name="salary" value="" required autocomplete="off"></td>
                        </tr>
                        
                        
                        
                        
                    </table>
                    <p></p>
                    <p></p>
                    <center>
                        <button type="submit" class="w3-btn w3-black">Update</button>
                        <button type="submit" class="w3-btn w3-black" onclick="window.history.back();"/> Cancel</button>
                    </center>
                    <br><br>
                </form>

                <!-- end .content -->
            </div>


            <!-- Footer -->
            <footer class="w3-container w3-padding-16 w3-light-grey">
                <p>© Copyright 2019</p>
            </footer>

            <!-- End page content -->
        </div>

        <script>
            // Get the Sidebar
            var mySidebar = document.getElementById("mySidebar");

            // Get the DIV with overlay effect
            var overlayBg = document.getElementById("myOverlay");
            

            // Toggle between showing and hiding the sidebar, and add overlay effect
            function w3_open() {
                if (mySidebar.style.display === 'block') {
                    mySidebar.style.display = 'none';
                    overlayBg.style.display = "none";
                } else {
                    mySidebar.style.display = 'block';
                    overlayBg.style.display = "block";
                }
            }

            // Close the sidebar with the close button
            function w3_close() {
                mySidebar.style.display = "none";
                overlayBg.style.display = "none";
            }
            
        </script>

    </body>
</html>