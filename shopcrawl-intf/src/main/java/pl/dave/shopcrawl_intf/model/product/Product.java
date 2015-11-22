package pl.dave.shopcrawl_intf.model.product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "productuid")
    @GenericGenerator(name = "productuid", strategy = "uuid2")
	private Long id;
	private String productUrl;
	private String price;
	private String description;
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String shopUrl) {
		this.productUrl = shopUrl;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	private String imageUrl;

}
