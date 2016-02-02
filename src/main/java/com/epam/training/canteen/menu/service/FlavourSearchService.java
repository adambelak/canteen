package com.epam.training.canteen.menu.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.canteen.menu.domain.Flavour;
import com.epam.training.canteen.menu.repository.dao.FlavourRepository;
import com.epam.training.canteen.menu.repository.domain.FlavourEntity;
import com.epam.training.canteen.menu.service.transform.FlavourEntityTransformer;

@Service
public class FlavourSearchService {

    private FlavourRepository repository;
    private FlavourEntityTransformer transformer;

    @Autowired
    public FlavourSearchService(FlavourRepository repository, FlavourEntityTransformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public Flavour find(Long id) {
        return transformer.transformEntity(findFlavourById(id));
    }

    public Set<Flavour> findAll() {
        return transformer.transform(findAllFlavours());
    }

    private FlavourEntity findFlavourById(Long id) {
        return repository.findOne(id);
    }

    private Collection<FlavourEntity> findAllFlavours() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toSet());
    }
}
