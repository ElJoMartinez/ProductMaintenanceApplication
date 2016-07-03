<%-- 
    Document   : deleteProduct
    Created on : Jul 2, 2016, 1:59:07 PM
    Author     : Elliot Martinez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main.css" type="text/css" />
        <title>Product Maintenance</title>
    </head>
    <body>
        <h1>Are you sure you want to delete this product?</h1>
        <p><h3>Code:</h3><div class="item">${productCode}</div></p>
        <p><h3>Description:</h3><div class="item">${productDescription}</div></p>
        <p><h3>Price:</h3><div class="item">$${productPrice}</div></p>
        <form action="productMaint" method="post">
            <input type="hidden" name="productCode" value="<c:out value='${productCode}'/>">
            <input type="hidden" name="action" value="confirmDelete">
            <input type="submit" value="Yes">
        </form>
        <form action="productMaint" method="post">
            <input type="hidden" name="action" value="displayProducts">
            <input type="submit" value="No">
        </form>
        
    </body>
</html>