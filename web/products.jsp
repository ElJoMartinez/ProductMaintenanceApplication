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
                <td><c:out value="${product.code}" /></td>
                <td><c:out value="${product.description}" /></td>
                <td class="right">$<c:out value="${product.price}" /></td>
                <td><a href="productMaint?action=editProduct&amp;productCode=${product.code}&amp;productDescription=${product.description}&amp;productPrice=${product.price}">Edit</a></td>
                <td><a href="productMaint?action=deleteProduct&amp;productCode=${product.code}&amp;productDescription=${product.description}&amp;productPrice=${product.price}">Delete</a></td>
            </tr>
            </c:forEach>
        </table>
            <div class="vspacer"></div>
        <form action="productMaint" method="post">
            <input type="hidden" name="action" value="addProduct">
            <input type="submit" value="Add Product">
        </form>
    </body>
</html>
