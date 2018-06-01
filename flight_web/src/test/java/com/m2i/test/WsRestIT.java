package com.m2i.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.m2i.entity.Vol;

/*
 * cette classe à un nom qui commence ou se termine par IT (et par par Test)
 * car c'est un Test d'Integration qui ne fonctionne que lorque Tomcat est démarré
 */
public class WsRestIT {
	
	private static Logger logger = LoggerFactory.getLogger(WsRestIT.class);
	
	private static RestTemplate restTemplate; //objet technique fourni par Spring tester WS REST
	
	//pas de @Autowired ni de @RunWith , @ContextConfiguration
	//car ce test EXTERNE est censé tester le WebService sans connaître sa structure interne
	// (test BOITE_NOIRE)
	@BeforeClass
	public static void init(){
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void testListeComptesDuClient(){
		final String villeDepart = "Paris";
		final String dateDepart = "2018-09-20";
	    final String uri = "http://localhost:8080/flight_web/mvc/rest/vols/byCriteria"
	    		+"?villeDepart=" + villeDepart + "&dateDepart=" + dateDepart;
	    String resultAsJsonString = restTemplate.getForObject(uri, String.class);
	    logger.info("json listeVols via rest: " + resultAsJsonString);
	    Vol[] tabVols = restTemplate.getForObject(uri,Vol[].class);
	    logger.info("java listeComptes via rest: "  +tabVols.toString());
	    Assert.assertNotNull(tabVols);   Assert.assertTrue(tabVols.length>=0);
	    for(Vol cpt : tabVols){
	    	System.out.println("\t" + cpt.toString());
	    }
	}
	
	/*
	@Test
	public void testVirement(){
		 final String uri = "http://localhost:8080/tpSpringWeb/mvc/rest/compte/virement";
		    //post/envoi:
		    OrdreVirement ordreVirement = new OrdreVirement();
		    ordreVirement.setMontant(50.0);
		    ordreVirement.setNumCptDeb(1L);
		    ordreVirement.setNumCptCred(2L);
		    OrdreVirement savedOrdreVirement =
		    		restTemplate.postForObject(uri, ordreVirement, OrdreVirement.class);
		    logger.info("savedOrdreVirement via rest: " + savedOrdreVirement.toString());
		    Assert.assertTrue(savedOrdreVirement.getOk().equals(true));
	}*/

}
