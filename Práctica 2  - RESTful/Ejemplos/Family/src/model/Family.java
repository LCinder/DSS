package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Family {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	
	private int id;
	private String description;
	
	@OneToMany(mappedBy = "family")
	private final List<Person> members = new ArrayList<Person>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String descripcion) {
		this.description = descripcion;
	}
	
	public List<Person> getMiembros() {
		return members;
	}

}
