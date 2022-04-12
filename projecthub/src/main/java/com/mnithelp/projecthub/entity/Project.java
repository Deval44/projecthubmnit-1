package com.mnithelp.projecthub.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name ="created_at")
	private java.time.LocalDate createdAt; 
	
	@Column(name ="status")
	private int status;
	
	@JsonIgnore
	@Column(name = "hash")
	private String hash = "temp";
	
	@Column(name = "image")
	private String image;
	
	@OneToMany(mappedBy = "project", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Job> jobs = new  ArrayList<>();
	
	@OneToMany(mappedBy = "project", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Stage> stages = new  ArrayList<>();
	
	@OneToMany(mappedBy = "project", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Link> links = new  ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = CascadeType.ALL)
	@JoinTable(name = "project_tag",
			joinColumns = { @JoinColumn(name = "project_id")},
			inverseJoinColumns = { @JoinColumn(name = "tag_id")}
			)
	private Set<Tag> tags;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "owner")
	private User owner;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = CascadeType.ALL)
	@JoinTable(name = "project_member",
			joinColumns = { @JoinColumn(name = "project_id")},
			inverseJoinColumns = { @JoinColumn(name = "user_id")}
			)
	private Set<User> members = new HashSet<>();

	public Project() {
	}

	public Project(String name, String description, LocalDate createdAt, int status, String hash, String image) {
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.status = status;
		this.hash = "temp";
		this.image = image;
		tags = new HashSet<>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.time.LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(java.time.LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}	
	
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Stage> getStages() {
		return stages;
	}

	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	public void addTag(Tag tag) {
		tags.add(tag);
	}
	
	public void removeTag(Tag tag) {
		tags.remove(tag);
	}
	
	public void addMember(User user) {
		members.add(user);
	}
	
	public void removeMember(User user) {
		members.remove(user);
	}
	
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", createdAt=" + createdAt
				+ ", status=" + status + ", hash=" + hash + ", image=" + image + "]";
	}
	
	
}
