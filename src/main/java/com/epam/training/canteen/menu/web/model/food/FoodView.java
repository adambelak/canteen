package com.epam.training.canteen.menu.web.model.food;

import java.io.Serializable;

import com.epam.training.canteen.menu.web.controller.flavour.EditFlavourFormController;
import com.epam.training.canteen.menu.web.controller.flavour.RemoveFlavourFormController;
import com.epam.training.canteen.menu.web.controller.food.FoodPictureController;

public class FoodView implements Serializable {

	private static final long serialVersionUID = -6618220833186163058L;
	
	private Long id;
	private String name;
	private String description;
	private String pictureUrl;
	private String uploadUrl;
	private String editUrl;
	private String removeUrl;

	public FoodView() {
	}

	public FoodView(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.uploadUrl = FoodPictureController.REQUEST_MAPPING.replace("{id}", String.valueOf(id));
		this.pictureUrl = FoodPictureController.REQUEST_MAPPING.replace("{id}", String.valueOf(id));
		this.editUrl = EditFlavourFormController.REQUEST_MAPPING.replace("{id}", String.valueOf(id));
		this.removeUrl = RemoveFlavourFormController.REQUEST_MAPPING.replace("{id}", String.valueOf(id));
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUploadUrl() {
		return uploadUrl;
	}

	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getEditUrl() {
		return editUrl;
	}

	public void setEditUrl(String url) {
		this.editUrl = url;
	}
	
	public String getRemoveUrl() {
		return removeUrl;
	}

	public void setRemoveUrl(String removeUrl) {
		this.removeUrl = removeUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodView other = (FoodView) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FoodView [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
