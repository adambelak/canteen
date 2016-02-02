package com.epam.training.canteen.menu.web.model.sidedish;

import java.util.Set;

public class SideDishesModel {

	private Set<SideDishView> items;

	public SideDishesModel(Set<SideDishView> items) {
		this.items = items;
	}

	public Set<SideDishView> getItems() {
		return items;
	}
	
}
