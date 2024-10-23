<%-- 
    Document   : planReport
    Created on : 23 Oct 2024, 11:52:53 pm
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Product plan for Octorber and November 2024</h1>
        <table>
            <tr>
                <td>PLan ID: </td>
                <td></td>
            </tr>
            <tr>
                <td>Workshop: </td>
                <td>No.01</td>
            </tr>
            <tr>
                <td>Workshop Manager: </td>
                <td>Nguyen Van A</td>
            </tr>
            <tr>
                <td>General Plan: </td>
                <td>
                    <table>
                        <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Quantity(unit piece)</th>
                            </tr>
                            <c:forEach var="pc" items="${pros}">
                              <tr>
                                <td>
                                    ${pc.product.id}
                                </td>
                                <td>
                                    ${pc.product.name}
                                </td>
                                <td>
                                    ${pc.quantity}
                                </td>
                             </tr>
                            </c:forEach>
                        </thead>
                    </table>
                </td>
            </tr>
        </table>
        <h2>The detailed production plan is listed in the table below</h2>
    </body>
</html>
