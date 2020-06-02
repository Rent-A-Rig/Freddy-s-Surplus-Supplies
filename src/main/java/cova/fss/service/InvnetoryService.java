package cova.fss.service;

import org.springframework.beans.factory.annotation.Autowired;

import cova.fss.dao.InventoryDao;

public class InvnetoryService {
	
	@Autowired
	InventoryDao inventoryDao;

	public void updateInventory(String product_id, int request_qty) {
		
		inventoryDao.updateInventory(product_id, request_qty);
		
	}

}
