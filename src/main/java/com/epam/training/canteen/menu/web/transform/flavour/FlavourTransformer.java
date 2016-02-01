package com.epam.training.canteen.menu.web.transform.flavour;

import com.epam.training.canteen.menu.domain.Flavour;
import com.epam.training.canteen.menu.web.model.flavour.FlavourView;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FlavourTransformer {

    public Set<FlavourView> transform(Collection<Flavour> flavours) {
        return flavours.stream().map(f -> transformDomain(f)).collect(Collectors.toSet());
    }

    public FlavourView transformDomain(Flavour flavour) {
        return new FlavourView(flavour.getId(), flavour.getName());
    }

}
