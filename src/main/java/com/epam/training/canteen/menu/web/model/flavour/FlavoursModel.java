package com.epam.training.canteen.menu.web.model.flavour;

import java.util.Set;

public class FlavoursModel {

	private Set<FlavourView> items;

	public FlavoursModel(Set<FlavourView> items) {
		this.items = items;
	}

	public Set<FlavourView> getItems() {
		return items;
	}
	
}
