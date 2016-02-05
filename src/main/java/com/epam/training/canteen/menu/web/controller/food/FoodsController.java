package com.epam.training.canteen.menu.web.controller.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.training.canteen.menu.service.FoodSearchService;
import com.epam.training.canteen.menu.web.model.food.FoodsModel;
import com.epam.training.canteen.menu.web.transform.food.FoodTransformer;

@Controller
public class FoodsController {

	public static final String REQUEST_MAPPING = "/admin/foods";
	private static final String MODEL_ATTRIBUTE = "foodsModel";
	private static final String VIEW_NAME = "admin/foods/list";
	
	@Autowired
	FoodSearchService searchService;
	@Autowired
	FoodTransformer transformer;
	
	@ModelAttribute(MODEL_ATTRIBUTE)
	public FoodsModel createFlavoursModel() {
		return new FoodsModel(transformer.transform(searchService.findAll()));
	}

    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
    public String show() {
		return VIEW_NAME;
	}
	
}
