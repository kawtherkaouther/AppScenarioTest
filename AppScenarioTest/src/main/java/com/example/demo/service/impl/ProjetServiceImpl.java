package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.dao.ProjetRepository;
import com.example.demo.entities.Projet;
import com.example.demo.service.ProjetService;
@CrossOrigin("http://localhost:4200/")
@Service
public class ProjetServiceImpl implements ProjetService{

	@Autowired
	ProjetRepository projetRepository;
	
	@Override
	public Projet save(Projet projet) {
		return projetRepository.save(projet);
	}

	@Override
	public Long delete(Projet projet) {
		projetRepository.delete(projet);
		return 0l;
	}

	@Override
	public Long delete(Long projetId) {
		projetRepository.deleteById(projetId);
		return 0l;
	}

	@Override
	public Long update(Projet projet) {
		Optional<Projet> localpro = projetRepository.findById(projet.getProjetId());
		if(localpro.isPresent()) {
			projetRepository.save(projet);
		}
		return 0l;
	}

	@Override
	public Projet findProjetById(Long id) {
		 Optional<Projet> localpro = projetRepository.findById(id);
	        return localpro.orElse(null);
	}

	@Override
	public List<Projet> findAllProjet() {
		// TODO Auto-generated method stub
		return projetRepository.findAll();
	}

}
