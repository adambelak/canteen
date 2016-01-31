package com.epam.training.canteen.menu.service.transform;

import com.epam.training.canteen.menu.domain.Flavour;
import com.epam.training.canteen.menu.repository.domain.FlavourEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FlavourEntityTransformer {

    public Set<Flavour> transform(Collection<FlavourEntity> flavourEntity) {
        return flavourEntity.stream().map(f -> transformEntity(f)).collect(Collectors.toSet());
    }

    public Flavour transformEntity(FlavourEntity flavourEntity) {
        return new Flavour(flavourEntity.getId(), flavourEntity.getName());
    }

    public FlavourEntity transformDomain(Flavour flavour) {
        return new FlavourEntity(flavour.getId(), flavour.getName());
    }

}
