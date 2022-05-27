package com.mnithelp.projecthub.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mnithelp.projecthub.entity.Project;
import com.mnithelp.projecthub.entity.Tag;
import com.mnithelp.projecthub.entity.User;
import com.mnithelp.projecthub.repository.ProjectRepository;
import com.mnithelp.projecthub.repository.TagRepository;
import com.mnithelp.projecthub.repository.UserRepository;
import com.mnithelp.projecthub.security.CustomOAuth2User;

//@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("custom/api/projects")
public class ProjectRestController {
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	TagRepository tagRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@CrossOrigin("http://localhost:3000")
	@PutMapping("/{projectId}/tags/{tagId}")
	Project addProjectTag(
				@PathVariable Integer projectId,
				@PathVariable Integer tagId
			) 
	{
		Project project = projectRepository.findById(projectId).get();
		Tag tag = tagRepository.findById(tagId).get();
		
		project.addTag(tag);
		return projectRepository.save(project);
	}
	
	@CrossOrigin("http://localhost:3000")
	@DeleteMapping("/{projectId}/tags/{tagId}")
	Project deleteProjectTag(
				@PathVariable Integer projectId,
				@PathVariable Integer tagId
			) 
	{
		Project project = projectRepository.findById(projectId).get();
		Tag tag = tagRepository.findById(tagId).get();
		
		project.removeTag(tag);
		return projectRepository.save(project);
	}
	
	@CrossOrigin("http://localhost:3000")
	@PutMapping("/{projectId}/users/{userId}")
	Project addProjectOwner(
				@PathVariable Integer projectId,
				@PathVariable Integer userId
			) 
	{
		Project project = projectRepository.findById(projectId).get();
		User owner = userRepository.findById(userId).get();
		
		project.setOwner(owner);
		return projectRepository.save(project);
	}
	
	@CrossOrigin("http://localhost:3000")
	@PutMapping("/{projectId}/members/{userId}")
	Project addProjectMember(
				@PathVariable Integer projectId,
				@PathVariable Integer userId
			) 
	{
		Project project = projectRepository.findById(projectId).get();
		User member = userRepository.findById(userId).get();
		
		project.addMember(member);
		return projectRepository.save(project);
	}
	
	@CrossOrigin("http://localhost:3000")
	@DeleteMapping("/{projectId}/members/{userId}")
	Project deleteProjectMember(
				@PathVariable Integer projectId,
				@PathVariable Integer userId
			) 
	{
		Project project = projectRepository.findById(projectId).get();
		User member = userRepository.findById(userId).get();
		
		project.removeMember(member);
		return projectRepository.save(project);
	}
	
	//sending logged in user as a response to login
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/users/{email}")
	User getByEmail(
			@PathVariable String email
			) {
		User user = userRepository.getUserByEmail(email);
		return user;
	}
	
	//sending looged in user info directly - better method
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/currUser")
	User getCurrentUser() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
		
		User user = userRepository.getUserByEmail(oauthUser.getEmail());
		return user;
	}
}
