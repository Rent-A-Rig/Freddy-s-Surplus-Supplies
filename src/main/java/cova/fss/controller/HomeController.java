package cova.fss.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;


	@RequestMapping(value = {"/activeRequest"})
	public ModelAndView activeR() {
		return new ModelAndView("requestPage");
	}
	
	
	@RequestMapping(value = {"/previousRequest"})
	public ModelAndView previousR() {

		List<RequestedInventory> requests = requestService.getPreviousRequests();
		
		return new ModelAndView("requestPage", "requests", requests);
	}
	
	//return active request reutrn newmodelview
	
	
	
	
	//return previousRequest
}
