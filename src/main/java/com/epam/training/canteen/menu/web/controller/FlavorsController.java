package com.epam.training.canteen.menu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.training.canteen.menu.service.FlavorSearchService;
import com.epam.training.canteen.menu.web.model.FlavorsModel;
import com.epam.training.canteen.menu.web.transform.FlavorTransformer;

@Controller
public class FlavorsController {

	public static final String REQUEST_MAPPING = "/admin/flavors";
	
	private FlavorSearchService searchService;
	private FlavorTransformer transformer;
	
	@Autowired
	public FlavorsController(FlavorSearchService searchService, FlavorTransformer transformer) {
		this.searchService = searchService;
		this.transformer = transformer;
	}
	
	@ModelAttribute("flavorsModel")
	public FlavorsModel createFlavorsModel() {
		return new FlavorsModel(transformer.transform(searchService.findAll()));
	}

    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
    public String show() {
        return "admin/flavor/list";
    }
	
}
