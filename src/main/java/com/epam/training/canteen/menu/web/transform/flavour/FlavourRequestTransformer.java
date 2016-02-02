package com.epam.training.canteen.menu.web.transform.flavour;

import org.springframework.stereotype.Component;

import com.epam.training.canteen.menu.domain.Flavour;
import com.epam.training.canteen.menu.web.model.flavour.AddFlavourRequest;
import com.epam.training.canteen.menu.web.model.flavour.EditFlavourRequest;

@Component
public class FlavourRequestTransformer {

    public Flavour transform(AddFlavourRequest request) {
        return new Flavour(request.getName());
    }

    public Flavour transform(EditFlavourRequest request) {
        return new Flavour(request.getId(), request.getName());
    }

}
