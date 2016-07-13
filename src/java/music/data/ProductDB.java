package music.data;
import music.business.Product;
import javax.persistence.*;

/**
 *
 * @author Matthew Kastro
 * 
 * things to do:
 * 
 * Project 4: Product Maintenance with a database using JPA
 * 
 * Add JPA annotations to the Product class
 * create Add, Update, and Delete for the products in the Product Maintenance application.
 * This class should use the EclipseLink JPA Provider
 * 
 * This class should be using the music_jpa database created from appendix A (PC) or B (Mac)
 */


public class ProductDB {

    
    public void AddProduct(Long ID, String code, String desc, Double price) {
        EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("PRODUCT");
    EntityManager em = entityManagerFactory.createEntityManager();
    EntityTransaction userTransaction = em.getTransaction();
    
    userTransaction.begin();
    
    Product product = new Product();
    product.setId(ID);
    product.setCode(code);
    product.setDescription(desc);
    product.setPrice(price);
    
    
    em.persist(product);
    userTransaction.commit();
    em.close();
    entityManagerFactory.close();
    
    }
    
    public Product UpdateProduct(Product old) {
        //TODO: JDA calls to update an exising DB entry
        return old;
    }
    
    public void DeleteProduct(Product delete) {
        //TODO: JDS calls to delete an existing DB entry
    }
}
