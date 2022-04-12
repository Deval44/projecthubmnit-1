package com.mnithelp.projecthub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mnithelp.projecthub.entity.Stage;

@CrossOrigin("http://localhost:3000")
public interface StageRepository extends JpaRepository<Stage, Integer> {

	public List<Stage> findByName(String name);
}
