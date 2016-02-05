package com.epam.training.canteen.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.canteen.menu.domain.Food;
import com.epam.training.canteen.menu.repository.dao.FoodRepository;
import com.epam.training.canteen.menu.repository.domain.FoodEntity;
import com.epam.training.canteen.menu.service.transform.FoodEntityTransformer;

@Service
public class FoodWriteService {

    private FoodRepository repository;
    private FoodEntityTransformer transformer;

    @Autowired
    public FoodWriteService(FoodRepository repository, FoodEntityTransformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public void save(Food domain) {
        repository.save(transformer.transformDomain(domain));
    }

    public void upload(Food domain) {
    	repository.save(merge(domain));
    	
    }
    
    public void remove(Food domain) {
        repository.delete(transformer.transformDomain(domain));
    }

    private FoodEntity merge(Food domain) {
    	FoodEntity entity = repository.findOne(domain.getId());
    	entity.setPicture(domain.getPicture());
    	return entity;
    }
    
}
