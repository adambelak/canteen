package com.epam.training.canteen.menu.web.controller.flavour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.canteen.menu.service.FlavourSearchService;
import com.epam.training.canteen.menu.web.model.flavour.EditFlavourRequest;

@Controller
public class RemoveFlavourFormController {

	public static final String REQUEST_MAPPING = "/admin/flavours/remove/{id}";
	private static final String VIEW_NAME = "admin/flavour/remove";
	private static final String FLAVOUR_REQUEST = "flavourRequest";

	@Autowired
	FlavourSearchService service;

	@ModelAttribute(FLAVOUR_REQUEST)
	public EditFlavourRequest createFlavourRequest(@ModelAttribute EditFlavourRequest request) {
		return request;
	}
	
	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	public @ResponseBody ModelAndView editForm(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView(VIEW_NAME);
		modelAndView.addObject(FLAVOUR_REQUEST, service.find(id));
		return modelAndView;
	}
	
}
