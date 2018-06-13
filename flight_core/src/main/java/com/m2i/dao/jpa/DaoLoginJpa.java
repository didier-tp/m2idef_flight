package com.m2i.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoLogin;
import com.m2i.entity.Login;


//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au debut
@Transactional //en version spring
public class DaoLoginJpa extends DaoGenericJpaImpl<Login,Long> implements IDaoLogin {
	
	

	public Login findLoginByUsername(String username){
	 
	 return em.createNamedQuery("Login.findByUsername",Login.class)
			 .setParameter("pusername", username)
			 .getSingleResult();
    }


}
