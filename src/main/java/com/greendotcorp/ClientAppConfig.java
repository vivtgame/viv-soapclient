package com.greendotcorp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ClientAppConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.greendotcorp.wsdl");
		return marshaller;
	}
	@Bean
	public AccountClient accountClient(Jaxb2Marshaller marshaller) {
		AccountClient client = new AccountClient();
		client.setDefaultUri("http://localhost:8082/spring4soap-1/soapws/accounts.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
