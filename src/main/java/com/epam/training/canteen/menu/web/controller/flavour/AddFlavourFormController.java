package com.epam.training.canteen.menu.web.controller.flavour;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.canteen.menu.web.model.flavour.AddFlavourRequest;

@Controller
public class AddFlavourFormController {

	public static final String REQUEST_MAPPING = "/admin/flavours/add";
	private static final String FLAVOUR_REQUEST = "flavourRequest";
	private static final String VIEW_NAME = "admin/flavour/add";

	@ModelAttribute(FLAVOUR_REQUEST)
	public AddFlavourRequest createFlavourRequest(@ModelAttribute AddFlavourRequest request) {
		return new AddFlavourRequest();
	}
	
	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	public @ResponseBody ModelAndView addForm() {
		return new ModelAndView(VIEW_NAME);
	}
	
}
