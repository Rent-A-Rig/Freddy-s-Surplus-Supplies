
package cova.fss.entities;

import java.sql.Date;

public class RequestedInventory {

	private int request_id;
	private String product_id;
	private String product_name;
	private int request_qty;
	private Date request_date;
	private String fulfilled;
	

	public RequestedInventory() {};
	

	@Override
	public String toString() {
		return "RequestedInventory [request_id=" + request_id + ", product_id=" + product_id + ", product_name="
				+ product_name + ", request_qty=" + request_qty + ", request_date=" + request_date + ", fulfilled="
				+ fulfilled + "]";
	}


	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public int getRequest_qty() {
		return request_qty;
	}

	public void setRequest_qty(int request_qty) {
		this.request_qty = request_qty;
	}

	public Date getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

	public String getFulfilled() {
		return fulfilled;
	}

	public void setFulfilled(String fulfilled) {
		this.fulfilled = fulfilled;
	}


}
