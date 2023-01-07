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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Rue")
public class Rue implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="code_rue")
	private int code_rue;
	
	@Column(name = "nom_rue")
	private String nom_rue;
	
	@OneToMany(mappedBy="Immeuble", fetch=FetchType.EAGER)
	private List<Immeuble> Immeubles=new ArrayList<Immeuble>();
	
	public List<Immeuble> getImmeubles() {
		return Immeubles;
	}

	public void setImmeubles(List<Immeuble> Immeubles) {
		this.Immeubles = Immeubles;
	}

	public int getCode_rue() {
		return code_rue;
	}
	
	public void setCode_rue(int code_rue) {
		this.code_rue = code_rue;
	}
	
	public String getNom_rue() {
		return nom_rue;
	}
	
	public void setNom_rue(String nom_rue) {
		this.nom_rue = nom_rue;
	}
	
	public Rue() {
		super();
	}

	public Rue(int code_rue, String nom_rue, List<Immeuble> immeubles) {
		super();
		this.code_rue = code_rue;
		this.nom_rue = nom_rue;
		Immeubles = immeubles;
	}
	
	

}
