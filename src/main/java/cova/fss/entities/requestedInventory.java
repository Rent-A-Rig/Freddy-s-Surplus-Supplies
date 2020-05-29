package cova.fss.entities;

import java.sql.Date;

public class requestedInventory {

	private int request_id;
	private String product_id;
	private int request_qty;
	private Date request_date;

	public requestedInventory(int request_id, String product_id, int request_qty, Date request_date,
			boolean fulfilled) {
		super();
		this.request_id = request_id;
		this.product_id = product_id;
		this.request_qty = request_qty;
		this.request_date = request_date;
		this.fulfilled = fulfilled;
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

	public boolean isFulfilled() {
		return fulfilled;
	}

	public void setFulfilled(boolean fulfilled) {
		this.fulfilled = fulfilled;
	}

	private boolean fulfilled;

}
