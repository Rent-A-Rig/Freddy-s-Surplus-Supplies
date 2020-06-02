package cova.fss.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cova.fss.entities.RequestedInventory;
import cova.fss.service.RequestService;

@RestController
public class InventoryRequestController {
	
	@Autowired
	RequestService requestService;
	
	@RequestMapping(value = "/requestInventory", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> requestInventory(@RequestBody RequestedInventory invRequest) {
		
		boolean success = requestService.addRequestedInventory(invRequest);
		if (success) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
	}

}