package com.alison.webservice.out.demo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.alison.webservice.out.demo package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _Method01_QNAME = new QName(
			"http://po.service.webservice.alison.com/", "method01");
	private final static QName _Method01Response_QNAME = new QName(
			"http://po.service.webservice.alison.com/", "method01Response");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.alison.webservice.out.demo
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link Method01Response }
	 * 
	 */
	public Method01Response createMethod01Response() {
		return new Method01Response();
	}

	/**
	 * Create an instance of {@link Method01 }
	 * 
	 */
	public Method01 createMethod01() {
		return new Method01();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Method01 }{@code
	 * >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://po.service.webservice.alison.com/", name = "method01")
	public JAXBElement<Method01> createMethod01(Method01 value) {
		return new JAXBElement<Method01>(_Method01_QNAME, Method01.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link Method01Response }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://po.service.webservice.alison.com/", name = "method01Response")
	public JAXBElement<Method01Response> createMethod01Response(
			Method01Response value) {
		return new JAXBElement<Method01Response>(_Method01Response_QNAME,
				Method01Response.class, null, value);
	}

}
