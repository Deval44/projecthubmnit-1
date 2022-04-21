package com.mnithelp.projecthub.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.mnithelp.projecthub.entity.Idea;
import com.mnithelp.projecthub.entity.Job;
import com.mnithelp.projecthub.entity.Link;
import com.mnithelp.projecthub.entity.Project;
import com.mnithelp.projecthub.entity.Stage;
import com.mnithelp.projecthub.entity.Tag;
import com.mnithelp.projecthub.entity.User;

@Component
public class CustomRestConfiguration implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		config.exposeIdsFor(Idea.class);
		config.exposeIdsFor(Stage.class);
		config.exposeIdsFor(User.class);
		config.exposeIdsFor(Job.class);
		config.exposeIdsFor(Link.class);
		config.exposeIdsFor(Tag.class);
		config.exposeIdsFor(Project.class);
	}

	
}
