package cova.fss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cova.fss.entities.Inventory;

public class InventoryDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean updateInventory(String product_id, int quantity) {
		String sql = "SELECT (stock) FROM inventory where product_ID = '" + product_id + "'";
		int stock = (int) jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("STOCK");
			}

		});
		
		if (quantity <= stock) {
			sql = "UPDATE inventory SET STOCK = " + (stock - quantity) + " WHERE PRODUCT_ID = '" + product_id + "'";
			int rows = jdbcTemplate.update(sql);
			return true;
		}
		else {
			return false;
		}
		
	}

	public Inventory getInventory(String product_id) {
		
		String sql = "SELECT * FROM inventory WHERE product_id = '" + product_id + "'";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Inventory>() {

			public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Inventory inv = new Inventory();
				
				inv.setProduct_id(rs.getString("PRODUCT_ID"));
				inv.setProduct_name(rs.getString("PRODUCT_NAME"));
				inv.setCategory(rs.getString("CATEGORY"));
				inv.setStock(rs.getInt("STOCK"));
				
				return inv;
			}
			
		});
	}

}
