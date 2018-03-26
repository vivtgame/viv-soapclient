package com.greendotcorp.soap.test;

import com.greendotcorp.AccountClient;
import com.greendotcorp.ClientAppConfig;

import junit.framework.TestCase;

import com.greendotcorp.wsdl.GetAccountResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@ContextConfiguration(locations = { "classpath:testng.xml" })
public class TestAPIs extends TestCase  {


	public void testGetAccount() {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	    ctx.register(ClientAppConfig.class);
	    ctx.refresh();
		AccountClient accountClient = ctx.getBean(AccountClient.class);
		System.out.println("For Account Id: 1");
		GetAccountResponse response = accountClient.getAccountById(1);
		System.out.println("Name:"+response.getAccount().getName());
		System.out.println("Age:"+response.getAccount().getAge());
		System.out.println("Title:"+response.getAccount().getTitle());
		
		assertEquals(response.getAccount().getName(), "Vivian Wu");
		assertEquals(response.getAccount().getAge(), 23);
		assertEquals(response.getAccount().getTitle(), "PE");

	}

}