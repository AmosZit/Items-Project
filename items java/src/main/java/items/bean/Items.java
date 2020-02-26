package items.bean;

import javax.persistence.*;

@Entity
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ItemsId;
	private String name;
	private float amount;
	private String inventoryCode;

	// constructor

	public Items() {
	}

	public Items(Long itemsId, String name, float amount, String inventoryCode) {
		super();
		ItemsId = itemsId;
		this.name = name;
		this.amount = amount;
		this.inventoryCode = inventoryCode;
	}

	// getters and setters

	public Long getItemsId() {
		return ItemsId;
	}

	public void setItemsId(Long itemsId) {
		ItemsId = itemsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	@Override
	public String toString() {
		return "Items [ItemsId=" + ItemsId + ", name=" + name + ", amount=" + amount + ", inventoryCode=" + inventoryCode
				+ "]";
	}

}
