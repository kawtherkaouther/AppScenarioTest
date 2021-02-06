package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.AppUser;

@CrossOrigin("http://localhost:4200")
public interface AppUserService {
	


	    
	    List<AppUser> findAllUser();
	    public AppUser saveUser(AppUser user);
		public AppUser findUserByUserName(String userName);


	 
}
