package com.m2i.service;

import java.util.List;

import com.m2i.entity.Client;
import com.m2i.entity.Login;
import com.m2i.entity.Resa;

/**
 * 
 * ServiceClient = service metier (business service)
 * avec gestion des transactions (commit, rollback)
 *    + traitements specifiques au metier (banque ou aviation ou ...)
 *    
 *    avec certains sous traitements qui seront delegues au(x) DAO(s)
 *
 */

public interface IServiceResa {
	public Resa rechercherResaById(Long id);
	//public void majResa(Resa resa); //mettre a jour resa
	public List<Resa> findListeResaDuClient(Long clientId);
	
}
