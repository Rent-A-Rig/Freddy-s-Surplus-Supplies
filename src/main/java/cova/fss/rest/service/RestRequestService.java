package cova.fss.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cova.fss.entities.RequestedInventory;


public class RestRequestService {
	
	private final String ACCESS_TOKEN = "1234123412341234";
	private final String ACCEPT_REQUEST = "http://localhost:8082/Rent-A-Rig_SHOWCASE/acceptRequest";
	
	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<Void> acceptRequest(RequestedInventory request) {

		//set your headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("accessToken", ACCESS_TOKEN);

		//set your entity to send
		HttpEntity<RequestedInventory> entity = new HttpEntity<RequestedInventory>(request, headers);

		// send it!
		ResponseEntity<Void> out = restTemplate.exchange(ACCEPT_REQUEST, HttpMethod.GET, entity, Void.class);
		return out;	
	}

}
