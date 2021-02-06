package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Module;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface ModuleRepository extends JpaRepository<Module,Long>{

}
