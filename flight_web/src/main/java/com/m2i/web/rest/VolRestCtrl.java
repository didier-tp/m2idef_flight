package com.m2i.web.rest;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.entity.Vol;
import com.m2i.service.IServiceVols;
import com.m2i.util.MyDateTimeUtil;

@RestController
@RequestMapping(value="/rest/vols" , 
                headers="Accept=application/json")
public class VolRestCtrl {
	
	//business service vers lequel déléguer les traitements :
	@Autowired
	private IServiceVols serviceVols; 
	
	//sera appelé en HTTP / GET avec l' URL suivante:
	// http://localhost:8080/flight_Web/mvc/rest/vols/byCriteria?villeDepart=Paris&dateDepart=2018-09-20
	@RequestMapping(value="/byCriteria" , method=RequestMethod.GET)
	List<Vol> getComptesDuClient( @RequestParam(value="villeDepart",required=false) String villeDepart ,
			                      @RequestParam(value="dateDepart",required=false) String strDateDepart ){
		Date dateDepartRecherchee = null;
		if(villeDepart!=null && villeDepart.isEmpty()) villeDepart=null;
		if(strDateDepart!=null && strDateDepart.isEmpty()) strDateDepart=null;
		if(strDateDepart!=null) dateDepartRecherchee = MyDateTimeUtil.dateFromString(strDateDepart);
		return serviceVols.rechercherVolsAuDepart(villeDepart, dateDepartRecherchee);
		//NB: le resultat java de type List<Vol>
		//sera automatiquement transformé au format JSON
	}
	
	
}

