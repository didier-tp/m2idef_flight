package com.m2i.web.rest.data;

import com.m2i.entity.Client;

/*
 * DTO = Data Transfert Object
 * classe de données (non directement persistante)
 * véhiculée entre WebServiceRest et client (js ou ...)
 * ----
 * ici convertie en JSON dans le cadre des WS REST
 * ---
 * DTO = classe spécifique au dialogues "WebService"
 *  à ranger dans package rest.data ou rest.dto 
 */

//Authentification à vérifier
public class Auth {
	private String username;
	private String password;
	private Boolean status;
	private String message;
	private Client client;//client authentifié (null)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
