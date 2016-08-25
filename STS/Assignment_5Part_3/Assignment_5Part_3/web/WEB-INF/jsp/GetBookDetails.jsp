<%-- 
    Document   : GetBookDetails
    Created on : Feb 8, 2016, 2:39:33 AM
    Author     : Avanish
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="CCFFFF">
        
       
        <div align="center">
        <h1>Enter book details :-</h1><hr/><br/>
        <form action="AddToDb.htm" method="post">

            
            <table border="1">
                <tr>
                    <th>ISBN</th>
                    <th>Book Title</th>
                    <th>Authors</th>
                    <th>Price</th>  
                </tr>

                <c:forEach var="i" begin="1" end="${sessionScope.val}">
                    <tr>
                        <td><input type="text" name="isbn" required/></td>
                        <td><input type="text" name="bookTitle" required/></td>
                        <td><input type="text" name="author" required/></td>
                        <td><input type="number" name="price" min="1" required/></td>
                    </tr>

                </c:forEach>


            </table><br/>
                        
                        <input type="submit" value="Add Books" style="width: 250px; height: 50px">

                      

        </form>
        </div>
    </body>
</html>
