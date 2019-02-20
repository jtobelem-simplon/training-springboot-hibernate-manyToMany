package hibernate.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the joueurs database table.
 * 
 */
@Entity
@Table(name="joueurs")
public class Joueur  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="joueur_pk")
	private Integer joueurPk;

	@Column(name="date_naissance")
	private LocalDate dateNaissance;

	private String nom;

	//bi-directional many-to-one association to Equipe
	@ManyToOne
	@JoinColumn(name="equipe_fk")
	private Equipe equipe;

	public Joueur() {
	}
	
	public Joueur(String nom, LocalDate dateNaissance) {
		this.nom = nom;
		this.dateNaissance = dateNaissance;
	}

	public Integer getJoueurPk() {
		return this.joueurPk;
	}

	public void setJoueurPk(Integer joueurPk) {
		this.joueurPk = joueurPk;
	}

	public LocalDate getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Equipe getEquipe() {
		return this.equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

}