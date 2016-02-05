package com.epam.training.canteen.menu.repository.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.training.canteen.menu.repository.domain.FoodEntity;

public interface FoodRepository extends CrudRepository<FoodEntity, Long> {
	
	List<FoodEntity> findByNameIgnoreCaseLike(String name);
	
}
