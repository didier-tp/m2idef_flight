package com.m2i.dao.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoVols;
import com.m2i.entity.Vol;


//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au debut
@Transactional //en version spring
public class DaoVolsJpa extends DaoGenericJpaImpl<Vol,Long> implements IDaoVols {

	@Override
	public List<Vol> findVolsByVilleDepart(String town) {
		return em.createNamedQuery("Vol.findVolsByVilleDepart",Vol.class)
                 .setParameter("pTown", town)
                 .getResultList();
	}
	
	@Override
	public List<Vol> findVolsByDateDepart(Date dateDepart) {
		return em.createNamedQuery("Vol.findVolsByDateDepart",Vol.class)
                 .setParameter("pDate", dateDepart)
                 .getResultList();
	}
	
	@Override
	public List<Vol> findVolsByDateAndVilleDepart(Date dateDepart, String ville) {
		return em.createNamedQuery("Vol.findVolsByDateAndVilleDepart",Vol.class)
                 .setParameter("pDate", dateDepart)
                 .setParameter("pTown", ville)
                 .getResultList();
	}
	
}
