package com.mnithelp.projecthub.entity;

import java.util.List;
import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import com.mnithelp.projecthub.entity.Link;
import com.mnithelp.projecthub.entity.Project;
import com.mnithelp.projecthub.entity.Stage;
import com.mnithelp.projecthub.entity.Tag;
import com.mnithelp.projecthub.entity.User;

@Projection(name = "projectProjection", types = Project.class)
public interface ProjectProjection {

	int getId();
	
	String getName();
	String getDescription();
	java.time.LocalDate getCreatedAt();
	int getStatus();
	String getImage();
	List<Link> getLinks();
	List<Stage> getStages();
	List<Tag> getTags();
	Set<User> getMembers();
	User getOwner();
}
