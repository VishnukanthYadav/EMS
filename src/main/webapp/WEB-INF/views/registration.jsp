<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>	Registration</title>
</head>
<body>
     <h2> Registration Here...</h2>
     <form action="registration" method="post" >
         <pre>
            Name: <input type="text" name="name" />
            Email: <input type="text" name="email" />
            Course: <input type="text" name="course" />
            Mobile: <input type="text" name="mobile" />
            <input type ="submit" value="register" />
         </pre>
     </form>
     <%
          if(request.getAttribute("message")!=null){
        	  out.println(request.getAttribute("message"));
          }
     %>
</body>
</html>