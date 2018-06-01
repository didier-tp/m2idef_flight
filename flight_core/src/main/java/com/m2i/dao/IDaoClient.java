package com.m2i.dao;

import java.util.List;

import com.m2i.entity.Client;


public interface IDaoClient extends IDaoGeneric<Client,Long>{
    
    public List<Client> findClientByName(String nom);
	
}    
