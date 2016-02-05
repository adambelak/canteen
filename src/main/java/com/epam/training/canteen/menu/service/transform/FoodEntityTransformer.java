package com.epam.training.canteen.menu.service.transform;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epam.training.canteen.menu.domain.Food;
import com.epam.training.canteen.menu.repository.domain.FoodEntity;

@Component
public class FoodEntityTransformer {

    public Set<Food> transform(Collection<FoodEntity> entity) {
        return entity.stream().map(f -> transformEntity(f)).collect(Collectors.toSet());
    }

    public Food transformEntity(FoodEntity entity) {
        return new Food(entity.getId(), entity.getName(), entity.getDescription(), entity.getPicture());
    }

    public FoodEntity transformDomain(Food domain) {
        return new FoodEntity(domain.getId(), domain.getName(), domain.getDescription(), domain.getPicture());
    }

}
