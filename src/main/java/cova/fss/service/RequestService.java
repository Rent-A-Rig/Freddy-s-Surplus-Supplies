package cova.fss.service;

public class RequestService {
	
	public List<RequestedInventory> getPreviousRequests() {
		
		return requestDao.getRequests("previous");
		
	}

}
