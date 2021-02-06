package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entities.Scenario;


@CrossOrigin("http://localhost:4200/")
public interface ScenarioService {

	
	 Scenario save(Scenario scenario);

	    Long delete(Scenario scenario);

	    Long delete(Long scenarioId);

	    Long update(Scenario scenario);

	    List<Scenario> findAllScenario();


	    Scenario findScenarioById(Long id);
}
