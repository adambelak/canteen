package com.epam.training.canteen.menu.web.controller.sidedish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.training.canteen.menu.service.SideDishSearchService;
import com.epam.training.canteen.menu.web.model.sidedish.SideDishesModel;
import com.epam.training.canteen.menu.web.transform.sidedish.SideDishTransformer;

@Controller
public class SideDishesController {

	public static final String REQUEST_MAPPING = "/admin/side_dishes";
	private static final String SIDE_DISHES_MODEL = "sideDishesModel";
	private static final String VIEW_NAME = "admin/side_dishes/list";
	
	@Autowired
	SideDishSearchService searchService;
	@Autowired
	SideDishTransformer transformer;
	
	@ModelAttribute(SIDE_DISHES_MODEL)
	public SideDishesModel createFlavoursModel() {
		return new SideDishesModel(transformer.transform(searchService.findAll()));
	}

    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
    public String show() {
		return VIEW_NAME;
	}
	
}
