package com.epam.training.canteen.menu.web.controller.flavour;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.training.canteen.exception.InvalidRequestException;
import com.epam.training.canteen.menu.service.FlavourWriteService;
import com.epam.training.canteen.menu.web.model.flavour.EditFlavourRequest;
import com.epam.training.canteen.menu.web.transform.flavour.FlavourRequestTransformer;

@Controller
public class EditFlavourPostController {

	public static final String REQUEST_MAPPING = "/admin/flavours/edit";
	private static final String REDIRECT_URL = "redirect:" + FlavoursController.REQUEST_MAPPING;
	private static final String SUCCESS_MESSAGE = "flavour.edit.success.message";
	private static final String ERROR_MESSAGE = "flavour.answer.error.message";
	private static final String FLAVOUR_REQUEST = "flavourRequest";
	
	@Autowired
	FlavourWriteService writeService;
	@Autowired
	FlavourRequestTransformer transformer;
	@Autowired
	ResourceBundleMessageSource messageSource;
	@Autowired
	LocaleResolver localeResolver;

	@ModelAttribute(FLAVOUR_REQUEST)
	public EditFlavourRequest createFlavourRequest(@ModelAttribute EditFlavourRequest request) {
		return request;
	}

	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.POST)
	public String create(@Valid EditFlavourRequest request, BindingResult bindingResult, HttpServletRequest servletRequest, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			throw new InvalidRequestException(getErrorMessage(servletRequest), bindingResult);
		}
		writeService.save(transformer.transform(request));
		redirectAttributes.addFlashAttribute("successMessage", getSuccessMessage(request, servletRequest));
		return REDIRECT_URL;
	}

	private String getErrorMessage(HttpServletRequest servletRequest) {
		return messageSource.getMessage(ERROR_MESSAGE, new Object[]{}, localeResolver.resolveLocale(servletRequest));
	}

	private String getSuccessMessage(EditFlavourRequest request, HttpServletRequest servletRequest) {
		return messageSource.getMessage(SUCCESS_MESSAGE, new Object[]{request.getName()}, localeResolver.resolveLocale(servletRequest));
	}
	
}
