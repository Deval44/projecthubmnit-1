package com.mnithelp.projecthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mnithelp.projecthub.entity.Idea;

@CrossOrigin("http://localhost:3000")
public interface IdeaRepository extends JpaRepository<Idea, Integer> {
	//no code for now;
}
