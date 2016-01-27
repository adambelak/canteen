package com.epam.training.canteen.menu.web.transform;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epam.training.canteen.menu.domain.Flavor;
import com.epam.training.canteen.menu.web.model.FlavorView;

@Component
public class FlavorTransformer {

	public Set<FlavorView> transform(Collection<Flavor> flavors) {
		return flavors.stream().map(f -> transformDomain(f)).collect(Collectors.toSet());
	}
	
	public FlavorView transformDomain(Flavor flavor) {
		return new FlavorView(flavor.getId(), flavor.getName());
	}
	
}
