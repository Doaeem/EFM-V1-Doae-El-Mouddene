package com.crjj.ismo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Appartement")
public class Appartement implements Serializable{
	
	@Id
	@Column(name="lettre_appartement")
	private String lettre_appartement;
	
	@Column(name = "nb_pieces_total")
	private int nb_pieces_total;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="num_etage")
	private Etage num_etage;
	
	public String getLettre_appartement() {
		return lettre_appartement;
	}
	public void setLettre_appartement(String lettre_appartement) {
		this.lettre_appartement = lettre_appartement;
	}
	public int getNb_pieces_total() {
		return nb_pieces_total;
	}
	public void setNb_pieces_total(int nb_pieces_total) {
		this.nb_pieces_total = nb_pieces_total;
	}
	public Etage getNum_etage() {
		return num_etage;
	}
	public void setNum_etage(Etage num_etage) {
		this.num_etage = num_etage;
	}
	public Appartement(String lettre_appartement, int nb_pieces_total, Etage num_etage) {
		super();
		this.lettre_appartement = lettre_appartement;
		this.nb_pieces_total = nb_pieces_total;
		this.num_etage = num_etage;
	}
	public Appartement() {
		super();
	}
	
	

}
