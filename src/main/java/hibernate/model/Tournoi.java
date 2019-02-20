package hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * The persistent class for the tournois database table.
 * 
 */
@Entity
@Table(name="tournois")
public class Tournoi  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tournoi_pk")
	private Integer tournoiPk;

	private String nom;

	//bi-directional many-to-many association to Equipe
	@ManyToMany(mappedBy="tournois")
	private List<Equipe> equipes =  new ArrayList<Equipe>();

	public Tournoi() {
	}

	public Integer getTournoiPk() {
		return this.tournoiPk;
	}

	public void setTournoiPk(Integer tournoisPk) {
		this.tournoiPk = tournoisPk;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Equipe> getEquipes() {
		return this.equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

}