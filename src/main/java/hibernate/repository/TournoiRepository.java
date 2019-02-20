package hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.model.Tournoi;

public interface TournoiRepository extends JpaRepository<Tournoi, Integer>{

}
