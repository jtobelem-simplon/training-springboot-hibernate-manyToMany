package hibernate.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.Application;
import hibernate.model.Equipe;
import hibernate.model.Joueur;
import hibernate.repository.EquipeRepository;
import hibernate.repository.JoueurRepository;
import hibernate.repository.TournoiRepository;

@Service
public class MainService {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	JoueurRepository joueurRepository;

	@Autowired
	TournoiRepository tournoiRepository;
	
	@Autowired
	EquipeRepository equipeRepository;
	
	@PersistenceContext
	private EntityManager em;

	public void create() {
		log.info(">> CREATE joueurs and equipe");

		List<Joueur> joueurs = Arrays.asList(
				new Joueur("Jonas Aguenier", LocalDate.of(1992, 4, 28)),
				new Joueur("Jenia Grebennikov", LocalDate.of(1990, 8, 13)),
				new Joueur("Luka Basic", LocalDate.of(1995, 1, 29)),
				new Joueur("Jean Patry", LocalDate.of(1996, 12, 22)),
				new Joueur("Raphaël Corre", LocalDate.of(1989, 11, 21))
			);

		Equipe equipeA = new Equipe("equipeA");

		for (Joueur joueur : joueurs) {
			equipeA.addJoueur(joueur);
		}

		equipeRepository.save(equipeA);
	}

	public void read() {
		log.info(">> READ les joueurs");
		List<Joueur> joueurList = joueurRepository.findAll();

		for (Joueur joueur : joueurList) {
			log.info(joueur.getNom());
		}

		log.info(">> READ les equipes");
		List<Equipe> equipeList = equipeRepository.findAll();

		for (Equipe equipe : equipeList) {
			log.info("[equipe : {}]", equipe.getNom());
			List<Joueur> joueurListEquipe = equipe.getJoueurs();

			for (Joueur joueur : joueurListEquipe) {
				log.info(joueur.getNom());
			}
		}
	}

	public void update() {
		
	}

	public void delete() {
		log.info(">> DELETE les joueurs");
		joueurRepository.deleteAllInBatch();
		log.info(">> DELETE les equipes");
		equipeRepository.deleteAllInBatch();
		log.info(">> DELETE les tournois");
		tournoiRepository.deleteAllInBatch();
	}
	
	/**
	 * Pour illustrer l'utilisation de requêtes personnalisées. Pour les créer, il
	 * suffit d'ajouter leur signature dans l'interface du repository.
	 */
	public void specificQueries() {
		log.info(">> Specific queries");
		log.info(">>>> findAllByDateNaissanceBetween");
		
		List<Joueur> joueurs = joueurRepository.findAllByDateNaissanceBetween(
				LocalDate.of(1991, 01, 01), 
				LocalDate.of(1996, 01, 01)
			);
		
		for (Joueur joueur : joueurs) {
			log.info("joueur:{}, date:{}", joueur.getNom(), joueur.getDateNaissance());
		}
	}


}
