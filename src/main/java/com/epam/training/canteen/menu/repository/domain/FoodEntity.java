package com.epam.training.canteen.menu.repository.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "foods")
@SecondaryTable(name = "food_pictures", pkJoinColumns = @PrimaryKeyJoinColumn(name = "food_id", referencedColumnName = "id") )
public class FoodEntity implements Serializable {

	private static final long serialVersionUID = 2218844102348291396L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	@Column(length = 500)
	private String description;

	@Lob
	@Column(table = "food_pictures")
	private byte[] picture;

	public FoodEntity() {
	}

	public FoodEntity(String name) {
		this.name = name;
	}

	public FoodEntity(String name, String description, byte[] picture) {
		this.name = name;
		this.description = description;
		this.picture = picture;
	}

	public FoodEntity(Long id, String name, String description, byte[] picture) {
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
		FoodEntity other = (FoodEntity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FoodEntity [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
