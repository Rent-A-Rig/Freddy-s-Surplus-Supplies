package cova.fss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cova.fss.entities.RequestedInventory;
import cova.fss.entities.User;
import cova.fss.service.LoginService;
import cova.fss.service.RequestService;

@Controller
public class HomeController {

	@Autowired
	RequestService requestService;

	@Autowired
	LoginService loginService;

	@RequestMapping(value = { "/adminlogin", "/" })
	public ModelAndView login() {
		return new ModelAndView("AdminLogin");
	}

	@RequestMapping(value = { "/home" })
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = { "/activeRequest" })
	public ModelAndView activeR() {
		List<RequestedInventory> requests = requestService.getActiveRequests();

		return new ModelAndView("requestPage", "requests", requests);
	}

	@RequestMapping(value = { "/previousRequest" })
	public ModelAndView previousR() {

		List<RequestedInventory> requests = requestService.getPreviousRequests();

		return new ModelAndView("requestPage", "requests", requests);

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
