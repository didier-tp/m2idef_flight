package com.m2i.service;

import java.util.List;

import com.m2i.entity.Client;
import com.m2i.entity.Login;

/**
 * 
 * ServiceClient = service m�tier (business service)
 * avec gestion des transactions (commit, rollback)
 *    + traitements specifiques au metier (banque ou aviation ou ...)
 *    
 *    avec certains sous traitements qui seront delegues au(x) DAO(s)
 *
 */

public interface IServiceClient {
	public Client rechercherClient(Long id);
	public void majClient(Client client); //mettre a jour client
	public List<Client> findClientByName(String nom);
	//...
	public Client insertClientWithLogin(Client cli, Login login);
	public void supprimerClientWithLogin(Long idClient);
	//public Client rechercherClientAvecResa(Long id);
	
	public Login loginByUsernameAndPassword(String username, String password);
}
