package com.m2i.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoClient;
import com.m2i.dao.IDaoResa;
import com.m2i.dao.IDaoVols;
import com.m2i.entity.Resa;

@Service 
@Transactional
public class ServiceResaImpl implements IServiceResa {
	
	@Autowired
	private IDaoResa daoResa=null;
	
	@Autowired
	private IDaoVols daoVols=null;
	
	@Autowired
	private IDaoClient daoClient=null;

	@Override
	public Resa rechercherResaById(Long id) {
		Resa resa =  daoResa.findByKey(id);
		resa.getVol().getDepart(); //against lazy exception
		resa.getVol().getArrivee();//against lazy exception
		return resa;
	}

	@Override
	public List<Resa> findListeResaDuClient(Long clientId) {
		// ...
		return null;
	}

	@Override
	public Resa nouvelleResa(Long numCli, Long numVol) {
		Resa  resa  = null;
		resa = new Resa();
		resa.setDateResa(new Date());
		resa.setClient(daoClient.findByKey(numCli));
		resa.setVol(daoVols.findByKey(numVol));
		resa = daoResa.insert(resa);
		return resa;
	}

}
