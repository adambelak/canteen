package com.epam.training.canteen.menu.web.controller.food;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.training.canteen.exception.FileUploadException;
import com.epam.training.canteen.menu.service.FoodSearchService;
import com.epam.training.canteen.menu.web.model.food.ShowFoodRequest;

@Controller
public class FoodPictureController {

	private static final String FOOD_PICTURE_NOT_FOUND_IMAGE = "/WEB-INF/assets/img/not-found-136x136.png";
	public static final String REQUEST_MAPPING = "/pictures/foods_{id}.jpg";

	@Autowired
	FoodSearchService service;
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET)
	@ResponseBody
	public AbstractResource downloadCover(ShowFoodRequest showRequest) throws FileUploadException {
		byte[] picture = service.find(showRequest.getId()).getPicture();
		if (picture == null || picture.length == 0) {
			picture = readPlaceholderImage();
		}
		return new ByteArrayResource(picture);
	}
	
	private byte[] readPlaceholderImage() throws FileUploadException {
		Path path = new File(servletContext.getRealPath(FOOD_PICTURE_NOT_FOUND_IMAGE)).toPath();
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			throw new FileUploadException(e);
		}
	}

}
