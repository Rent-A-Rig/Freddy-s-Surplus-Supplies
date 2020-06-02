package cova.fss.dao;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;

import cova.fss.entities.Inventory;
import cova.fss.entities.RequestedInventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class RequestDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addRequestedInventory(RequestedInventory ri) {
		String sql = "insert into requestedInventory (product_name, product_id, request_qty, request_date, fulfilled)"
				+ " values(?,?,?,?,?)";

		return jdbcTemplate.update(sql, new Object[] {ri.getProduct_name(), ri.getProduct_id(), ri.getRequest_qty(),
				ri.getRequest_date(), false});

	}

	public int updateRequestedInventory(RequestedInventory ri) {
		String sql = "update requestedInventory SET request_qty = " + ri.getRequest_qty() + " WHERE request_id = " + ri.getRequest_id();
		return jdbcTemplate.update(sql);
	}
	
	public RequestedInventory getExistingRequest(String prodID) {
		
		String sql = "select * from requestedInventory where product_id = '" + prodID + "' and fulfilled = " + false;
		List<RequestedInventory> riList = jdbcTemplate.query(sql, new RequestMapper());
		if (riList.size() == 0) {
			return null;
		}
		else {
			return riList.get(0);
		}
		
	}


	public List<RequestedInventory> getRequests(String activeRequests) {
        String sql = "";
		
        if (activeRequests.equals("active"))
        {
            sql = "select * from requestedInventory where FULFILLED = 0;";
        }
        else
        {
            sql = "select * from requestedInventory where FULFILLED = 1;";
        } 

        List<RequestedInventory> requests = jdbcTemplate.query(sql, new RequestMapper());
        
        return requests;
    }
	
	public List<Inventory> getInventoryRequest(String inventoryRequests) {
		String sql = "";
		if (inventoryRequests.equals("inventory"))
		{
			sql = "select * from inventory";
		}
		
		List<Inventory> inventory = jdbcTemplate.query(sql, new InventoryMapper());
		return inventory;
	}
	
	
	class RequestMapper implements RowMapper<RequestedInventory> {

		public RequestedInventory mapRow(ResultSet rs, int rowNum) throws SQLException {

			RequestedInventory ri = new RequestedInventory();

			ri.setProduct_id(rs.getString("product_id"));
			ri.setProduct_name(rs.getString("product_name"));
			ri.setRequest_date(rs.getDate("request_date"));
			ri.setRequest_qty(rs.getInt("request_qty"));
			ri.setFulfilled(rs.getBoolean("fulfilled"));
			ri.setRequest_id(rs.getInt("request_id"));

			return ri;
		}

	}
	
	class InventoryMapper implements RowMapper<Inventory> {

		
		public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
			Inventory inv = new Inventory();
			
			inv.setProduct_id(rs.getString("product_id"));
			inv.setProduct_name(rs.getString("product_name"));
			inv.setCategory(rs.getString("category"));
			inv.setStock(rs.getInt("stock"));
			
			return inv;
		}
		
	}

}
