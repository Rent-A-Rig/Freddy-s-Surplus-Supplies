package cova.fss.service;

import org.springframework.beans.factory.annotation.Autowired;

import cova.fss.dao.InventoryDao;
import cova.fss.entities.Inventory;

public class InvnetoryService {

	@Autowired
	InventoryDao inventoryDao;

	public void updateInventory(String product_id, int request_qty) {

		inventoryDao.updateInventory(product_id, request_qty);

	}

	public Inventory getInventory(String product_id) {

		return inventoryDao.getInventory(product_id);

	}

}
