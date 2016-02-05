package com.epam.training.canteen.menu.web.controller.food;

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

import com.epam.training.canteen.exception.FileUploadException;
import com.epam.training.canteen.exception.InvalidRequestException;
import com.epam.training.canteen.menu.service.FoodWriteService;
import com.epam.training.canteen.menu.web.controller.flavour.FlavoursController;
import com.epam.training.canteen.menu.web.model.food.UploadFoodRequest;
import com.epam.training.canteen.menu.web.transform.food.FoodRequestTransformer;

@Controller
public class UploadFoodPicturePostController {

	public static final String REQUEST_MAPPING = "/admin/foods/upload";
	private static final String REDIRECT_URL = "redirect:" + FlavoursController.REQUEST_MAPPING;
	private static final String SUCCESS_MESSAGE = "food.upload.success.message";
	private static final String ERROR_MESSAGE = "food.upload.error.message";
	private static final String MODEL_ATTRIBUTE = "uploadRequest";

	@Autowired
	FoodWriteService writeService;
	@Autowired
	FoodRequestTransformer transformer;
	@Autowired
	ResourceBundleMessageSource messageSource;
	@Autowired
	LocaleResolver localeResolver;

	@ModelAttribute(MODEL_ATTRIBUTE)
	public UploadFoodRequest createUploadRequest(@ModelAttribute UploadFoodRequest request) {
		return request;
	}
	
	
	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.POST)
	public String upload(@Valid UploadFoodRequest request, BindingResult bindingResult, HttpServletRequest servletRequest, RedirectAttributes redirectAttributes) throws FileUploadException {
		if (bindingResult.hasErrors()) {
			throw new InvalidRequestException(getErrorMessage(servletRequest), bindingResult);
		}
		writeService.upload(transformer.transform(request));
		redirectAttributes.addFlashAttribute("successMessage", getSuccessMessage(servletRequest));
		return REDIRECT_URL;
	}

	private String getErrorMessage(HttpServletRequest servletRequest) {
		return messageSource.getMessage(ERROR_MESSAGE, new Object[]{}, localeResolver.resolveLocale(servletRequest));
	}

	private String getSuccessMessage(HttpServletRequest servletRequest) {
		return messageSource.getMessage(SUCCESS_MESSAGE, new Object[]{}, localeResolver.resolveLocale(servletRequest));
	}
	
}
