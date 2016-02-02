package com.epam.training.canteen.menu.web.transform.sidedish;

import org.springframework.stereotype.Component;

import com.epam.training.canteen.menu.domain.SideDish;
import com.epam.training.canteen.menu.web.model.sidedish.AddSideDishRequest;
import com.epam.training.canteen.menu.web.model.sidedish.EditSideDishRequest;

@Component
public class SideDishRequestTransformer {

    public SideDish transform(AddSideDishRequest request) {
        return new SideDish(request.getName());
    }

    public SideDish transform(EditSideDishRequest request) {
        return new SideDish(request.getId(), request.getName());
    }
    
}
