package com.coboo.init;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.coboo.base.Bean_BaseInfo;



public class SystemConfiguration {
	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	Element theBook = null; 
	Element theElem = null;
	Element root = null;
	Document xmldoc = null;
	
	
	public SystemConfiguration(String path) {
		
		try {
			String catalogPath = path+"catalog.xml";
			
			String webappsPath = path.substring(0, path.indexOf("webapps")+8);
			
		
				
			factory.setIgnoringElementContentWhitespace(true);
			
			DocumentBuilder db = factory.newDocumentBuilder();
			xmldoc = db.parse(new File(catalogPath));
			root = xmldoc.getDocumentElement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getConfiguration() {
		
		theBook = (Element) selectSingleNode("/Servers/jkda", root);
		
		Bean_BaseInfo.webappsdir = theBook.getElementsByTagName("webappsdir").item(0).getTextContent().toString();
		Bean_BaseInfo.coboodir = theBook.getElementsByTagName("coboodir").item(0).getTextContent().toString();
		Bean_BaseInfo.httpUrl = theBook.getElementsByTagName("httpUrl").item(0).getTextContent().toString();
		Bean_BaseInfo.project = theBook.getElementsByTagName("project").item(0).getTextContent().toString();
		Bean_BaseInfo.indexdir = theBook.getElementsByTagName("indexdir").item(0).getTextContent().toString();
		Bean_BaseInfo.indexdir_2nd = theBook.getElementsByTagName("indexdir_2nd").item(0).getTextContent().toString();
		Bean_BaseInfo.index = theBook.getElementsByTagName("index").item(0).getTextContent().toString();
		Bean_BaseInfo.daurl = theBook.getElementsByTagName("daurl").item(0).getTextContent().toString();
		Bean_BaseInfo.template = theBook.getElementsByTagName("template").item(0).getTextContent().toString();
		Bean_BaseInfo.daemon = theBook.getElementsByTagName("daemon").item(0).getTextContent().toString();
		Bean_BaseInfo.formworkOfPrint = theBook.getElementsByTagName("formworkOfPrint").item(0).getTextContent().toString();
		Bean_BaseInfo.printUrl = theBook.getElementsByTagName("printurl").item(0).getTextContent().toString();
		Bean_BaseInfo.LockForPrint = theBook.getElementsByTagName("lockdir").item(0).getTextContent().toString();
		
		System.out.println("webappsdir=" + Bean_BaseInfo.webappsdir);
		System.out.println("coboodir=" + Bean_BaseInfo.coboodir);
		System.out.println("httpUrl=" + Bean_BaseInfo.httpUrl);
		System.out.println("project=" + Bean_BaseInfo.project);
		System.out.println("indexdir=" + Bean_BaseInfo.indexdir);
		System.out.println("indexdir_2nd=" + Bean_BaseInfo.indexdir_2nd);
		System.out.println("index=" + Bean_BaseInfo.index);
		System.out.println("daurl=" + Bean_BaseInfo.daurl);
		System.out.println("template=" + Bean_BaseInfo.template);
		System.out.println("daemon=" + Bean_BaseInfo.daemon);
		System.out.println("formworkOfPrint=" + Bean_BaseInfo.formworkOfPrint);
		System.out.println("printUrl=" + Bean_BaseInfo.printUrl);
		System.out.println("LockForPrint=" + Bean_BaseInfo.LockForPrint);
		System.out.println("replacePath=" + Bean_BaseInfo.replacePath);
	//	Bean_BaseInfo.sKey = KeyManager.GetKey();
	//	Bean_BaseInfo.ps.start();
	//	OperLucene.openReader(true);
	}
	
	/**
	 * 查找节点，并返回第一个符合条件节点
	 */
	public Node selectSingleNode(String express, Object source) {
		
		Node result = null;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		try {
			result = (Node) xpath.evaluate(express, source, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return result;
	}
}
