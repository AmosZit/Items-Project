package items.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import items.bean.Items;
import items.bean.Quantity;
import items.controller.ItemsController;
import items.controller.QuantityController;


@RestController
@RequestMapping("/items")
public class ItemsApi {

	@Autowired
	private ItemsController itemsController;

	@Autowired
	private QuantityController quantityController;

	// http://localhost:8080/items
	@PostMapping
	public void addItems(@RequestBody Items items) throws Exception {
		itemsController.creatItems(items);
		Quantity quantity = new Quantity(items.getItemsId(), 0);
		quantityController.creatQuantity(quantity);

	}

	// http://localhost:8080/items
	@GetMapping("/{Items_id}")
	public Items getItemsById(@PathVariable("Items_id") long id) throws Exception {
		return itemsController.getItemsInfoById(id);
	}

	// http://localhost:8080/items
	@GetMapping
	public List<Items> getAllItems() throws Exception {
		return itemsController.getAllItems();
	}

	// http://localhost:8080/items/1
	@DeleteMapping("/{Items_id}")
	public void deleteItems(@PathVariable("Items_id") long id) throws Exception {
		itemsController.deleteItems(id);
	}

	// http://localhost:8080/items
	@PutMapping
	public void updateItems(@RequestBody Items items) throws Exception {
		itemsController.updateItems(items);
	}

}
