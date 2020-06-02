package cova.fss.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class InventoryDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void updateInventory(String product_id, int quantity) {
		
		String sql = "UPDATE inventory SET STOCK = " + quantity + " WHERE PRODUCT_ID = '" + product_id + "'";
		
		int rows = jdbcTemplate.update(sql);
		
	}

}
