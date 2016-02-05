package com.epam.training.canteen.menu.domain;

import java.io.Serializable;
import java.util.Arrays;

public class Food implements Serializable {

	private static final long serialVersionUID = 2597708196049899255L;
	
	private Long id;
	private String name;
	private String description;
	private byte[] picture;
	
	public Food() {
	}

	public Food(String name) {
		this.name = name;
	}

	public Food(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Food(String name, String description, byte[] picture) {
		this.name = name;
		this.description = description;
		this.picture = picture;
	}

	public Food(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Food(Long id, byte[] picture) {
		this.id = id;
		this.picture = picture;
	}

	public Food(Long id, String name, String description, byte[] picture) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.picture = picture;
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

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
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
		Food other = (Food) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", picture=" + Arrays.toString(picture) + "]";
	}

}
