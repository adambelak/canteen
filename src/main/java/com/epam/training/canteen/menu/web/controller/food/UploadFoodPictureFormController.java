package com.epam.training.canteen.menu.web.controller.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.canteen.menu.service.FoodSearchService;
import com.epam.training.canteen.menu.web.model.food.UploadFoodRequest;

@Controller
public class UploadFoodPictureFormController {

	public static final String REQUEST_MAPPING = "/admin/foods/upload/{id}";
	private static final String VIEW_NAME = "admin/foods/upload";
	private static final String MODEL_ATTRIBUTE = "uploadRequest";

	@Autowired
	FoodSearchService service;

	@ModelAttribute(MODEL_ATTRIBUTE)
	public UploadFoodRequest createFlavourRequest(@ModelAttribute UploadFoodRequest request) {
		return request;
	}
	
	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	public @ResponseBody ModelAndView editForm(@PathVariable("id") long id) {
		ModelAndView modelAndView = new ModelAndView(VIEW_NAME);
		modelAndView.addObject(MODEL_ATTRIBUTE, service.find(id));
		return modelAndView;
	}
	
}
