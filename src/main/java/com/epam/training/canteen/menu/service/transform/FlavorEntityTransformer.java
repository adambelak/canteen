package com.epam.training.canteen.menu.service.transform;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epam.training.canteen.menu.domain.Flavor;
import com.epam.training.canteen.menu.repository.domain.FlavorEntity;

@Component
public class FlavorEntityTransformer {
	
	public Set<Flavor> transform(Collection<FlavorEntity> flavorEntity) {
		return flavorEntity.stream().map(f -> transformEntity(f)).collect(Collectors.toSet());
	}
	
	public Flavor transformEntity(FlavorEntity flavorEntity) {
		return new Flavor(flavorEntity.getId(), flavorEntity.getName());
	}
	
	public FlavorEntity transformDomain(Flavor flavor) {
		return new FlavorEntity(flavor.getName());
	}
	
}
