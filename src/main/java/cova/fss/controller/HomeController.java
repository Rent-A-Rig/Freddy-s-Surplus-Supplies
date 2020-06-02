package cova.fss.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cova.fss.entities.Inventory;
import cova.fss.entities.RequestedInventory;
import cova.fss.rest.service.RestRequestService;
import cova.fss.entities.User;
import cova.fss.service.InvnetoryService;
import cova.fss.service.LoginService;
import cova.fss.service.RequestService;

@Controller
public class HomeController {

	@Autowired
	RestRequestService restRequestService;
	
	@Autowired
	RequestService requestService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	InvnetoryService inventoryService;

	@RequestMapping(value = { "/adminlogin", "/" })

	public ModelAndView login() {
		return new ModelAndView("AdminLogin");
	}
	
	@RequestMapping(value = { "/logout"})

	public ModelAndView logout() {
		return new ModelAndView("AdminLogin");
	}
	
	@RequestMapping(value = {"/home"})
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = { "/activeRequest" })
	public ModelAndView activeR() {
		List<RequestedInventory> requests = requestService.getActiveRequests();
		ModelAndView mv = new ModelAndView("activeRequestPage", "requests", requests);
		mv.addObject("returnRequest", new RequestedInventory());
		return mv;
	}

	@RequestMapping(value = { "/previousRequest" })
	public ModelAndView previousR() {

		List<RequestedInventory> requests = requestService.getPreviousRequests();
		return new ModelAndView("requestPage", "requests", requests);
		
		
	}
	
	@RequestMapping(value = "/requestInventory")
	public ModelAndView acceptRequest(
			@ModelAttribute("requestedInventory") RequestedInventory requestedInvnetory,
			@RequestParam(required = false, value = "accept") String acceptFlag, 
			@RequestParam(required = false, value = "deny") String denyFlag) {
		
		if (acceptFlag != null && denyFlag == null) {
			requestedInvnetory.setFulfilled("ACCEPTED");
		}
		else if (denyFlag != null && acceptFlag == null) {
			requestedInvnetory.setFulfilled("DENIED");
		}
		
		ResponseEntity<Void> out = restRequestService.sendRequest(requestedInvnetory);
		if (out.getStatusCode() == HttpStatus.ACCEPTED) {
			inventoryService.updateInventory(requestedInvnetory.getProduct_id(), requestedInvnetory.getRequest_qty());
			requestService.updateRequest(requestedInvnetory);
		}
		
		return new ModelAndView("redirect:/activeRequest");
	}
	
	@RequestMapping(value= {"/inventory"})
	public ModelAndView displayInventory() {
		List<Inventory> inventory = requestService.getInventory();
		
		return new ModelAndView("inventory", "requests", inventory);
	}

	@RequestMapping(value = { "/validLogin" })
	public ModelAndView adminLogin(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		User user = new User(username, password);

		boolean isValid = loginService.isValid(user);

		if (isValid) {
			return new ModelAndView("home");
		} else {
			return new ModelAndView("AdminLogin", "errorMessage", "User Credentials were wrong. Please try again.");
		}

	}

}
