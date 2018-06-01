package com.m2i.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoPersonne;
import com.m2i.entity.Personne;


//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au debut
@Transactional //en version spring
public class DaoPersonneJpa extends DaoGenericJpaImpl<Personne,Long> implements IDaoPersonne {
	
	@Override
	public List<Personne> findPersonneByName(String nom){
	 
	 return em.createNamedQuery("Personne.findByName",Personne.class)
			 .setParameter("pnom", nom)
			 .getResultList();
    }


}
