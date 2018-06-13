package com.m2i.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoPersonne;
import com.m2i.entity.Adresse;
import com.m2i.entity.Personne;


//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au debut
@Transactional //en version spring
public class DaoPersonneJpa extends DaoGenericJpaImpl<Personne,Long> implements IDaoPersonne {
	
	@Override
	public Personne insert(Personne pers) {
		Personne p=null;
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

	@Override
	public List<Personne> findPersonneByName(String nom){
	 
	 return em.createNamedQuery("Personne.findByName",Personne.class)
			 .setParameter("pnom", nom)
			 .getResultList();
    }


}
