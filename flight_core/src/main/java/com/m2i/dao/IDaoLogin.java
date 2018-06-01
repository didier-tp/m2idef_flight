package com.m2i.dao;

import com.m2i.entity.Login;


public interface IDaoLogin extends IDaoGeneric<Login,Long>{
    
    public Login findLoginByUsername(String username);
	
}    
