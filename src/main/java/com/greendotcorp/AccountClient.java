package com.greendotcorp;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.greendotcorp.wsdl.GetAccountRequest;
import com.greendotcorp.wsdl.GetAccountResponse;

public class AccountClient extends WebServiceGatewaySupport  {
	public GetAccountResponse getAccountById(int accountId) {
		GetAccountRequest request = new GetAccountRequest();
		request.setAccountId(accountId);
		GetAccountResponse response = (GetAccountResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8082/spring4soap-1/soapws/getAccountResponse"));
		return response;
	}
}
