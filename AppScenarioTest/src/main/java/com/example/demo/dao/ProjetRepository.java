package com.example.demo.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Projet;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface ProjetRepository extends JpaRepository<Projet,Long>{

	Optional<Projet> findById(Long projetId);

	void deleteById(Long projetId);

}
