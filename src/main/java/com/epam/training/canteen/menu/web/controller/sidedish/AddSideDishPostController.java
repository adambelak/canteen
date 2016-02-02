package com.epam.training.canteen.menu.web.controller.sidedish;

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
import com.epam.training.canteen.menu.service.SideDishWriterService;
import com.epam.training.canteen.menu.web.model.sidedish.AddSideDishRequest;
import com.epam.training.canteen.menu.web.transform.sidedish.SideDishRequestTransformer;

@Controller
public class AddSideDishPostController {

	public static final String REQUEST_MAPPING = "/admin/side_dishes/add";
	private static final String REDIRECT_URL = "redirect:" + SideDishesController.REQUEST_MAPPING;
	private static final String SUCCESS_MESSAGE = "sidedish.add.success.message";
	private static final String ERROR_MESSAGE = "sidedish.answer.error.message";
	private static final String SIDE_DISH_REQUEST = "sideDishRequest";
	
	@Autowired
	SideDishWriterService writeService;
	@Autowired
	SideDishRequestTransformer transformer;
	@Autowired
	ResourceBundleMessageSource messageSource;
	@Autowired
	LocaleResolver localeResolver;

	@ModelAttribute(SIDE_DISH_REQUEST)
	public AddSideDishRequest createFlavourRequest(@ModelAttribute AddSideDishRequest request) {
		return new AddSideDishRequest();
	}

	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.POST)
	public String create(@Valid AddSideDishRequest request, BindingResult bindingResult, HttpServletRequest servletRequest, RedirectAttributes redirectAttributes) {
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

	private String getSuccessMessage(AddSideDishRequest request, HttpServletRequest servletRequest) {
		return messageSource.getMessage(SUCCESS_MESSAGE, new Object[]{request.getName()}, localeResolver.resolveLocale(servletRequest));
	}

}
