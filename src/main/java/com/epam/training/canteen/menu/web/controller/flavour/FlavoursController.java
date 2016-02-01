package com.epam.training.canteen.menu.web.controller.flavour;

import com.epam.training.canteen.menu.service.FlavourSearchService;
import com.epam.training.canteen.menu.web.model.flavour.FlavoursModel;
import com.epam.training.canteen.menu.web.transform.FlavourTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FlavoursController {

	public static final String REQUEST_MAPPING = "/admin/flavours";
	private FlavourSearchService searchService;
	private FlavourTransformer transformer;
	
	@Autowired
	public FlavoursController(FlavourSearchService searchService, FlavourTransformer transformer) {
		this.searchService = searchService;
		this.transformer = transformer;
	}

	@ModelAttribute("flavoursModel")
	public FlavoursModel createFlavoursModel() {
		return new FlavoursModel(transformer.transform(searchService.findAll()));
	}

    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
    public String show() {
		return "admin/flavour/list";
	}
	
}
