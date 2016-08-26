


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HW5 part 4 using Spring MVC</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    </head>
    <style>
        .saved{
            background-color: greenyellow;
        }
    </style>


    <body>
        <c:if test="${pageContext.request.method=='GET'}">
            <form method="POST" action="showDetails.htm?action=showDetails&entryPage=true&defaultContent=0">
                <h1>Please enter the file name below:</h1><br/>
                <input class="form-control" type="text" name="fileName"/><br/>
                <button type="submit" class="btn btn-success">Submit</button>

            </form>
        </c:if>

        
        
        <c:if test="${pageContext.request.method=='POST'}">
            
            
            <c:if test="${requestScope.pageNumber=='a'}">
                <form method="POST" id="myForm">
                    <h1>Check Below Details</h1>

                    <nav>
                        <ul class="pagination">
                            <li>
                                <a href="#" onclick="decrementSubmitMyform()" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <c:choose >
                                <c:when test="${sessionScope.paginationHelp==0 || sessionScope.paginationHelp<=2}">
                                    <li><a id="first" onclick="submitMyform('defaultContent=0')">1</a></li>
                                    <li><a id="second" onclick="submitMyform('defaultContent=1')">2</a></li>
                                    <li><a id="third" onclick="submitMyform('defaultContent=2')">3</a></li>
                                    <li><a id="fourth" onclick="submitMyform('defaultContent=3')">4</a></li>
                                    <li><a id="fifth" onclick="submitMyform('defaultContent=4')">5</a></li>
                                    </c:when>
                                    <c:when test="${sessionScope.paginationHelp >=sessionScope.paginationButtons-5}">
                                    <li><a id="first" onclick="submitMyform('defaultContent=310')">311</a></li>
                                    <li><a id="second" onclick="submitMyform('defaultContent=311')">312</a></li>
                                    <li><a id="third" onclick="submitMyform('defaultContent=312')">313</a></li>
                                    <li><a id="fourth" onclick="submitMyform('defaultContent=313')">314</a></li>
                                    <li><a id="fifth" onclick="submitMyform('defaultContent=314')">315</a></li>

                                </c:when>

                                <c:otherwise>
                                    <li><a id="first" onclick="submitMyform('defaultContent=${sessionScope.paginationHelp-2}')">${sessionScope.paginationHelp-2}</a></li>
                                    <li><a id="second" onclick="submitMyform('defaultContent=${sessionScope.paginationHelp-1}')">${sessionScope.paginationHelp-1}</a></li>
                                    <li><a id="third" onclick="submitMyform('defaultContent=${sessionScope.paginationHelp}')">${sessionScope.paginationHelp}</a></li>
                                    <li><a id="fourth" onclick="submitMyform('defaultContent=${sessionScope.paginationHelp+1}')">${sessionScope.paginationHelp+1}</a></li>
                                    <li><a id="fifth" onclick="submitMyform('defaultContent=${sessionScope.paginationHelp+2}')">${sessionScope.paginationHelp+2}</a></li>
                                    </c:otherwise>
                                </c:choose>



                            <li>
                                <a href="#" onclick="incrementSubmitMyform()" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>

                    <table id="salesOrderTable" border="1">
                        <tr>
                            <th></th>
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
                        <c:forEach  items="${sessionScope.salesOrderList}" var="salesOrder" varStatus="status">

                            <tr id="row${status.count}">
                                <td>${status.count}</td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.salesorderid}" name="salesorderid${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.revisionnumber}" name="revisionnumber${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.orderdate}" name="orderdate${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.duedate}" name="duedate${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.shipdate}" name="shipdate${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.status}" name="status${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.onlineorderflag}" name="onlineorderflag${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.salesordernumber}" name="salesordernumber${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.purchaseordernumber}" name="purchaseordernumber${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.accountnumber}" name="accountnumber${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.customerid}" name="customerid${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.salespersonid}" name="salespersonid${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.territoryid}" name="territoryid${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.billtoaddressid}" name="billtoaddressid${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.shiptoaddressid}" name="shiptoaddressid${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.shipmethodid}" name="shipmethodid${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.creditcardid}" name="creditcardid${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.creditcardapprovalcode}" name="creditcardapprovalcode${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.currencyrateid}" name="currencyrateid${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.subtotal}" name="subtotal${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.taxamt}" name="taxamt${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.freight}" name="freight${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.totaldue}" name="totaldue${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.comment}" name="comment${status.count}" /></td>
                                <td><input class="form-control" required  type="text" value="${salesOrder.modifieddate}" name="modifieddate${status.count}" /></td>
                                <td><a onclick="saveRow('row${status.count}')">Save</a></td>
                                <td><a onclick="deleteRow('row${status.count}')">Delete</a></td>
                            </tr>

                        </c:forEach>   




                    </table>       

                    <button type="submit" class="btn btn-success">Submit</button>
                </form>

            </c:if>
            
            
            <c:if test="${requestScope.pageNumber=='b'}">
                <h1>Successfully added ${requestScope.rowsAdded} number of rows to DB</h1>

            </c:if>
        </c:if>


        <script>

            function decrementSubmitMyform() {
                var page;

                if (${sessionScope.paginationHelp>6}) {
                    page = "${sessionScope.paginationHelp-5}";
                } else {
                    page = '0';
                }
                myForm = document.getElementById("myForm");
                myForm.action = 'showDetails.htm?action=showDetails&entryPage=false&defaultContent=' + page;
                myForm.submit();
            }
            
            function incrementSubmitMyform() {
                var page;

                if (${sessionScope.paginationHelp<307}) {
                    page = "${sessionScope.paginationHelp+5}";

                } else {
                    submitMyform("defaultContent=${sessionScope.paginationHelp}");
                }
                myForm = document.getElementById("myForm");
                myForm.action = 'showDetails.htm?action=showDetails&entryPage=false&defaultContent=' + page;
                myForm.submit();

            }
            
            function submitMyform(pageNumber) {
                myForm = document.getElementById("myForm");
                myForm.action = 'showDetails.htm?action=showDetails&entryPage=false&' + pageNumber;

                myForm.submit();

            }
            function deleteRow(rowId) {
                var row = document.getElementById(rowId);
                row.parentNode.removeChild(row);
                return;

            }
            var xmlHttp;
            xmlHttp = GetXmlHttpObject();

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

            function saveRow(rowId) {
                if (xmlHttp == null) {
                    alert("Your browser does not support AJAX");
                    return;
                }

                var row = document.getElementById(rowId);


                var salesorderid = row.cells[1].getElementsByTagName('input')[0].value;
                var revisionnumber = row.cells[2].getElementsByTagName('input')[0].value;
                var orderdate = row.cells[3].getElementsByTagName('input')[0].value;
                var duedate = row.cells[4].getElementsByTagName('input')[0].value;
                var shipdate = row.cells[5].getElementsByTagName('input')[0].value;
                var status = row.cells[6].getElementsByTagName('input')[0].value;
                var onlineorderflag = row.cells[7].getElementsByTagName('input')[0].value;
                var salesordernumber = row.cells[8].getElementsByTagName('input')[0].value;
                var purchaseordernumber = row.cells[9].getElementsByTagName('input')[0].value;
                var accountnumber = row.cells[10].getElementsByTagName('input')[0].value;
                var customerid = row.cells[11].getElementsByTagName('input')[0].value;
                var salespersonid = row.cells[12].getElementsByTagName('input')[0].value;
                var territoryid = row.cells[13].getElementsByTagName('input')[0].value;
                var billtoaddressid = row.cells[14].getElementsByTagName('input')[0].value;
                var shiptoaddressid = row.cells[15].getElementsByTagName('input')[0].value;
                var shipmethodid = row.cells[16].getElementsByTagName('input')[0].value;
                var creditcardid = row.cells[17].getElementsByTagName('input')[0].value;
                var creditcardapprovalcode = row.cells[18].getElementsByTagName('input')[0].value;
                var currencyrateid = row.cells[19].getElementsByTagName('input')[0].value;
                var subtotal = row.cells[20].getElementsByTagName('input')[0].value;
                var taxamt = row.cells[21].getElementsByTagName('input')[0].value;
                var freight = row.cells[22].getElementsByTagName('input')[0].value;
                var totaldue = row.cells[23].getElementsByTagName('input')[0].value;
                var comment = row.cells[24].getElementsByTagName('input')[0].value;
                var modifieddate = row.cells[25].getElementsByTagName('input')[0].value;



                var query = "action=addToDB&salesorderid=" + salesorderid + "&revisionnumber=" + revisionnumber + "&orderdate=" + orderdate + "&duedate=" + duedate
                        + "&shipdate=" + shipdate + "&status=" + status + "&onlineorderflag=" + onlineorderflag + "&salesordernumber=" + salesordernumber + "&purchaseordernumber=" + purchaseordernumber + "&accountnumber=" + accountnumber + "&customerid=" + customerid + "&salespersonid=" + salespersonid + "&territoryid=" + territoryid + "&billtoaddressid=" + billtoaddressid + "&shiptoaddressid=" + shiptoaddressid + "&shipmethodid=" + shipmethodid + "&creditcardid=" + creditcardid + "&creditcardapprovalcode=" + creditcardapprovalcode + "&currencyrateid=" + currencyrateid + "&subtotal=" + subtotal + "&taxamt=" + taxamt + "&freight=" + freight + "&totaldue=" + totaldue + "&comment=" + comment + "&modifieddate=" + modifieddate;
                xmlHttp.onreadystatechange = function statusChanged() {
                    if (xmlHttp.readyState == 4) {
                        
                        var td = row.getElementsByTagName("td");
                        row.className = "saved";
                        row.cells[26].innerHTML = "Saved";
                        row.cells[27].innerHTML = "Delete";
                    }
                };

                xmlHttp.open("POST", "showDetails.htm", true);
                xmlHttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
                xmlHttp.send(query);
                return false;




                return false;
            }
        </script>

        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

    </body>
</html>