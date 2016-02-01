package com.epam.training.canteen.menu.web.controller.flavour;

import com.epam.training.canteen.exception.InvalidRequestException;
import com.epam.training.canteen.menu.service.FlavourWriteService;
import com.epam.training.canteen.menu.web.model.flavour.EditFlavourRequest;
import com.epam.training.canteen.menu.web.transform.FlavourRequestTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EditFlavourPostController {

	public static final String REQUEST_MAPPING = "/admin/flavours/edit";
	private FlavourWriteService writeService;
	private FlavourRequestTransformer transformer;

	@Autowired
	public EditFlavourPostController(FlavourWriteService writeService, FlavourRequestTransformer transformer) {
		this.writeService = writeService;
		this.transformer = transformer;
	}

	@ModelAttribute("flavourRequest")
	public EditFlavourRequest createFlavourRequest(@ModelAttribute EditFlavourRequest request) {
		return request;
	}

	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.POST)
	public String create(@Valid EditFlavourRequest request, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			throw new InvalidRequestException("Invalid flavour.", bindingResult);
		}
		writeService.save(transformer.transform(request));
		redirectAttributes.addFlashAttribute("successMessage", String.format("Flavour '%s' updated!", request.getName()));
		return "redirect:" + FlavoursController.REQUEST_MAPPING;
	}

}
