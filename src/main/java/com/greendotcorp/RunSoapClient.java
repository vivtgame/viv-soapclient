package com.greendotcorp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greendotcorp.wsdl.GetAccountResponse;

public class RunSoapClient {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	    ctx.register(ClientAppConfig.class);
	    ctx.refresh();
		AccountClient accountClient = ctx.getBean(AccountClient.class);
		System.out.println("For Account Id: 1");
		GetAccountResponse response = accountClient.getAccountById(1);
		System.out.println("Name:"+response.getAccount().getName());
		System.out.println("Age:"+response.getAccount().getAge());
		System.out.println("Title:"+response.getAccount().getTitle());
	}
}
