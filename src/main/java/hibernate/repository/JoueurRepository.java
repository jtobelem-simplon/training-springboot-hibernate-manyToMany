package hibernate.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.model.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Integer>{
	
	List<Joueur> findAllByDateNaissanceBetween(LocalDate from, LocalDate to);

}
