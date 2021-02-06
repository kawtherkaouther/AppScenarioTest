package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Projet;


@CrossOrigin("http://localhost:4200")
public interface ProjetService {
	

    Projet save(Projet projet);

  

    Long delete(Projet projet);

    Long delete(Long projetId);

    Long update(Projet projet);

   

    Projet findProjetById(Long id);



	List<Projet> findAllProjet();

}
