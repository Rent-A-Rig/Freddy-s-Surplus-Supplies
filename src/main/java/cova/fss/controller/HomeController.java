package cova.fss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cova.fss.entities.RequestedInventory;
import cova.fss.service.RequestService;

@Controller
public class HomeController {
	
	@Autowired
	RequestService requestService;
	
	@RequestMapping(value = {"/home", "/"})
	public ModelAndView home() {
		return new ModelAndView("home");
	}


	@RequestMapping(value = {"/activeRequest"})
	public ModelAndView activeR() {
		return new ModelAndView("requestPage");
	}
	
	
	@RequestMapping(value = {"/previousRequest"})
	public ModelAndView previousR() {

//		List<RequestedInventory> requests = RequestService.getPreviousRequests();
		
//		return new ModelAndView("requestPage", "requests", requests);
		
		return new ModelAndView("requestPage");
	}
	
	//return active request reutrn newmodelview
	
	
	
	
	//return previousRequest
}
