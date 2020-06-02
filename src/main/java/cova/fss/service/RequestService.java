package cova.fss.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cova.fss.dao.RequestDao;
import cova.fss.entities.Inventory;
import cova.fss.entities.RequestedInventory;
public class RequestService {
	
	@Autowired
	RequestDao requestDao;
	
	public boolean addRequestedInventory(RequestedInventory ri) {
		int rows = 0;
		RequestedInventory existingRequest = requestDao.getExistingRequest(ri.getProduct_id());
		if (null != existingRequest) {
			ri.setRequest_qty(ri.getRequest_qty() + existingRequest.getRequest_qty());
			ri.setRequest_id(existingRequest.getRequest_id());
			rows = requestDao.updateRequestedInventory(ri);
		}
		else {
			rows = requestDao.addRequestedInventory(ri);
		}	
	
		if (rows == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
    public List<RequestedInventory> getPreviousRequests() {
        
        return requestDao.getRequests("previous");
        
    }

	public List<RequestedInventory> getActiveRequests() {
		
		return requestDao.getRequests("active");

	}


	public void updateRequest(RequestedInventory requestedInventory) {
		
		requestDao.updateRequestFufilled(requestedInventory);
		
	}

	public RequestedInventory getPendingInventoryRequest(String prodID) {
		
		return requestDao.getExistingRequest(prodID);
	}


	
	public List<Inventory> getInventory() {
		return requestDao.getInventoryRequest("inventory");
	}

}