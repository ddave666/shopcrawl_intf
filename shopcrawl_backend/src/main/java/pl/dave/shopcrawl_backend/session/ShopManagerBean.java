package pl.dave.shopcrawl_backend.session;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import pl.dave.shopcrawl_intf.ShopManager;
import pl.dave.shopcrawl_intf.model.admin.Shop;
import pl.dave.shopcrawl_intf.model.admin.ShopElement;

@Stateless
@Local
@Transactional(value=TxType.REQUIRED)
public class ShopManagerBean implements ShopManager, Serializable {

	private static final long serialVersionUID = 1L;

	 
    @PersistenceContext(unitName = "mongo-ogm")
    private EntityManager em;

	@Override
	public String getXPathQuery(String shopUrl, ShopElement type) {
		Shop shop = em.find(Shop.class, shopUrl);
		if(shop == null) {
			throw new IllegalAccessError("Shop " + shopUrl + "does not exist in database");
		}
		return shop.getXPathExpression(type);
	}

	@Override
	public void putXPathPQuery(String shopUrl, ShopElement type, String query) {
		Shop shop = em.find(Shop.class, shopUrl);
		if(shop == null) {
			shop = new Shop();
		}
		shop.addXPathExpression(type, query);
		em.persist(shop);		
	}

	@Override
	public List<Shop> getShops() {
    	Query query = em.createNativeQuery("db.admin.Shops.find({})", Shop.class);
 
        @SuppressWarnings("unchecked")
		List<Shop> list = query.getResultList();
        return list;
	}

}
