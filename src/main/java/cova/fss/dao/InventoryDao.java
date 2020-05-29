package cova.fss.dao;

public class InventoryDao {
	
	public List<RequestedInventory> getRequests(String active) {
		
		if (active = "active")
		{
			String sql = "";
		}
		else {
			String sql = "";
		}
		
		List<RequesstedINventory> requests = jdbcTemplate.query(sql, new RequestMapper())
	}
	
	
}
