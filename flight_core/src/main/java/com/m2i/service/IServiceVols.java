package com.m2i.service;

import java.util.Date;
import java.util.List;

import com.m2i.entity.Localite;
import com.m2i.entity.Vol;

public interface IServiceVols {
    List<Localite> rechercherListeLocalites();
    List<Vol> rechercherVolsAuDepart(String ville,Date date);
}
