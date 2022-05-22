package com.mnithelp.projecthub.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mnithelp.projecthub.security.Provider;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Provider provider;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Idea> ideas;
	
	@JsonIgnore
	@OneToMany(mappedBy = "owner", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	List<Project> projectsOwned = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL,
			mappedBy = "members")
	private Set<Project> projects = new HashSet<>();

	public User() {
	}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}
	
	public void addIdea(Idea idea) {
		if(ideas == null)
			ideas = new ArrayList<>();
		
		ideas.add(idea);
	}
	
	
	public List<Project> getProjectsOwned() {
		return projectsOwned;
	}

	public void setProjectsOwned(List<Project> projectsOwned) {
		this.projectsOwned = projectsOwned;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}



	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}
	
	
}
