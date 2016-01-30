package com.epam.training.canteen.menu.repository.dao;

import org.springframework.data.repository.CrudRepository;

import com.epam.training.canteen.menu.repository.domain.FlavorEntity;

public interface FlavorRepository extends CrudRepository<FlavorEntity, Long> {
	
}
