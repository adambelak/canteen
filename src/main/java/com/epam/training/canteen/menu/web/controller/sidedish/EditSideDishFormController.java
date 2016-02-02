package com.epam.training.canteen.menu.web.controller.sidedish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.canteen.menu.service.SideDishSearchService;
import com.epam.training.canteen.menu.web.model.sidedish.EditSideDishRequest;

@Controller
public class EditSideDishFormController {

	public static final String REQUEST_MAPPING = "/admin/side_dishes/edit/{id}";
	private static final String VIEW_NAME = "admin/side_dishes/edit";
	private static final String SIDE_DISH_REQUEST = "sideDishRequest";

	@Autowired
	SideDishSearchService service;

	@ModelAttribute(SIDE_DISH_REQUEST)
	public EditSideDishRequest createFlavourRequest(@ModelAttribute EditSideDishRequest request) {
		return request;
	}
	
	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	public @ResponseBody ModelAndView editForm(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView(VIEW_NAME);
		modelAndView.addObject(SIDE_DISH_REQUEST, service.find(id));
		return modelAndView;
	}
	
}
