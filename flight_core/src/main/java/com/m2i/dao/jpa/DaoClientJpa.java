package com.m2i.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoClient;
import com.m2i.entity.Client;


//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au debut
@Transactional //en version spring
public class DaoClientJpa extends DaoGenericJpaImpl<Client,Long> implements IDaoClient {
	
	public List<Client> findClientByName(String nom){
	 
	 return em.createNamedQuery("Client.findByName",Client.class)
			 .setParameter("pnom", nom)
			 .getResultList();
    }


}
