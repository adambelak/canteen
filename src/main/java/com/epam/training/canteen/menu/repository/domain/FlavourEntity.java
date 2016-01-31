package com.epam.training.canteen.menu.repository.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "flavours")
public class FlavourEntity implements Serializable {

	private static final long serialVersionUID = 4836015177372501468L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;

	public FlavourEntity() {
	}

	public FlavourEntity(String name) {
		this.name = name;
	}

	public FlavourEntity(Long id, String name) {
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
		FlavourEntity other = (FlavourEntity) obj;
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
