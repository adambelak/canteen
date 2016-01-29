package com.epam.training.canteen.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.canteen.menu.domain.Flavor;
import com.epam.training.canteen.menu.repository.dao.FlavorRepository;
import com.epam.training.canteen.menu.service.transform.FlavorEntityTransformer;

@Service
public class FlavorWriteService {

	private FlavorRepository repository;
	private FlavorEntityTransformer transformer;
	
	@Autowired
	public FlavorWriteService(FlavorRepository repository, FlavorEntityTransformer transformer) {
		this.repository = repository;
		this.transformer = transformer;
	}
	
	public void save(Flavor flavor) {
		repository.save(transformer.transformDomain(flavor));
	}

}
