package com.alison.xml;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Foo {
	private static Foo instance;

	private Foo() {
	}

	public static synchronized Foo getInstance() {
		if (instance == null) {
			instance = new Foo();
		}
		return instance;
	}

	private String xmlFile = "http://com/alison/xml/test.xml";

	// Parsing XML
	public Document parse(URL url) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(url);
		return document;
	}

	// Using Iterators
	@SuppressWarnings("unchecked")
	public void bar(Document document) throws DocumentException {
		Element root = document.getRootElement();
		// iterate through child elements of root
		for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
			Element element = it.next();
			// do something
		}
		// iterate through child elements of root with element name "foo"
		for (Iterator<Element> it = root.elementIterator("foo"); it.hasNext();) {
			Element foo = it.next();
			// do something
		}
		// iteraotr through attributes of root
		for (Iterator<Attribute> it = root.attributeIterator(); it.hasNext();) {
			Attribute attribute = it.next();
			// do something
		}

	}

	// Powerful Navigation with XPath
	public void bar1(Document document) {
		// selectnodes("xpath")
		List<Node> list = document.selectNodes("//foo/bar");
		Node node = document.selectSingleNode("//foo/bar/author");
		String name = node.valueOf("@name");
	}

	public void findLinks(Document document) throws DocumentException {

		List<Node> list = document.selectNodes("//a/@href");

		for (Iterator<Node> iter = list.iterator(); iter.hasNext();) {
			Attribute attribute = (Attribute) iter.next();
			String url = attribute.getValue();
		}
	}
}
