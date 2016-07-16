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
 * 
 * changelog: 7/13/2016
 *      Created JPA class to handle database interaction as the Project 4 requested.
 */


public class ProductDB {
    
    private static final EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("PRODUCT");
    
    public static EntityManagerFactory getEMFactory() {
        return entityManagerFactory;
    }

    public void AddProduct(Long ID, String code, String desc, Double price) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction userTransaction = em.getTransaction();

        try {
             Product product = new Product();
             
            userTransaction.begin();

            product.setId(ID);
            product.setCode(code);
            product.setDescription(desc);
            product.setPrice(price);

            em.persist(product);
            
            userTransaction.commit();
        } catch (Exception ex) {
            userTransaction.rollback();
        } finally {
            em.close();
        }

    }
    
    public void UpdateProduct(Product oldProduct, String desc) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction userTransaction = em.getTransaction();
        
        try {
            Product product = em.find(Product.class, oldProduct);

            userTransaction.begin();

            product.setDescription(desc);
            
            em.merge(product);
            
            userTransaction.commit();
        } catch (Exception ex) {
            userTransaction.rollback();
        } finally {
            em.close();
        }
    }
    
    public void UpdateProduct(Product oldProduct, double price) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction userTransaction = em.getTransaction();

        try {
            Product product = em.find(Product.class, oldProduct);

            userTransaction.begin();
            product.setPrice(price);
            em.merge(product);
            userTransaction.commit();

        } catch (Exception ex) {
            userTransaction.rollback();
        } finally {
            em.close();
        }
    }
    
    public void UpdateProduct(Product oldProduct, String desc, double price) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction userTransaction = em.getTransaction();
 
        try {
            Product product = em.find(Product.class, oldProduct);

            userTransaction.begin();

            product.setDescription(desc);
            product.setPrice(price);
            em.merge(product);
            userTransaction.commit();
        } catch (Exception ex) {
            userTransaction.rollback();
        } finally {
            em.close();
        }
    }
    
    public void DeleteProduct(Product delete) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction userTransaction = em.getTransaction();
        
        try {
            Product product = em.find(Product.class, delete);

            userTransaction.begin();

            em.remove(product);
            
            userTransaction.commit();
        } catch (Exception ex) {
            userTransaction.rollback();
        } finally {
            em.close();
        }
    }
}
