
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body bgcolor="CCFFFF">
        <form name="myForm" action="AddBookDetails.htm" method="post">
            
        <h1 align="center">How many books you want to add?</h1>
        <div align="center">
            <input type="number" min="1" max="10" name="noOfBook"/>
        <input type="submit" onclick="validateForm();" value="Submit"/>
        </div>
        </form>
        
        <script type="text/javascript">
    function validateForm() {
    var x = document.forms["myForm"]["noOfBook"].value;
    if (x == null || x == "") {
        alert("Value must be filled out");
       
    }
}
    </script>
    </body>
</html>
