package com.m2i.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@DiscriminatorValue("Client")
//avec dans super classe "Compte":
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="typePersonne",discriminatorType=DiscriminatorType.STRING)
@NamedQuery(name="Client.findByName",
            query="SELECT c FROM Client c WHERE c.nom = :pnom")
public class Client extends Personne{
	
	
	@OneToOne(mappedBy="client")
	@JsonIgnore
	private Login login;
	

	
	/*
	@OneToMany(mappedBy="client") //Lazy par defaut
	private List<Resa> listeResa;
*/
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
/*
	public List<Resa> getListeResa() {
		return listeResa;
	}

	public void setListeResa(List<Resa> listeResa) {
		this.listeResa = listeResa;
	}
	*/
	public Client(Long idClient, String nom, String prenom) {
		super(idClient,nom,prenom);
	}

	public Client() {
		super();
	}

	@Override
	public String toString() {
		return "Client " + super.toString();
	}

	
	
	
	
	
}
