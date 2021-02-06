package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.dao.ModuleRepository;
import com.example.demo.entities.Module;
import com.example.demo.service.ModuleService;
@CrossOrigin("http://localhost:4200/")
@Service
public class ModuleServiceImpl implements ModuleService{

	@Autowired
	ModuleRepository moduleRepository;
	
	@Override
	public Module save(Module module) {
		return moduleRepository.save(module);
	}

	@Override
	public Long delete(Module module) {
		moduleRepository.delete(module);
		return 0l;
	}

	@Override
	public Long delete(Long moduleId) {
		moduleRepository.deleteById(moduleId);
		return  0l;
	}

	@Override
	public Long update(Module module) {
		Optional<Module> localMol = moduleRepository.findById((long) module.getId());
		if(localMol.isPresent()) {
			moduleRepository.save(module);
		}
		return  0l;
	}

	@Override
	public List<Module> findAllModule() {
		return moduleRepository.findAll();
	}

	@Override
	public Module findModuleById(Long id) {
		 Optional<Module> localMol = moduleRepository.findById(id);
	        return localMol.orElse(null);
	}

	
}
