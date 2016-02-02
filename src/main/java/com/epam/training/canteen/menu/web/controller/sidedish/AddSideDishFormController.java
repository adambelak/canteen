package com.epam.training.canteen.menu.web.controller.sidedish;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.canteen.menu.web.model.sidedish.AddSideDishRequest;

@Controller
public class AddSideDishFormController {

	public static final String REQUEST_MAPPING = "/admin/side_dishes/add";
	private static final String SIDE_DISH_REQUEST = "sideDishRequest";
	private static final String VIEW_NAME = "admin/side_dishes/add";

	@ModelAttribute(SIDE_DISH_REQUEST)
	public AddSideDishRequest createFlavourRequest(@ModelAttribute AddSideDishRequest request) {
		return new AddSideDishRequest();
	}
	
	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	public @ResponseBody ModelAndView addForm() {
		return new ModelAndView(VIEW_NAME);
	}
	
}
