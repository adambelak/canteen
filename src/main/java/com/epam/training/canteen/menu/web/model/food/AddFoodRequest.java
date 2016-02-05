package com.epam.training.canteen.menu.web.model.food;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddFoodRequest {

	@NotNull
	@Size(min = 3, max = 200)
	private String name;
	@Size(max = 500)
	private String description;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
