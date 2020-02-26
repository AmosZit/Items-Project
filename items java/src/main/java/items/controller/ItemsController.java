package items.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import items.bean.Items;
import items.idao.IItemsDao;
import items.idao.IQuantityDao;

@Repository
public class ItemsController {

	@Autowired
	private IItemsDao itemsDao;

	@Autowired
	private IQuantityDao iQuantityDao;

	// this function creates a new items

	public void creatItems(Items items) throws Exception {
		itemsDao.save(items);

	}

	// this function update items

	public void updateItems(Items items) throws Exception {

		if (itemsDao.findById(items.getItemsId()) != null) {
			itemsDao.save(items);

		} else
			throw new Exception();

	}

	// this function delete items

	public void deleteItems(long id) throws Exception {

		itemsDao.deleteById(id);
		iQuantityDao.deleteById(id);

	}

	// this function get quantity by items

	public Items getItemsInfoById(long id) throws Exception {

		Items items = itemsDao.findById(id).get();
		if (items == null) {
			throw new Exception();
		} else
			return items;

	}
	// this function get all items on list

	public List<Items> getAllItems() {

		List<Items> itemsList = new ArrayList<>();
		itemsDao.findAll().forEach(items -> itemsList.add(items));
		return itemsList;
	}

}
