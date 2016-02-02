package com.epam.training.canteen.menu.web.model.sidedish;

import java.io.Serializable;

import com.epam.training.canteen.menu.web.controller.sidedish.EditSideDishFormController;
import com.epam.training.canteen.menu.web.controller.sidedish.RemoveSideDishFormController;

public class SideDishView implements Serializable {

	private static final long serialVersionUID = -6618220833186163058L;
	
	private Long id;
	private String name;
	private String editUrl;
	private String removeUrl;

	public SideDishView() {
	}

	public SideDishView(Long id, String name) {
		this.id = id;
		this.name = name;
		this.editUrl = EditSideDishFormController.REQUEST_MAPPING.replace("{id}", String.valueOf(id));
		this.removeUrl = RemoveSideDishFormController.REQUEST_MAPPING.replace("{id}", String.valueOf(id));
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
		SideDishView other = (SideDishView) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SideDishView [id=" + id + ", name=" + name + "]";
	}

}
