package com.epam.training.canteen.menu.web.controller;

import com.epam.training.canteen.menu.web.model.AddFlavourRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddFlavourFormController {

	public static final String REQUEST_MAPPING = "/admin/flavours/add";

	@ModelAttribute("flavourRequest")
	public AddFlavourRequest createFlavourRequest(@ModelAttribute AddFlavourRequest request) {
		return new AddFlavourRequest();
	}
	
	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	public @ResponseBody ModelAndView addForm() {
		return new ModelAndView("admin/flavour/add");
	}
	
}
