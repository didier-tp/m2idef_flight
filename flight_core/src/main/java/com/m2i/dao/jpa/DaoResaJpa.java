package com.m2i.dao.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoResa;
import com.m2i.entity.Resa;


//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au debut
@Transactional //en version spring
public class DaoResaJpa extends DaoGenericJpaImpl<Resa,Long> implements IDaoResa {
	
	

}
