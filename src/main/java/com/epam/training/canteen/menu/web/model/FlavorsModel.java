package com.epam.training.canteen.menu.web.model;

import java.util.Set;

public class FlavorsModel {

	private Set<FlavorView> items;

	public FlavorsModel(Set<FlavorView> items) {
		this.items = items;
	}

	public Set<FlavorView> getItems() {
		return items;
	}
	
}
