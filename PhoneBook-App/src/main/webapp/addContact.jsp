<%-- 
    Document   : addContact
    Created on : Mar 10, 2026, 8:53:54 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Components/allLink.jsp" %>
    </head>
    <body>
          <%@include file="Components/Navbar.jsp" %>
         <div class="container-fluid">
             <div class="row p-2">
                 <div class="col-md-6 offset-md-3">
                     <div class="card">
                         <div class="card-body">
                             <h4 class="text-center text-success">Add Contact Page</h4>
                             <form>
                                 
                                   <div class="form-group">
                                  <label for="exampleInputEmail1">Enter Name</label>
                                  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                                </div>
                                 
                                <div class="form-group">
                                  <label for="exampleInputEmail1">Email address</label>
                                  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                                </div>
                                 
                                  <div class="form-group">
                                  <label for="exampleInputEmail1">Enter Phone No</label>
                                  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                                </div>
                             
                                  
                                  <div class="text-center mt-2"> 
                                      <button type="submit" class="btn btn-primary">Register</button>
                                  </div>
                                                               
                              </form>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
    </body>
</html>
