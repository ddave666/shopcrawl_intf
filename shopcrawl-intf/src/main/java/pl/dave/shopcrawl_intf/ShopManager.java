package pl.dave.shopcrawl_intf;

import java.util.List;

import javax.ejb.Remote;

import pl.dave.shopcrawl_intf.model.admin.Shop;
import pl.dave.shopcrawl_intf.model.admin.ShopElement;

@Remote
public interface ShopManager {	
	public String getXPathQuery(String shopUrl, ShopElement type);

	public void putXPathPQuery(String shopUrl, ShopElement type, String query);
	
	public List<Shop> getShops();

}
