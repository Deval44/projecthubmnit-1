package com.mnithelp.projecthub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mnithelp.projecthub.entity.Job;

@CrossOrigin("http://localhost:3000")
public interface JobRepository extends JpaRepository<Job, Integer> {

}
