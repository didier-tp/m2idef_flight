package com.m2i.service;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoClient;
import com.m2i.dao.IDaoLogin;
import com.m2i.entity.Client;
import com.m2i.entity.Login;

//@Component
@Service //id par defaut =  serviceClientImpl
@Transactional
public class ServiceClientImpl implements IServiceClient {
	
	//logger en version slf4j
	private Logger logger = LoggerFactory.getLogger(ServiceClientImpl.class);
	
	@Autowired
	private IDaoClient daoClient=null;
	
	@Autowired
	private IDaoLogin daoLogin=null;
	
	
	@Override
    public Client insertClientWithLogin(Client cli,Login login){
		Client savedClient =null;
		try {
			savedClient= daoClient.insert(cli);
			login.setIdClient(savedClient.getId());
			Login savedLogin = daoLogin.insert(login);
			savedClient.setLogin(savedLogin);
		} catch (Exception e) {
			//e.printStackTrace(); 
			logger.error("echec insertClientWithLogin",e);
			throw new RuntimeException("echec insertClientWithLogin",e);
		}
		return savedClient;
    }
	
	

	@Override
	public Client rechercherClient(Long id) {
		return daoClient.findByKey(id);
	}
	
	
	@Override
	@Transactional //obligatoire ici pour que client et login restent persistants
	               //avant de les retransmettre a daoXyz.delete()
	public void supprimerClientWithLogin(Long idClient){
		Client client = daoClient.findByKey(idClient);
		Login login = daoLogin.findByKey(idClient);
		if(login!=null) 
			 daoLogin.delete(login);//ordre selon contrainte du schema
		if(client!=null) 
			daoClient.delete(client);
	}

	@Override
	public void majClient(Client client) {
		daoClient.update(client);
	}
	
	@Override
	public List<Client> findClientByName(String nom) {
		return daoClient.findClientByName(nom);
	}

}
