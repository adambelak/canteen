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
import com.epam.training.canteen.menu.web.model.EditFlavorRequest;
import com.epam.training.canteen.menu.web.transform.FlavorRequestTransformer;

@Controller
public class RemoveFlavorPostController {

	public static final String REQUEST_MAPPING = "/admin/flavors/remove";
	private FlavorWriteService writeService;
	private FlavorRequestTransformer transformer;

	@Autowired
	public RemoveFlavorPostController(FlavorWriteService writeService, FlavorRequestTransformer transformer) {
		this.writeService = writeService;
		this.transformer = transformer;
	}

	@ModelAttribute("flavorRequest")
	public EditFlavorRequest createFlavorRequest(@ModelAttribute EditFlavorRequest request) {
		return request;
	}

	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.POST)
	public String create(@Valid EditFlavorRequest request, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			throw new InvalidRequestException("Invalid flavor.", bindingResult);
		}
		writeService.remove(transformer.transform(request));
		redirectAttributes.addFlashAttribute("successMessage", String.format("Flavour '%s' remove!", request.getName()));
		return "redirect:" + FlavorsController.REQUEST_MAPPING;
	}

}
