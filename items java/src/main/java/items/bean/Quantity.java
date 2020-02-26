package items.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Quantity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "ITEMS_ID", nullable = false, unique = true)
	private Long ItemsId;

	private int quantityOfItems;

	// constructor

	public Quantity(Long itemsId, int quantityOfItems) {
		super();
		this.ItemsId = itemsId;
		this.quantityOfItems = quantityOfItems;
	}

	public Quantity() {
		super();
	}

	// getters and setters

	public Long getItemsId() {
		return ItemsId;
	}

	public void setItemsId(Long itemsId) {
		this.ItemsId = itemsId;
	}

	public int getquantityOfItems() {
		return quantityOfItems;
	}

	public void setquantityOfItems(int quantityOfItems) {
		this.quantityOfItems = quantityOfItems;
	}

	@Override
	public String toString() {
		return "Quantity [ ItemsId=" + ItemsId + ", quantityOfItems=" + quantityOfItems + "]";
	}

}
