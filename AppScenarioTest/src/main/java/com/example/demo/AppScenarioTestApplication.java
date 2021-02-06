package com.example.demo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import com.example.demo.entities.AppUser;
import com.example.demo.entities.Projet;
import com.example.demo.service.AppUserService;
import com.example.demo.service.ProjetService;




@SpringBootApplication
public class AppScenarioTestApplication extends SpringBootServletInitializer implements CommandLineRunner{

	
	 @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {	   
	 	   return new BCryptPasswordEncoder(); 
	    } 
	 @Autowired
	 ProjetService projetService;

@Autowired
AppUserService appUserService;

	  
	public static void main(String[] args) {
		SpringApplication.run(AppScenarioTestApplication.class, args);
	}

	

	@Override
	public void run(String... args) throws Exception {
		
		AppUser u=new AppUser();
		u.setLogin("kawther_login");
		u.setFirstName("kawther");
		u.setLastName("b");
		u.setPassword("1234");
		appUserService.saveUser(u);
		
		Projet p = new Projet();
		p.setNom("ccc");
		p.setDescription("ggggg");
		projetService.save(p);
		
		
		
		
		
	}
	
}
