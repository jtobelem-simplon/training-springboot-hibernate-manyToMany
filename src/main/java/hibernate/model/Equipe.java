package hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the equipes database table.
 * 
 */
@Entity
@Table(name="equipes")
public class Equipe  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="equipe_pk")
	private Integer equipePk;

	private String nom;

	//bi-directional many-to-many association to Tournoi
	@ManyToMany
	@JoinTable(
		name="equipes_tournois"
		, joinColumns={
			@JoinColumn(name="equipe_fk")
			}
		, inverseJoinColumns={
			@JoinColumn(name="tournoi_fk")
			}
		)
	private List<Tournoi> tournois = new ArrayList<Tournoi>();

	//bi-directional many-to-one association to Joueur
	@OneToMany(cascade=CascadeType.ALL, mappedBy="equipe")
	private List<Joueur> joueurs = new ArrayList<Joueur>();

	public Equipe() {
	}
	
	public Equipe(String nom) {
		this.nom = nom;
	}

	public Integer getEquipePk() {
		return this.equipePk;
	}

	public void setEquipePk(Integer equipePk) {
		this.equipePk = equipePk;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Tournoi> getTournois() {
		return this.tournois;
	}

	public void setTournois(List<Tournoi> tournois) {
		this.tournois = tournois;
	}

	public List<Joueur> getJoueurs() {
		return this.joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Joueur addJoueur(Joueur joueur) {
		getJoueurs().add(joueur);
		joueur.setEquipe(this);

		return joueur;
	}

	public Joueur removeJoueur(Joueur joueur) {
		getJoueurs().remove(joueur);
		joueur.setEquipe(null);

		return joueur;
	}

}