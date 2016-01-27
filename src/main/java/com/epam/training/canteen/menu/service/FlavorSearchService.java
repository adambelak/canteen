package com.epam.training.canteen.menu.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.canteen.menu.domain.Flavor;
import com.epam.training.canteen.menu.repository.dao.FlavorRepository;
import com.epam.training.canteen.menu.repository.domain.FlavorEntity;
import com.epam.training.canteen.menu.service.transform.FlavorEntityTransformer;

@Service
public class FlavorSearchService {

	private FlavorRepository repository;
	private FlavorEntityTransformer transformer;
	
	@Autowired
	public FlavorSearchService(FlavorRepository repository, FlavorEntityTransformer transformer) {
		this.repository = repository;
		this.transformer = transformer;
	}
	
	public Flavor find(Long id) {
		return transformer.transformEntity(findFlavorById(id));
	}
	
	public Set<Flavor> findAll() {
		return transformer.transform(findAllFlavors());
	}

	private FlavorEntity findFlavorById(Long id) {
		return repository.findOne(id);
	}
	
	private Collection<FlavorEntity> findAllFlavors() {
		return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toSet());
	}
}
