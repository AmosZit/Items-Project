package items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import items.bean.Quantity;
import items.idao.IQuantityDao;

@Repository
public class QuantityController {

	@Autowired
	private IQuantityDao quantityDao;

	// this function creates a new quantity

	public void creatQuantity(Quantity quantity) throws Exception {
		
			quantityDao.save(quantity);
		

	}

	// this function returns the quantity of an item

	public int getQuantityOfItems(long idItems) {
		return quantityDao.findById(idItems).get().getquantityOfItems();

	}

	// this function allows you to deposit a quantity to an item

	public void depositQuantity(long idItems, int amount) {
		Quantity quantity = quantityDao.findById(idItems).get();
		quantity.setquantityOfItems(quantity.getquantityOfItems() + amount);
		quantityDao.save(quantity);
	}

	// this function allows you to withdrawal a quantity to an item

	public void withdrawalQuantity(long idItems, int amount) {
		Quantity quantity = quantityDao.findById(idItems).get();
		if (quantity.getquantityOfItems() - amount < 0) {
		} else {
			quantity.setquantityOfItems(quantity.getquantityOfItems() - amount);
			quantityDao.save(quantity);
		}
	}
}
