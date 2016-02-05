package com.epam.training.canteen.menu.web.model.food;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class UploadFoodRequest {

	@NotNull
	private Long id;
	
	@NotNull
	private MultipartFile picture;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	
}
