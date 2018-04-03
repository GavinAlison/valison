package com.alison.webservice.out.Jws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * <p>
 * An example of how this class may be used:
 * 
 * <pre>
 * JwsServiceHelloService service = new JwsServiceHelloService();
 * JwsServiceHello portType = service.getJwsServiceHelloPort();
 * portType.getValue(...);
 * </pre>
 * 
 * </p>
 * 
 */
@WebServiceClient(name = "JwsServiceHelloService", targetNamespace = "http://impl.service.webservice.alison.com/", wsdlLocation = "http://localhost:8080/Service/JwsServiceHello?wsdl")
public class JwsServiceHelloService extends Service {

	private final static URL JWSSERVICEHELLOSERVICE_WSDL_LOCATION;
	private final static Logger logger = Logger
			.getLogger(com.alison.webservice.out.Jws.JwsServiceHelloService.class
					.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = com.alison.webservice.out.Jws.JwsServiceHelloService.class
					.getResource(".");
			url = new URL(baseUrl,
					"http://localhost:8080/Service/JwsServiceHello?wsdl");
		} catch (MalformedURLException e) {
			logger
					.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/Service/JwsServiceHello?wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		JWSSERVICEHELLOSERVICE_WSDL_LOCATION = url;
	}

	public JwsServiceHelloService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public JwsServiceHelloService() {
		super(JWSSERVICEHELLOSERVICE_WSDL_LOCATION, new QName(
				"http://impl.service.webservice.alison.com/",
				"JwsServiceHelloService"));
	}

	/**
	 * 
	 * @return returns JwsServiceHello
	 */
	@WebEndpoint(name = "JwsServiceHelloPort")
	public JwsServiceHello getJwsServiceHelloPort() {
		return super.getPort(new QName(
				"http://impl.service.webservice.alison.com/",
				"JwsServiceHelloPort"), JwsServiceHello.class);
	}

}