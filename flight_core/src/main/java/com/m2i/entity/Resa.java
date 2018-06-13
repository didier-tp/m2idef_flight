package com.m2i.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Resa")
public class Resa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idResa;
	
	private String comment;
	
	@Temporal(TemporalType.DATE)
	private Date dateResa;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idClient")
	private Client client;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idVol")
	private Vol vol;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="Resa_Personne",   
			  joinColumns = {@JoinColumn(name = "idResa")},                    
			  inverseJoinColumns = {@JoinColumn(name = "idPers")})
	private List<Personne> listePassagers;

	public Resa() {
		super();
	}

	public Resa(Long idResa, String comment, Date dateResa, Client client) {
		super();
		this.idResa = idResa;
		this.comment = comment;
		this.dateResa = dateResa;
		this.client = client;
	}
	
	

	

	@Override
	public String toString() {
		return "Resa [idResa=" + idResa + ", comment=" + comment + ", dateResa=" + dateResa + "]";
	}

	public Long getIdResa() {
		return idResa;
	}

	public void setIdResa(Long idResa) {
		this.idResa = idResa;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDateResa() {
		return dateResa;
	}

	public void setDateResa(Date dateResa) {
		this.dateResa = dateResa;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public List<Personne> getListePassagers() {
		return listePassagers;
	}

	public void setListePassagers(List<Personne> listePassagers) {
		this.listePassagers = listePassagers;
	}
	
	public void addPassager(Personne p){
		if (listePassagers==null){
			listePassagers = new ArrayList<Personne>();
		}
		listePassagers.add(p);
	}
	
	

}
