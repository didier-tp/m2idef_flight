package com.m2i.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.entity.Resa;
import com.m2i.service.IServiceResa;

@RunWith(SpringJUnit4ClassRunner.class)//necessite spring-test dans pom.xml
@ContextConfiguration(locations={"/beans.xml"}) //charge qu'une seule fois!!!
public class ResaTest {
	
	@Autowired //@Autowired est equivalent a context.getBean(ServiceResa.class);
	private  IServiceResa serviceResa; //a tester

	
	@Test
	public void testQuiVaBien(){
		Resa resa = serviceResa.nouvelleResa(2L, 3L);
		Resa resaRelu = serviceResa.rechercherResaById(resa.getIdResa());
		System.out.println("nouvelle resa: " + resaRelu);
		System.out.println("vol de nouvelle resa: " + resaRelu.getVol());
		System.out.println("client de nouvelle resa: " + resaRelu.getClient());
	}
	
	
}
