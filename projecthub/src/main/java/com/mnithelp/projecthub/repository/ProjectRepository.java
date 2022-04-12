package com.mnithelp.projecthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mnithelp.projecthub.entity.Project;
import com.mnithelp.projecthub.projection.ProjectProjection;

@CrossOrigin("http://localhost:3000")
@RepositoryRestResource(excerptProjection = ProjectProjection.class)
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	ProjectProjection findById(int id);
}
