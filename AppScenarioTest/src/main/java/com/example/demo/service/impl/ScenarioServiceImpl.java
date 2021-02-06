package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.dao.ScenarioRepository;
import com.example.demo.entities.Scenario;
import com.example.demo.service.ScenarioService;
@CrossOrigin("http://localhost:4200/")
@Service
public class ScenarioServiceImpl implements ScenarioService {

	@Autowired
	ScenarioRepository scenarioRepository;
	@Override
	public Scenario save(Scenario scenario) {
		return scenarioRepository.save(scenario);
	}

	@Override
	public Long delete(Scenario scenario) {
		scenarioRepository.delete(scenario);
		return 0l;
	}

	@Override
	public Long delete(Long scenarioId) {
		scenarioRepository.deleteById(scenarioId);
		return 0l;
	}

	@Override
	public Long update(Scenario scenario) {
		Optional<Scenario> localSc = scenarioRepository.findById((long) scenario.getId());
		if(localSc.isPresent()) {
			scenarioRepository.save(scenario);
		}
		return 0l;
	}

	@Override
	public List<Scenario> findAllScenario() {
		return scenarioRepository.findAll();
	}

	@Override
	public Scenario findScenarioById(Long id) {
		 Optional<Scenario> localSce = scenarioRepository.findById(id);
	        return localSce.orElse(null);
	}

}
