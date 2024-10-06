package com.example.SoapClient;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

import com.wsdlfirst.EmpDataWsImplService;
import com.wsdlfirst.sample.EmpDataPortType;
import com.wsdlfirst.sample.GetEmployeeRequest;
import com.wsdlfirst.sample.GetEmployeeResponse;

public class EmpServiceSoapClient {

	public static void main(String[] args) throws MalformedURLException {
		EmpDataWsImplService service = new EmpDataWsImplService(
				new URL("http://localhost:8080/services/empDataService?wsdl"));
		EmpDataPortType empDataPort = service.getEmpDataWsImplPort();
		GetEmployeeRequest request = new GetEmployeeRequest();
		request.setEmpId(new BigInteger("111"));
		GetEmployeeResponse response = empDataPort.getEmpData(request);
		System.out.println(response.getEmployeeData().size());
	}

}
