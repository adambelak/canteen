package com.epam.training.canteen.menu.web.controller.flavour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.training.canteen.menu.service.FlavourSearchService;
import com.epam.training.canteen.menu.web.model.flavour.FlavoursModel;
import com.epam.training.canteen.menu.web.transform.flavour.FlavourTransformer;

@Controller
public class FlavoursController {

	public static final String REQUEST_MAPPING = "/admin/flavours";
	private static final String FLAVOURS_MODEL = "flavoursModel";
	private static final String VIEW_NAME = "admin/flavour/list";
	
	@Autowired
	FlavourSearchService searchService;
	@Autowired
	FlavourTransformer transformer;
	
	@ModelAttribute(FLAVOURS_MODEL)
	public FlavoursModel createFlavoursModel() {
		return new FlavoursModel(transformer.transform(searchService.findAll()));
	}

    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
    public String show() {
		return VIEW_NAME;
	}
	
}
