package com.m2i.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoLocalite;
import com.m2i.dao.IDaoVols;
import com.m2i.entity.Localite;
import com.m2i.entity.Vol;
//version simulée sans base (temporairement)
@Service
@Transactional
public class ServiceVolsImpl implements IServiceVols {
	
	@Autowired
	private IDaoLocalite daoLocalite;
	
	@Autowired
	private IDaoVols daoVols;

	@Override
	public List<Localite> rechercherListeLocalites() {
		return daoLocalite.findAll();
		
	}

	@Override
	public List<Vol> rechercherVolsAuDepart(String ville, Date date) {
		return daoVols.findVolsByDeparture(ville); //date a prendre en compte dans future version
	}

}
