package model;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String name;
	private String surname;
	
	private Family family;
	
	private String empty = "";
	
	private List<Job> jobs = new ArrayList<Job>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int Id) {
		this.id = Id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		 this.surname = surname;
	}
	
	@ManyToOne
	public Family getFamily() {
		return family;	
	}
	
	 public void setFamily(Family family) {
		 this.family = family;	
	 }
	 
	@Transient
	public String getNonsenseField() {
		return empty;
	}
	
	public void setNonsenseField(String empty) {
		this.empty = empty;
	}
	
	@OneToMany
	public List<Job> getJobs() {
		return this.jobs;
	}
	
	public void setListaEmpleos(List<Job> jobs) {
		this.jobs = jobs;
	}
}
