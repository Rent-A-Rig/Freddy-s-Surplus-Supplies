package cova.fss.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import cova.fss.entities.RequestedInventory;

public class requestDao {

	public static List<RequestedInventory> getRequests(String activeRequests) {
        
        if (activeRequests = "active")
        {
            String sql = "select * from requestedInventory where FULFILLED = 0;";
        }
        else {
            String sql = "select * from requestedInventory where FULFILLED = 1;";
        }
        
        List<RequestedInventory> requests = JdbcTemplate.query(sql, new RequestMapper())
    }

}