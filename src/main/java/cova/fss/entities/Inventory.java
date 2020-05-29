package cova.fss.entities;

public class Inventory {

	private String product_id;
	private String product_name;
	private String category;
	private int stock;

	public Inventory(String product_id, String product_name, String category, int stock) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.category = category;
		this.stock = stock;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
