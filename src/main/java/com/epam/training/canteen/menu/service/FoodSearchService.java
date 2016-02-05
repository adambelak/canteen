package com.epam.training.canteen.menu.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.canteen.menu.domain.Food;
import com.epam.training.canteen.menu.repository.dao.FoodRepository;
import com.epam.training.canteen.menu.repository.domain.FoodEntity;
import com.epam.training.canteen.menu.service.transform.FoodEntityTransformer;

@Service
public class FoodSearchService {

    private FoodRepository repository;
    private FoodEntityTransformer transformer;

    @Autowired
    public FoodSearchService(FoodRepository repository, FoodEntityTransformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public Food find(Long id) {
        return transformer.transformEntity(findFlavourById(id));
    }

    public Set<Food> findAll() {
        return transformer.transform(findAllFlavours());
    }

    private FoodEntity findFlavourById(Long id) {
        return repository.findOne(id);
    }

    private Collection<FoodEntity> findAllFlavours() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toSet());
    }
}
