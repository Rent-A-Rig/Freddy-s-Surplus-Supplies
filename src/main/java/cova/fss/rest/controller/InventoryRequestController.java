package cova.fss.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryRequestController {
	
	@RequestMapping(value = "/requestInventory", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> requestInventory() {
		
		System.out.println("InventoryRequestController - requestInventory");
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
