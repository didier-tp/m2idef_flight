package com.m2i.dao;

import java.util.List;

import com.m2i.entity.Vol;


public interface IDaoVols extends IDaoGeneric<Vol,Long>{
    
    public List<Vol> findVolsByDeparture(String town);
	
}    
