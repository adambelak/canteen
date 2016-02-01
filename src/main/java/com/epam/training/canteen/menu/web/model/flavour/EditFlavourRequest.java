package com.epam.training.canteen.menu.web.model.flavour;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EditFlavourRequest {

	@NotNull
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 100)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
