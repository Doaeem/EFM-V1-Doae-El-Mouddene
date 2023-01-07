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
@Table(name="Immeuble")
public class Immeuble implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="num_immeuble")
	private int num_immeuble;
	
	@Column(name = "nb_etage_total")
	private int nb_etage_total;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="code_rue")
	private Rue code_rue;

	@OneToMany(mappedBy="Etage", fetch=FetchType.EAGER)
	private List<Etage> Etages=new ArrayList<Etage>();
	
	public List<Etage> getEtages() {
		return Etages;
	}

	public void setEtages(List<Etage> Etages) {
		this.Etages = Etages;
	}

	public int getNum_immeuble() {
		return num_immeuble;
	}
	
	public void setNum_immeuble(int num_immeuble) {
		this.num_immeuble = num_immeuble;
	}
	
	public int getNb_etage_total() {
		return nb_etage_total;
	}
	
	public void setNb_etage_total(int nb_etage_total) {
		this.nb_etage_total = nb_etage_total;
	}
	
	public Rue getCode_rue() {
		return code_rue;
	}
	
	public void setCode_rue(Rue code_rue) {
		this.code_rue = code_rue;
	}
	
	

	public Immeuble(int num_immeuble, int nb_etage_total, Rue code_rue, List<Etage> etages) {
		super();
		this.num_immeuble = num_immeuble;
		this.nb_etage_total = nb_etage_total;
		this.code_rue = code_rue;
		Etages = etages;
	}

	public Immeuble() {
		super();
	}
	
}
