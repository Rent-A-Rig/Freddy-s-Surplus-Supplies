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
	
	public void addRequestedInventory(RequestedInventory ri) {
		requestDao.addRequestedInventory(ri);
	}
}