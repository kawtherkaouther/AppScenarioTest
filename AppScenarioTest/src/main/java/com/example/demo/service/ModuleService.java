package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Module;


@CrossOrigin("http://localhost:4200")
public interface ModuleService {
	
	Module save(Module module);

    Long delete(Module module);

    Long delete(Long moduleId);

    Long update(Module module);

    List<Module> findAllModule();

    Module findModuleById(Long id);

}
