
package io.test;

/**
 *
 * @author Elliot Martinez
 */
import java.util.*;
import music.business.Product;
import music.data.ProductIO;
import org.junit.*;

public class ProductIOTest {
    
    @Test
    public void deleteProductTest() {
        ProductIO.init("/Users/toillezenitram/ProductMaintenanceApplication/web/WEB-INF/products.txt");
        Product p = ProductIO.selectProduct("pf01");
        System.out.println(p.getCode());
        ProductIO.deleteProduct(p);
        
    }
    
}
