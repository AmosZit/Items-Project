package items.api;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import items.controller.QuantityController;

@RestController
@RequestMapping("/quantity")
public class QuantityApi {

	@Autowired
	private QuantityController QuantityController;

	// http://localhost:8080/quantity/1
	@GetMapping("/{items}")
	public int getQuantityByItems(@PathVariable("items") long ItemsId) throws Exception {
		return QuantityController.getQuantityOfItems(ItemsId);
	}

	// http://localhost:8080/quantity/Withdrawal/1/amount?amount=1
	@GetMapping("/Withdrawal/{items}/amount")
	public void WithdrawalOfQuantity(@PathVariable("items") long itemsId, @RequestParam("amount") int amouts)
			throws Exception {
		QuantityController.withdrawalQuantity(itemsId, amouts);
	}

	// http://localhost:8080/quantity/deposit/1/amount?amount=1
	@GetMapping("/deposit/{items}/amount")
	public void depositOfQuantity(@PathVariable("items") long itemsId, @RequestParam("amount") int amount)
			throws Exception {
		QuantityController.depositQuantity(itemsId, amount);
	}

}
