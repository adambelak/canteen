package com.epam.training.canteen.menu.web.transform.flavour;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epam.training.canteen.menu.domain.Flavour;
import com.epam.training.canteen.menu.web.model.flavour.FlavourView;

@Component
public class FlavourTransformer {

    public Set<FlavourView> transform(Collection<Flavour> flavours) {
        return flavours.stream().map(f -> transformDomain(f)).collect(Collectors.toSet());
    }

    public FlavourView transformDomain(Flavour flavour) {
        return new FlavourView(flavour.getId(), flavour.getName());
    }

}
