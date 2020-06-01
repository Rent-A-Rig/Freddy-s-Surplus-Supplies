package cova.fss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cova.fss.entities.RequestedInventory;


public class RequestDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<RequestedInventory> getRequests(String activeRequests) {
        String sql = "";
		
        if (activeRequests.equals("active"))
        {
            sql = "select * from requestedInventory where FULFILLED = 0;";
        }
        else {
            sql = "select * from requestedInventory where FULFILLED = 1;";
        }
        
        List<RequestedInventory> requests = jdbcTemplate.query(sql, new RequestMapper());
        
        return requests;
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

}
