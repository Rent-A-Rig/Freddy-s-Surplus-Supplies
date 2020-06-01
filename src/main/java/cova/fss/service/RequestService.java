package cova.fss.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cova.fss.dao.RequestDao;
import cova.fss.entities.RequestedInventory;
public class RequestService {
	
	@Autowired
	RequestDao requestDao;
    
//    public List<RequestedInventory> getPreviousRequests() {
//        
//        return requestDao.getRequests("previous");
//        
//    }
	
	public boolean addRequestedInventory(RequestedInventory ri) {
		int rows = 0;
		boolean exists = requestDao.existingRequest(ri.getProduct_id());
		if (!exists) {
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
}