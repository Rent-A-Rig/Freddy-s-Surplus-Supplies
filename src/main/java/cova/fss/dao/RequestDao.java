package cova.fss.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import cova.fss.entities.RequestedInventory;

public class RequestDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addRequestedInventory(RequestedInventory ri) {
		String sql = "insert into requestedInventory (product_id, request_qty, request_date, fulfilled)"
				+ " values(?,?,?,?)";

		return jdbcTemplate.update(sql, new Object[] {ri.getProduct_id(), ri.getRequest_qty(),
				ri.getRequest_date(), false});

	}

	public int updateRequestedInventory(RequestedInventory ri) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean existingRequest(RequestedInventory ri) {
		return true; // update this to check db for existing requests
	}


}