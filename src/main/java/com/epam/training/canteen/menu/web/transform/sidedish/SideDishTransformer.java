package com.epam.training.canteen.menu.web.transform.sidedish;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epam.training.canteen.menu.domain.SideDish;
import com.epam.training.canteen.menu.web.model.sidedish.SideDishView;

@Component
public class SideDishTransformer {

    public Set<SideDishView> transform(Collection<SideDish> sideDishes) {
        return sideDishes.stream().map(s -> transformDomain(s)).collect(Collectors.toSet());
    }

    public SideDishView transformDomain(SideDish sideDish) {
        return new SideDishView(sideDish.getId(), sideDish.getName());
    }

}
