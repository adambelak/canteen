package com.epam.training.canteen.menu.web.transform.food;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epam.training.canteen.menu.domain.Food;
import com.epam.training.canteen.menu.web.model.food.FoodView;

@Component
public class FoodTransformer {

    public Set<FoodView> transform(Collection<Food> foods) {
        return foods.stream().map(f -> transformDomain(f)).collect(Collectors.toSet());
    }

    public FoodView transformDomain(Food domain) {
        return new FoodView(domain.getId(), domain.getName(), domain.getDescription());
    }

}
