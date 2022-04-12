package com.mnithelp.projecthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mnithelp.projecthub.entity.Link;

@CrossOrigin("http://localhost:3000")
public interface LinkRepository extends JpaRepository<Link, Integer> {
	//no code for now;
}
