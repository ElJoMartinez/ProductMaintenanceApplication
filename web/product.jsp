<%-- 
    Document   : product
    Created on : Jul 2, 2016, 1:58:46 PM
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
        <div><h1>Product</h1>    
        </div>
        <p><i><c:out value="${message}" /></i></p>
        <p><i><c:out value="${numberMessage}" /></i></p>
        <form action="productMaint" method="post">
            <label>Code:</label>
            <input type="text" name="productCode" maxlength="4" size="4"
                   value="<c:out value='${productCode}'/>"><br>
            <label>Description:</label>
            <input type="text" name="productDescription" size="55"
                   value="<c:out value='${productDescription}'/>"><br>
            <label>Price:</label>
            <input type="text" name="productPrice" maxlength="6" size="6"
                   value="<c:out value='${productPrice}'/>"><br>
            <input type="hidden" name="action" value="updateProduct">
            <input type="submit" value="Update Product" style="margin-left: 6em;">
        </form>
          
            <form action="productMaint">
            <input type="hidden" name="action" value="displayProducts">
            <input type="submit" value="View Products"> 
        </form>
            
        </div>
    </body>
</html>