package com.epam.training.canteen.menu.repository.dao;

import org.springframework.data.repository.CrudRepository;

import com.epam.training.canteen.menu.repository.domain.FlavorEntity;
import com.epam.training.canteen.menu.repository.domain.FoodEntity;

public interface FlavorRepository extends CrudRepository<FlavorEntity, Long> {

	FoodEntity findByName(String name);
	
}
