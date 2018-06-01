package com.m2i.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.entity.Localite;
import com.m2i.entity.Vol;
import com.m2i.service.IServiceResa;
import com.m2i.util.MyDateTimeUtil;

@RunWith(SpringJUnit4ClassRunner.class)//necessite spring-test dans pom.xml
@ContextConfiguration(locations={"/beans.xml"}) //charge qu'une seule fois!!!
public class ResaTest {
	
	@Autowired //@Autowired est equivalent a context.getBean(ServiceResa.class);
	private  IServiceResa serviceResa; //a tester

	
	@Test
	public void testQuiVaBien(){
		//....
	}
	
	
}
