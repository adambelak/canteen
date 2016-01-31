package com.epam.training.canteen.menu.domain;

import java.io.Serializable;

public class Flavour implements Serializable {
	
	private static final long serialVersionUID = 3722785226457894437L;
	
	private Long id;
	private String name;

	public Flavour() {
	}

	public Flavour(String name) {
		this.name = name;
	}

	public Flavour(Long id, String name) {
		this.id = id;
		this.name = name;
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
		Flavour other = (Flavour) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flavour [id=" + id + ", name=" + name + "]";
	}
	
}
