package com.epam.training.canteen.menu.web.model.food;

import java.util.Set;

public class FoodsModel {

	private Set<FoodView> items;

	public FoodsModel(Set<FoodView> items) {
		this.items = items;
	}

	public Set<FoodView> getItems() {
		return items;
	}
	
}
