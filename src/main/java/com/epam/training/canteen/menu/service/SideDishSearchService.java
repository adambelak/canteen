package com.epam.training.canteen.menu.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.canteen.menu.domain.SideDish;
import com.epam.training.canteen.menu.repository.dao.SideDishRepository;
import com.epam.training.canteen.menu.repository.domain.SideDishEntity;
import com.epam.training.canteen.menu.service.transform.SideDishEntityTransformer;

@Service
public class SideDishSearchService {

    private SideDishRepository repository;
    private SideDishEntityTransformer transformer;

    @Autowired
    public SideDishSearchService(SideDishRepository repository, SideDishEntityTransformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public SideDish find(Long id) {
        return transformer.transformEntity(findSideDishById(id));
    }

    public Set<SideDish> findAll() {
        return transformer.transform(findAllSideDishes());
    }

    private SideDishEntity findSideDishById(Long id) {
        return repository.findOne(id);
    }

    private Collection<SideDishEntity> findAllSideDishes() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toSet());
    }
	
}
