package com.epam.training.canteen.menu.web.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddFlavourRequest {

	@NotNull
	@Size(min = 3, max = 100)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
