package com.epam.training.canteen.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.canteen.menu.domain.Flavour;
import com.epam.training.canteen.menu.repository.dao.FlavourRepository;
import com.epam.training.canteen.menu.service.transform.FlavourEntityTransformer;

@Service
public class FlavourWriteService {

    private FlavourRepository repository;
    private FlavourEntityTransformer transformer;

    @Autowired
    public FlavourWriteService(FlavourRepository repository, FlavourEntityTransformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public void save(Flavour flavour) {
        repository.save(transformer.transformDomain(flavour));
    }

    public void remove(Flavour flavour) {
        repository.delete(transformer.transformDomain(flavour));
    }

}
