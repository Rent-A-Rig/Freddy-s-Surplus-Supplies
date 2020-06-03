package cova.fss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

}
