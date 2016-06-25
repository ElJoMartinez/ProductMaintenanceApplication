<%-- 
    Document   : products.jsp
    Created on : Jun 24, 2016, 8:48:24 PM
    Author     : toillezenitram
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Product Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css" />
    </head>
    <body>
        <div><h1>Products</h1></div>
        <table>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th class="right">Price</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="product" items="${requestScope.products}">
            <tr>
                <td>${product.code}</td>
                <td>${product.description}</td>
                <td class="right">${product.price}</td>
                <td><a href="productMaint?action=editProduct">Edit</a></td>
                <td><a href="productMaint?action=deleteProduct">Delete</a></td>
            </tr>
            
            </c:forEach>
        </table>
    </body>
</html>
