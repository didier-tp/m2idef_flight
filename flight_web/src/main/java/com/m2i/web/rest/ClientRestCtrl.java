package com.m2i.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.entity.Client;
import com.m2i.entity.Login;
import com.m2i.service.IServiceClient;
import com.m2i.web.rest.data.Auth;

@RestController
@RequestMapping(value="/rest/clients" , 
                headers="Accept=application/json")
public class ClientRestCtrl {
	
	//business service vers lequel déléguer les traitements :
	@Autowired
	private IServiceClient serviceClient; 
	
	//sera appelé en HTTP / POST avec l' URL suivante:
	// http://localhost:8080/flight_web/mvc/rest/clients/auth
	//with auth = { "username" : "toto" , "password": "pwd_toto" }
	@RequestMapping(value="/auth" , method=RequestMethod.POST)
	ResponseEntity<Auth> authentifierClient( @RequestBody Auth auth ){
		Login login;
		try {
			login = serviceClient.loginByUsernameAndPassword(auth.getUsername(),
					                                 auth.getPassword());
			auth.setStatus(true);
			auth.setMessage("authentification reussie");
			Client cli= login.getClient();
			//System.out.println("client="+cli);
			auth.setClient(cli);
		} catch (Exception e) {
			auth.setStatus(false);
			auth.setMessage("echec authentification");
		}
		return new ResponseEntity<Auth>(auth,HttpStatus.OK);
	}
	
	    //sera appelé en HTTP / POST avec l' URL suivante:
		// http://localhost:8080/flight_web/mvc/rest/clients/newLoginWithClient
		//with loginWithClient = { "username" : "toto" , "password": "pwd_toto" ,
	    // client =   { "nom": "Therieur",   "prenom": "alex",   "phoneNumber": "0102030405",
		//              "email": "alex-therieur@iciOulaBas.fr",
        //            "adresse": {   "rue": "rue 1",   
	    //                           "codePostal": "75001", "ville": "Paris" }
        //          }                      
	    // }
	    // En retour , meme structure avec les id en plus (auto_incr)
		@RequestMapping(value="/newLoginWithClient" , method=RequestMethod.POST)
		ResponseEntity<Login> ajouterCompteClientAvecLogin( @RequestBody Login loginWithClient ){
			try {
				Login login = loginWithClient;
				Client cli = login.getClient();
				serviceClient.insertClientWithLogin(cli, login);
				return new ResponseEntity<Login>(login,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Login>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	
}

