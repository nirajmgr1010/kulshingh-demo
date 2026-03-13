<%-- 
    Document   : register
    Created on : Mar 10, 2026, 8:32:49 PM
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
    <body style="background-color: #f7faf8;">
         <%@include file="Components/Navbar.jsp" %>
         <div class="container-fluid">
             <div class="row p-2">
                 <div class="col-md-4 offset-md-4">
                     <div class="card">
                         <div class="card-body">
                             <h4 class="text-center text-success">Login Page</h4>
                             <form>                            
                                 
                                <div class="form-group">
                                  <label for="exampleInputEmail1">Email address</label>
                                  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                                </div>
                                <div class="form-group">
                                  <label for="exampleInputPassword1">Password</label>
                                  <input type="password" class="form-control" id="exampleInputPassword1">
                                  
                                  <div class="text-center mt-2"> 
                                      <button type="submit" class="btn btn-primary">Login</button>
                                  </div>
                                </div>
                                
                              </form>
                         </div>
                     </div>
                 </div>
             </div>
         </div>

         <div style="margin-top: 260px">
             <%@include file="Components/footer.jsp" %>
         </div>
       
    </body>
</html>
