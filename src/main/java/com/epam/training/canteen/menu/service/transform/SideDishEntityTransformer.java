package com.epam.training.canteen.menu.service.transform;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epam.training.canteen.menu.domain.SideDish;
import com.epam.training.canteen.menu.repository.domain.SideDishEntity;

@Component
public class SideDishEntityTransformer {
	
    public Set<SideDish> transform(Collection<SideDishEntity> entity) {
        return entity.stream().map(f -> transformEntity(f)).collect(Collectors.toSet());
    }

    public SideDish transformEntity(SideDishEntity entity) {
        return new SideDish(entity.getId(), entity.getName());
    }

    public SideDishEntity transformDomain(SideDish sideDish) {
        return new SideDishEntity(sideDish.getId(), sideDish.getName());
    }
    
}
