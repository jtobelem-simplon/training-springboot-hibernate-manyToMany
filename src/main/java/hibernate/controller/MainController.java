package hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hibernate.model.Joueur;
import hibernate.repository.JoueurRepository;
import hibernate.service.MainService;


@RestController
public class MainController {
	
	@Autowired
	JoueurRepository joueurRepository;
	
	@Autowired
	MainService mainService;
	
	@GetMapping("/etudiants")
	public List<Joueur> getAllPeople(){
		return joueurRepository.findAll();
	}
	
	@GetMapping("/init")
	public void create() {
		mainService.delete();
		mainService.create();
	}

}
