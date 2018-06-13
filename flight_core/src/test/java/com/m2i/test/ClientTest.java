package com.m2i.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.entity.Client;
import com.m2i.entity.Login;
import com.m2i.service.IServiceClient;

@RunWith(SpringJUnit4ClassRunner.class)//necessite spring-test dans pom.xml
@ContextConfiguration(locations={"/beans.xml"}) //charge qu'une seule fois!!!
public class ClientTest {
	
	@Autowired //@Autowired est equivalent a context.getBean(ServiceClient.class);
	private  IServiceClient serviceClient; //a tester

	
	@Test
	public void testRechercherClient(){
		Client c = serviceClient.rechercherClient(1L);
		Assert.assertTrue(c.getId()==1L);
		System.out.println(c);
	}
	
	
	@Test
	public void testRechercherClientByName(){
		List<Client> listeCli = serviceClient.findClientByName("Therieur");
		Assert.assertTrue(listeCli.size()>0);
	}
	
	@Test
	public void testValidInsertClientWithLogin(){
		Client nouveauClient = new Client(null,"nomXx", "prenomYy");
		Login nouveauLogin = new Login(null,"usernameXx","passwordYy");
		Client savedClientWithSavedLogin = 
				serviceClient.insertClientWithLogin(nouveauClient, nouveauLogin);
		Assert.assertNotNull(savedClientWithSavedLogin);
		Long nouvelId = savedClientWithSavedLogin.getId();
		Client client = serviceClient.rechercherClient(nouvelId);
		Assert.assertEquals(client.getLogin().getUsername(),"usernameXx");
		Assert.assertEquals(client.getLogin().getPassword(),"passwordYy");
		//affichage temporaire ou exceptionnel (tp):
		System.out.println("nouveau client: " + client + " avec login: "
		                           + client.getLogin());
		//suppression a la fin pour pouvoir relancer le test plusieurs fois:
		serviceClient.supprimerClientWithLogin(nouvelId);
	}
	
	@Test
	public void testInValidInsertClientWithLogin(){
		Client nouveauClient = new Client(null,"nomXx", "prenomYy");
		Login nouveauLogin = new Login(null,"alex-therieur","passwordYy"); //invalide car username deja en base et devant etre unique
		try{
		    Client savedClientWithSavedLogin =
		    		serviceClient.insertClientWithLogin(nouveauClient, nouveauLogin);
		    Assert.fail("une exception aurait du remonter");
		} catch(Exception ex){
			System.err.println("exception normale:" + ex.getMessage());   
		}
		
		Long nouvelId = nouveauClient.getId(); //savedClientWithSavedLogin.getId();
		Client client = serviceClient.rechercherClient(nouvelId);
		if(client !=null){
			//affichage temporaire ou exceptionnel (tp):
			System.out.println("nouveau client: " + client + " avec login: " 
			                                    + client.getLogin());
			//suppression a la fin pour pouvoir relancer le test plusieurs fois:
			serviceClient.supprimerClientWithLogin(nouvelId);
			Assert.fail("comportement non transactionnel " 
					+" (action partielle enregistree en base)");
		}
	}
	
	@Test
	public void testLoginByUsernameAndPassword(){
		Login login = serviceClient.loginByUsernameAndPassword("alex-therieur", "pwd007");
		Assert.assertTrue(login!=null);
		System.out.println("testLoginByUsernameAndPassword, login= " + login );
		Assert.assertTrue(login.getClient()!=null);
		System.out.println("testLoginByUsernameAndPassword, client= " + login.getClient() );
		
	}

	
	
}
