package com.mnithelp.projecthub.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnithelp.projecthub.entity.User;
import com.mnithelp.projecthub.repository.UserRepository;

@Service
public class UserService {

	 @Autowired
	    private UserRepository repo;
	     
	    public void processOAuthPostLogin(String email,String name) {
	    	User existUser = repo.getUserByEmail(email);
	    	
	    	if(existUser == null) {
	    		User newUser = new User();
	    		newUser.setEmail(email);
	    		newUser.setName(name);
	    		newUser.setProvider(Provider.GOOGLE);
	    		
	    		repo.save(newUser);
	    	}
	    }
}
