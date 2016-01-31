package com.epam.training.canteen.menu.web.controller;

import com.epam.training.canteen.menu.domain.Flavour;
import com.epam.training.canteen.menu.service.FlavourSearchService;
import com.epam.training.canteen.menu.web.model.EditFlavourRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditFlavourFormController {

	public static final String REQUEST_MAPPING = "/admin/flavours/edit/{id}";
	private FlavourSearchService service;
	
	@Autowired
	public EditFlavourFormController(FlavourSearchService service) {
		this.service = service;
	}

	@ModelAttribute("flavourRequest")
	public EditFlavourRequest createFlavourRequest(@ModelAttribute EditFlavourRequest request) {
		return request;
	}
	
	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	public @ResponseBody ModelAndView editForm(@PathVariable("id") long id, Model model) {
		Flavour flavour = service.find(id);
		ModelAndView modelAndView = new ModelAndView("admin/flavour/edit");
		modelAndView.addObject("flavourRequest", flavour);
		return modelAndView;
	}
	
}
