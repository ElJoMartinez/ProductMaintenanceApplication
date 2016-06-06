
package music.business;
/**
 *
 * @author Elliot Martinez
 */

import java.io.Serializable;
import java.text.NumberFormat;

public class Product implements Serializable {
    private Long productId;
    private String code;
    private String description;
    private double price;
    
    public Long getId() {
        return productId;
    }
    
    public void setId(Long productId) {
        this.productId = productId;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getArtistName() {
        String artistName = description.substring(0,description.indexOf(" - "));
        return artistName;
    }
    
    public String getAlbumName() {
        String albumName = 
                description.substring(0, description.indexOf(" - ")+3);
        return albumName;
    }
    
    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
    
    public String getProductType() {
        return "Audio CD";
    }
}
