package com.m2i.dao;

import java.util.List;

import com.m2i.entity.Personne;


public interface IDaoPersonne extends IDaoGeneric<Personne,Long>{
    
    public List<Personne> findPersonneByName(String nom);
	
}    
