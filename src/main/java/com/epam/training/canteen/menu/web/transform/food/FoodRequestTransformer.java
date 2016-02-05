package com.epam.training.canteen.menu.web.transform.food;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.epam.training.canteen.exception.FileUploadException;
import com.epam.training.canteen.menu.domain.Food;
import com.epam.training.canteen.menu.web.model.food.AddFoodRequest;
import com.epam.training.canteen.menu.web.model.food.EditFoodRequest;
import com.epam.training.canteen.menu.web.model.food.UploadFoodRequest;

@Component
public class FoodRequestTransformer {
	
    public Food transform(AddFoodRequest request) {
        return new Food(request.getName(), request.getDescription());
    }

    public Food transform(EditFoodRequest request) {
        return new Food(request.getId(), request.getName(), request.getDescription());
    }
    
    public Food transform(UploadFoodRequest request) throws FileUploadException {
    	return new Food(request.getId(), getPicture(request.getPicture()));
    }
    
	private byte[] getPicture(MultipartFile multipartFile) throws FileUploadException {
		byte[] result = null;
		if (multipartFile != null) {
			try {
				result = multipartFile.getBytes();
			} catch (IOException e) {
				throw new FileUploadException(e);
			}
		}
		return result;
	}
    
}
