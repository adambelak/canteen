package com.epam.training.canteen.menu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.canteen.menu.domain.Flavor;
import com.epam.training.canteen.menu.service.FlavorSearchService;
import com.epam.training.canteen.menu.web.model.EditFlavorRequest;

@Controller
public class EditFlavorFormController {

	public static final String REQUEST_MAPPING = "/admin/flavors/edit/{id}";
	private FlavorSearchService service;
	
	@Autowired
	public EditFlavorFormController(FlavorSearchService service) {
		super();
		this.service = service;
	}

	@ModelAttribute("flavorRequest")
	public EditFlavorRequest createFlavorRequest(@ModelAttribute EditFlavorRequest request) {
		return request;
	}
	
	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	public @ResponseBody ModelAndView editForm(@PathVariable("id") long id, Model model) {
		Flavor flavor = service.find(id);
		ModelAndView modelAndView = new ModelAndView("admin/flavor/edit");
		modelAndView.addObject("flavorRequest", flavor);
		return modelAndView;
	}
	
}
