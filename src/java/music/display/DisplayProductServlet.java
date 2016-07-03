package display;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.junit.Assert;

import music.data.ProductIO;
import music.business.Product;


public class DisplayProductServlet extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String url = "/index.jsp";
        ServletContext sc = this.getServletContext();
        String path = sc.getRealPath("/WEB-INF/products.txt");

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "displayProucts";  // default action
        }
        
        // Handles displayProducts action
        if (action.equalsIgnoreCase("displayProducts")) { 
            ProductIO.init(path);
            List<Product> products = ProductIO.selectProducts();
            request.setAttribute("products", products);
            url = "/products.jsp";
        }
        
        // Handles addProduct action
        else if (action.equalsIgnoreCase("addProduct")) {
            
            
            url = "/addProduct.jsp";
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
