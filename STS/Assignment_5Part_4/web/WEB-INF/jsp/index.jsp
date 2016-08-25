<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.me.pojo.Sales"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
    <c:when test="${!empty sessionScope.numberOfrows}">
        <h1>"${sessionScope.numberOfrows}" records added</h1>

    </c:when>

    <c:otherwise>


        <%

            if (request.getMethod().equalsIgnoreCase("post")) {


        %>     
        <html>
            <h1>Sales Table</h1><br/>

            <body>
                <form action="addToDb.htm?action=addToDb" method="post">


                    <table id="myTable" border="1">

                        <tr>
                            <th>SalesOrderID</th>
                            <th>RevisionNumber</th>
                            <th>OrderDate</th>
                            <th>DueDate</th>
                            <th>ShipDate</th>
                            <th>Status</th>
                            <th>OnlineOrderFlag</th>
                            <th>SalesOrderNumber</th>
                            <th>PurchaseOrderNumber</th>
                            <th>AccountNumber</th>
                            <th>CustomerID</th>
                            <th>SalesPersonID</th>
                            <th>TerritoryID</th>
                            <th>BillToAddressID</th>
                            <th>ShipToAddressID</th>
                            <th>ShipMethodID</th>
                            <th>CreditCardID</th>
                            <th>CreditCardApprovalCode</th>
                            <th>CurrencyRateID</th>
                            <th>SubTotal</th>
                            <th>TaxAmt</th>
                            <th>Freight</th>
                            <th>TotalDue</th> 
                            <th>Comment</th>
                            <th>ModifiedDate</th>

                        </tr>


                        <c:forEach var="sales" items="${requestScope.sList}" varStatus="theCount">


                            <tr id="row${theCount.count}">

                                <td><input type="text" name="sales" value="${sales.salesOrderId}"/></td>
                                <td><input type="text" name="sales" value="${sales.revisionNumber}" /></td>
                                <td><input type="text" name="sales" value="${sales.orderDate}" /></td>
                                <td><input type="text" name="sales" value="${sales.dueDate}" /></td>        
                                <td><input type="text" name="sales" value="${sales.shipDate}" /></td>        
                                <td><input type="text" name="sales" value="${sales.status}" /></td>        
                                <td><input type="text" name="sales" value="${sales.onlineOrderFlag}" /></td>        
                                <td><input type="text" name="sales" value="${sales.salesOrderNumber}" /></td>
                                <td><input type="text" name="sales" value="${sales.purchaseOrderNumber}" /></td>
                                <td><input type="text" name="sales" value="${sales.accountNumber}" /></td>
                                <td><input type="text" name="sales" value="${sales.customerId}" /></td>
                                <td><input type="text" name="sales" value="${sales.salesPersonId}" /></td>
                                <td><input type="text" name="sales" value="${sales.territoryId}" /></td>
                                <td><input type="text" name="sales" value="${sales.billToAddressId}" /></td>
                                <td><input type="text" name="sales" value="${sales.shipToAddressId}" /></td>
                                <td><input type="text" name="sales" value="${sales.shipMethodId}" /></td>
                                <td><input type="text" name="sales" value="${sales.creditCardId}" /></td>
                                <td><input type="text" name="sales" value="${sales.creditCardApprovalCode}" /></td>
                                <td><input type="text" name="sales" value="${sales.currencyRateId}" /></td>
                                <td><input type="text" name="sales" value="${sales.subTotal}" /></td>
                                <td><input type="text" name="sales" value="${sales.taxAmt}" /></td>
                                <td><input type="text" name="sales" value="${sales.freight}" /></td>
                                <td><input type="text" name="sales" value="${sales.totalDue}" /></td>
                                <td><input type="text" name="sales" value="${sales.comment}" /></td>
                                <td><input type="text" name="sales" value="${sales.modifiedDate}" /></td>
                                <td id="save${theCount.count}"><a href='#' onclick="submitFormToAdd(${theCount.count});">save</a></td>
                                <td><a href='#' onclick="submitFormToDelete(this);">Delete</a></td>

                            </tr>

                        </c:forEach>

                    </table>

                    <table border="1" cellpadding="5" cellspacing="5">
                        <tr>
                            <c:forEach begin="1" end="${requestScope.totalPages}" var="i">
                                <c:choose>
                                    <c:when test="${requestScope.currentPage eq i}">
                                        <td>${i}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><a href='#' onclick="submitform(${i})">${i}</a></td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                        </tr>
                    </table><br/>

                    <a href='#' onclick="submitform(${(requestScope.currentPage)+1})">Next</a>


                </form>
                <form action="display.htm?action=display" id ="myForm" method="post">
                    <input type="hidden" id="myPage" name="page" value=""/>   
                </form>

                <script>
                    function submitform(Val) {

                        document.getElementById("myPage").value = Val;

                        document.getElementById("myForm").submit();
                    }

                </script>
                <script>

                    var xmlHttp;
                    xmlHttp = GetXmlHttpObject();
                    function submitFormToAdd(idr) {
                        if (xmlHttp == null)
                        {
                            alert("Your browser does not support AJAX!");
                            return;
                        }
                        var rowElements = document.getElementById("row" + idr);

                        var salesOrderId = rowElements.cells[0].firstChild.value;
                        var revisionNumber = rowElements.cells[1].firstChild.value;
                        var orderDate = rowElements.cells[2].firstChild.value;
                        var dueDate = rowElements.cells[3].firstChild.value;
                        var shipDate = rowElements.cells[4].firstChild.value;
                        var status = rowElements.cells[5].firstChild.value;
                        var onlineOrderFlag = rowElements.cells[6].firstChild.value;
                        var salesOrderNumber = rowElements.cells[7].firstChild.value;
                        var purchaseOrderNumber = rowElements.cells[8].firstChild.value;
                        var accountNumber = rowElements.cells[9].firstChild.value;
                        var customerId = rowElements.cells[10].firstChild.value;
                        var salesPersonId = rowElements.cells[11].firstChild.value;
                        var territoryId = rowElements.cells[12].firstChild.value;
                        var billToAddressId = rowElements.cells[13].firstChild.value;
                        var shipToAddressId = rowElements.cells[14].firstChild.value;
                        var shipMethodId = rowElements.cells[15].firstChild.value;
                        var creditCardId = rowElements.cells[16].firstChild.value;
                        var creditCardApprovalCode = rowElements.cells[17].firstChild.value;
                        var currencyRateId = rowElements.cells[18].firstChild.value;
                        var subTotal = rowElements.cells[19].firstChild.value;
                        var taxAmt = rowElements.cells[20].firstChild.value;
                        var freight = rowElements.cells[21].firstChild.value;
                        var totalDue = rowElements.cells[22].firstChild.value;
                        var comment = rowElements.cells[23].firstChild.value;
                        var modifiedDate = rowElements.cells[24].firstChild.value;
                        var btn = document.getElementById("save" + idr);

                        
                        xmlHttp.onreadystatechange = function stateChanged()
                        {
                            if (xmlHttp.readyState == 4)
                            {
                                document.getElementById("row" + idr).style.backgroundColor = "#00FF00";
                                btn.style.display="none";

                            }
                        };

                        var query = "action=addToDb&salesOrderId=" + salesOrderId + "&revisionNumber=" + revisionNumber + "&orderDate=" + orderDate + "&dueDate=" + dueDate +
                                "&shipDate=" + shipDate + "&status=" + status + "&onlineOrderFlag=" + onlineOrderFlag + "&salesOrderNumber=" + salesOrderNumber +
                                "&purchaseOrderNumber=" + purchaseOrderNumber + "&accountNumber=" + accountNumber +
                                "&customerId=" + customerId + "&salesPersonId=" + salesPersonId + "&territoryId=" + territoryId + "&billToAddressId=" + billToAddressId +
                                "&shipToAddressId=" + shipToAddressId + "&shipMethodId=" + shipMethodId + "&creditCardId=" + creditCardId + "&creditCardApprovalCode=" + creditCardApprovalCode +
                                "&currencyRateId=" + currencyRateId + "&subTotal=" + subTotal + "&taxAmt=" + taxAmt + "&freight=" + freight + "&totalDue=" + totalDue + "&comment=" + comment +
                                "&modifiedDate=" + modifiedDate;

                        xmlHttp.open("POST", "addToDb.htm", true);
                        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                        xmlHttp.send(query);
                        return false;
                    }


                    function GetXmlHttpObject()
                    {
                        var xmlHttp = null;
                        try
                        {
                            // Firefox, Opera 8.0+, Safari
                            xmlHttp = new XMLHttpRequest();
                        } catch (e)
                        {
                            // Internet Explorer
                            try
                            {
                                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                            } catch (e)
                            {
                                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                            }
                        }
                        return xmlHttp;
                    }


                    function submitFormToDelete(idrow) {

                        var p = idrow.parentNode.parentNode;

                        p.parentNode.removeChild(p);


                    }
                </script>
            </body>
        </html>
        <%          } else {


        %>   

        <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Welcome to Spring Web MVC project</title>
            </head>

            <body>
                <form action="display.htm?action=display" method="post" enctype="multipart/form-data">
                    <p>Please enter the name of the file</p><br/>

                    <input type="text" name="fileName"/><br/><br/>

                    <input type="submit" name="submit"/>
                </form>


            </body>

        </html>
        <%    }

        %>
    </c:otherwise>
</c:choose>


