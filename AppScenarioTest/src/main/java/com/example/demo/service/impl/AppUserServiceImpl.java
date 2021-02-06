package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.dao.AppUserRepository;
import com.example.demo.entities.AppUser;
import com.example.demo.service.AppUserService;

@CrossOrigin("http://localhost:4200/")
@Service
public class AppUserServiceImpl implements AppUserService {

	
	@Autowired
	AppUserRepository appUserRepository;
	
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;



	@Override
	public List<AppUser> findAllUser() {
		// TODO Auto-generated method stub
		return appUserRepository.findAll();
	}


	@Override
	public AppUser saveUser(AppUser user) {
		String hashPassword= bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPassword);
	
		return appUserRepository.save(user);
	}


	@Override
	public AppUser findUserByUserName(String userName) {
		return appUserRepository.findByLogin(userName);
	}

	
}
