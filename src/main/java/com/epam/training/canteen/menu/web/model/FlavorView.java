package com.epam.training.canteen.menu.web.model;

import java.io.Serializable;

public class FlavorView implements Serializable {

	private static final long serialVersionUID = -6618220833186163058L;
	
	private Long id;
	private String name;
	private String editUrl;
	
	public FlavorView() {
	}

	public FlavorView(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.editUrl = "/admin/flavor/edit/" + id;
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
		FlavorView other = (FlavorView) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlavorView [id=" + id + ", name=" + name + ", url=" + editUrl + "]";
	}

}
