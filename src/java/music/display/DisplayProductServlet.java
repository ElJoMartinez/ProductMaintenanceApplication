package music.display;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import music.data.ProductIO;
import music.business.Product;


public class DisplayProductServlet extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
         
        String url = "/index.jsp";
        String path = this.getServletContext().getRealPath("/WEB-INF/products.txt");
        ProductIO.init(path);
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "displayProducts";  // default action  
        }
        
        // Handles displayProducts action
        if (action.equalsIgnoreCase("displayProducts")) { 
            
            List<Product> products = ProductIO.selectProducts();
            request.setAttribute("products", products);
            url = "/products.jsp";
        }
        
        // Handles addProduct action
        // When adding a product, we must provide an empty form
        else if (action.equalsIgnoreCase("addProduct")) {
            String productCode ="";
            url = "/product.jsp";
        }
        
        // Handles editProduct action
        else if (action.equalsIgnoreCase("editProduct")) {
            String productCode = request.getParameter("productCode");
            String productDescription = request.getParameter("productDescription");
            String price = request.getParameter("productPrice");
            
            
            request.setAttribute("productCode", productCode);
            request.setAttribute("productDescription", productDescription);
            request.setAttribute("productPrice", price);
            
            
            url = "/product.jsp";
        }
        
        
        // Handles deleteProduct action
        else if (action.equalsIgnoreCase("deleteProduct")) {
            url="/deleteProduct.jsp";
            String productCode = request.getParameter("productCode");
            String productDescription = request.getParameter("productDescription");
            String price = request.getParameter("productPrice");
            
            
            request.setAttribute("productCode", productCode);
            request.setAttribute("productDescription", productDescription);
            request.setAttribute("productPrice", price);
            
            
        }
        
        // Handle updateProduct action
        else if (action.equalsIgnoreCase("updateProduct")) {
            String message ="";
            String numberMessage="";
            String productCode = request.getParameter("productCode");
            String productDescription = request.getParameter("productDescription");
            String price = request.getParameter("productPrice");
            double priceAsDouble=0L;
            try {
              priceAsDouble = Double.parseDouble(price);
            } catch(NumberFormatException e) {
                numberMessage = "Please Enter a valid price value";
                url="/product.jsp";
                request.setAttribute("numberMessage", numberMessage);
            }
            
            
            if (productCode == null || productDescription == null ||
                price == null || productCode.isEmpty() ||
                productDescription.isEmpty() || price.isEmpty()) {
                message = "Please fill out all three text boxes";
                url = "/product.jsp";
            }
            if(numberMessage.isEmpty()) {
                Product p = new Product();
                if(ProductIO.exists(productCode)) {
                    p = ProductIO.selectProduct(productCode);
                    p.setDescription(productDescription);
                    p.setPrice(priceAsDouble);
                    ProductIO.updateProduct(p);
                }
                else {
                    p.setCode(productCode);
                    p.setDescription(productDescription);
                    p.setPrice(priceAsDouble);
                    ProductIO.insertProduct(p);
                }
                url="/products.jsp";
            }
            List<Product> products = ProductIO.selectProducts();    
            
            request.setAttribute("products", products);
            request.setAttribute("message", message);
            request.setAttribute("productCode", productCode);
            request.setAttribute("productDescription", productDescription);
            request.setAttribute("productPrice", price);  
        }
     
        //Handle confirmDelete Action
        else if(action.equalsIgnoreCase("confirmDelete")) {
            String productCode = request.getParameter("productCode");
            Product p = ProductIO.selectProduct(productCode);
            ProductIO.deleteProduct(p);
            List<Product> products = ProductIO.selectProducts();
            request.setAttribute("products", products);
            url="/products.jsp";
        }
        
        // forward to the view
        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
        
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }
}
