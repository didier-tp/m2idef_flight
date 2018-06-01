package com.m2i.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.dao.IDaoResa;
import com.m2i.entity.Resa;

@Service 
@Transactional
public class ServiceResaImpl implements IServiceResa {
	
	@Autowired
	private IDaoResa daoResa=null;

	@Override
	public Resa rechercherResaById(Long id) {
		return daoResa.findByKey(id);
	}

	@Override
	public List<Resa> findListeResaDuClient(Long clientId) {
		// ...
		return null;
	}

}
