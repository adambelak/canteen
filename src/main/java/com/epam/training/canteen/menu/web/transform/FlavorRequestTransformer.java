package com.epam.training.canteen.menu.web.transform;

import org.springframework.stereotype.Component;

import com.epam.training.canteen.menu.domain.Flavor;
import com.epam.training.canteen.menu.web.model.AddFlavorRequest;
import com.epam.training.canteen.menu.web.model.EditFlavorRequest;

@Component
public class FlavorRequestTransformer {

	public Flavor transform(AddFlavorRequest request) {
		return new Flavor(request.getName());
	}
	
	public Flavor transform(EditFlavorRequest request) {
		return new Flavor(request.getId(), request.getName());
	}
	
}
