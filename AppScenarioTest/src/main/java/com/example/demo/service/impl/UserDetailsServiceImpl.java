package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.AppUser;
import com.example.demo.service.AppUserService;
@CrossOrigin("http://localhost:4200/")
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AppUserService appUserService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        AppUser user = appUserService.findUserByUserName(userName);
        if(user==null) throw new UsernameNotFoundException(userName);
		
        Collection<GrantedAuthority> authorities= new ArrayList<>();
        
        user.getRoles().forEach(r->{
        	
        	authorities.add(new SimpleGrantedAuthority(r.getRole()));
		        //Adding privilege
        	     r.getPreviliges().forEach(p->{
		            	authorities.add(new SimpleGrantedAuthority(p.getPrevilige()));
		        });
        	
        });

        
        System.out.println("------------------- wynsysUserService authorities  "+authorities);
        return new User(user.getLogin(), user.getPassword(),authorities);
	}}