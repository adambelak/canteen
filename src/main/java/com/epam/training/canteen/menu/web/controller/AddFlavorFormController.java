package com.epam.training.canteen.menu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.canteen.menu.web.model.AddFlavorRequest;

@Controller
public class AddFlavorFormController {

	public static final String REQUEST_MAPPING = "/admin/flavors/form";
	
	@ModelAttribute("flavorRequest")
	public AddFlavorRequest createFlavorRequest(@ModelAttribute AddFlavorRequest flavorRequest) {
		return new AddFlavorRequest();
	}
	
	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	public @ResponseBody ModelAndView addForm() {
		return new ModelAndView("admin/flavor/add");
	}
	
}
