package com.epam.training.canteen.menu.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.training.canteen.exception.InvalidRequestException;
import com.epam.training.canteen.menu.service.FlavorWriteService;
import com.epam.training.canteen.menu.web.model.AddFlavorRequest;
import com.epam.training.canteen.menu.web.transform.AddFlavorRequestTransformer;

@Controller
public class AddFlavorPostController {

	public static final String REQUEST_MAPPING = "/admin/flavors/add";
	private FlavorWriteService writeService;
	private AddFlavorRequestTransformer transformer;

	@Autowired
	public AddFlavorPostController(FlavorWriteService writeService, AddFlavorRequestTransformer transformer) {
		this.writeService = writeService;
		this.transformer = transformer;
	}

	@ModelAttribute("flavorRequest")
	public AddFlavorRequest createFlavorRequest(@ModelAttribute AddFlavorRequest addFlavorRequest) {
		return new AddFlavorRequest();
	}

	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.POST)
	public String create(@Valid AddFlavorRequest request, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			throw new InvalidRequestException("Invalid flavor.", bindingResult);
		}
		writeService.save(transformer.transform(request));
		redirectAttributes.addFlashAttribute("successMessage", String.format("Flavour '%s' saved!", request.getName()));
		return "redirect:" + FlavorsController.REQUEST_MAPPING;
	}

}
