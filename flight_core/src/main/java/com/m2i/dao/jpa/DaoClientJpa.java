package com.m2i.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoClient;
import com.m2i.entity.Adresse;
import com.m2i.entity.Client;
import com.m2i.entity.Personne;


//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au debut
@Transactional //en version spring
public class DaoClientJpa extends DaoGenericJpaImpl<Client,Long> implements IDaoClient {
	
	public List<Client> findClientByName(String nom){
	 
	 return em.createNamedQuery("Client.findByName",Client.class)
			 .setParameter("pnom", nom)
			 .getResultList();
    }
	
	@Override
	public Client insert(Client pers) {
		Client p=null;
		Adresse adr = pers.getAdresse(); 
		if(adr!=null){
            pers.setAdresse(null);//detach non persistant before insert
		}
		p = super.insert(pers); //perist pers , now pers has an id
		if(adr!=null){
			adr.setIdAdresse(p.getId()); //with same id as p/pers
			em.persist(adr);
			p.setAdresse(adr);//ré-attachement
		}
		return p;
	}


}
