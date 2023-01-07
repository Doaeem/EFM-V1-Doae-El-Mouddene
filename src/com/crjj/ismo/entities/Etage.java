package com.crjj.ismo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Etage")
public class Etage implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_etage")
	private int num_etage;
	
	@Column(name = "nb_appartement_tot")
	private int nb_appartement_tot;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="num_immeuble")
	private Immeuble num_immeuble;
	
	@OneToMany(mappedBy="Appartement", fetch=FetchType.EAGER)
	private List<Appartement> Appartements=new ArrayList<Appartement>();
	
	public List<Appartement> getAppartements() {
		return Appartements;
	}

	public void setImmeubles(List<Appartement> Appartements) {
		this.Appartements = Appartements;
	}

	public int getNum_etage() {
		return num_etage;
	}
	public void setNum_etage(int num_etage) {
		this.num_etage = num_etage;
	}
	public int getNb_appartement_tot() {
		return nb_appartement_tot;
	}
	public void setNb_appartement_tot(int nb_appartement_tot) {
		this.nb_appartement_tot = nb_appartement_tot;
	}
	public Immeuble getNum_immeuble() {
		return num_immeuble;
	}
	public void setNum_immeuble(Immeuble num_immeuble) {
		this.num_immeuble = num_immeuble;
	}
	
	public Etage(int num_etage, int nb_appartement_tot, Immeuble num_immeuble, List<Appartement> appartements) {
		super();
		this.num_etage = num_etage;
		this.nb_appartement_tot = nb_appartement_tot;
		this.num_immeuble = num_immeuble;
		Appartements = appartements;
	}

	public Etage() {
		super();
	}
	
	
}
