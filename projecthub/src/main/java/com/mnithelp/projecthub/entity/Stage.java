package com.mnithelp.projecthub.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "stage")
public class Stage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "stage_num")
	private Integer stageNum;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "completed_at")
	private LocalDate completedAt;
	
	//@JsonIgnore
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "project_id")
	private Project project;

	public Stage() {
	}

	public Stage(String name, int stageNum, int status) {
		this.name = name;
		this.stageNum = stageNum;
		this.status = status;
		this.completedAt = LocalDate.parse("0000-00-00");
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

	public int getStageNum() {
		return stageNum;
	}

	public void setStageNum(int stageNum) {
		this.stageNum = stageNum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
		
		//updating the date completed acc to the status
		if(this.status == 1) {
			setCompletedAt(LocalDate.now());
		}
		else
			setCompletedAt(LocalDate.parse("0001-01-01"));
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public LocalDate getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(LocalDate completedAt) {
		this.completedAt = completedAt;
	}

	public void setStageNum(Integer stageNum) {
		this.stageNum = stageNum;
	}

	@Override
	public String toString() {
		return "Stage [name=" + name + ", stageNum=" + stageNum + ", status=" + status + "]";
	}
	
	
}
