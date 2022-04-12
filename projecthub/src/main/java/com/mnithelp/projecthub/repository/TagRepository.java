package com.mnithelp.projecthub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mnithelp.projecthub.entity.Tag;

@CrossOrigin("http://localhost:3000")
public interface TagRepository extends JpaRepository<Tag, Integer> {
	
	public List<Tag> findByName(String name);
}
