package com.epam.training.canteen.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.training.canteen.menu.domain.SideDish;
import com.epam.training.canteen.menu.repository.dao.SideDishRepository;
import com.epam.training.canteen.menu.service.transform.SideDishEntityTransformer;

@Service
public class SideDishWriterService {

    private SideDishRepository repository;
    private SideDishEntityTransformer transformer;

    @Autowired
    public SideDishWriterService(SideDishRepository repository, SideDishEntityTransformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public void save(SideDish sideDish) {
        repository.save(transformer.transformDomain(sideDish));
    }

    public void remove(SideDish sideDish) {
        repository.delete(transformer.transformDomain(sideDish));
    }
	
}
