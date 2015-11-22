package pl.dave.shopcrawl_intf.model.admin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyEnumerated;

@Entity
public class Shop implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String shopUrl;
	
	@ElementCollection
	@MapKeyEnumerated
	private Map<ShopElement, String> xPaths;
	public String getShopUrl() {
		return shopUrl;
	}
	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}
	
	public Map<ShopElement, String> getxPaths() {
		return xPaths;
	}
	public void setxPaths(Map<ShopElement, String> xPaths) {
		this.xPaths = xPaths;
	}
	
	public String getXPathExpression(ShopElement type) {
		if(xPaths == null) {
			return null;
		}
		return xPaths.get(type);
	}
	
	public void addXPathExpression(ShopElement type, String expression) {
		if(xPaths == null) {
			xPaths = new HashMap<ShopElement, String>();
		}
		xPaths.put(type, expression);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shopUrl == null) ? 0 : shopUrl.hashCode());
		result = prime * result + ((xPaths == null) ? 0 : xPaths.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		if (shopUrl == null) {
			if (other.shopUrl != null)
				return false;
		} else if (!shopUrl.equals(other.shopUrl))
			return false;
		if (xPaths == null) {
			if (other.xPaths != null)
				return false;
		} else if (!xPaths.equals(other.xPaths))
			return false;
		return true;
	}
}
