package com.epam.training.canteen.menu.web.transform;

import org.springframework.stereotype.Component;

import com.epam.training.canteen.menu.domain.Flavor;
import com.epam.training.canteen.menu.web.model.AddFlavorRequest;

@Component
public class AddFlavorRequestTransformer {

	public Flavor transform(AddFlavorRequest request) {
		return new Flavor(request.getName());
	}
	
}
