package com.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


public class ConfigXML {

	@SuppressWarnings("unchecked")
	public static List readXMLFile(String inFile) throws Exception {
		//	�õ�DOM�������Ĺ���ʵ��
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			// ��DOM�������DOM������
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException pce) {
			System.err.println(pce); 
			return null;
		}

		Document doc = null;
		try {
			// ����XML�ĵ������������õ�һ��Document
			doc = db.parse(inFile);
			// ��document�������normalize()������ȥ��xml�ĵ�����Ϊ��ʽ�����ݵĿհף�
			// ��������Щ�հ�ӳ����dom���г�Ϊ����Ҫ��text node����
			// ������õ���dom�����ܲ��������������������
			// �ر����������ʱ�����normalize()��Ϊ���á� 
			doc.normalize();
		} catch (DOMException dom) {
			System.err.println(dom.getMessage());
			return null;
		} catch (IOException ioe) {
			System.err.println(ioe);
			return null;
		}

		List configBeans = new ArrayList();
		ConfigBean studentBean = null;
		//	�õ�XML�ĵ��ĸ��ڵ�
		Element root = doc.getDocumentElement();
		//	ȡ"������"Ԫ���б�
		NodeList configs = root.getElementsByTagName("������");
		for (int i = 0; i < configs.getLength(); i++) {
			//	����ȡÿ��"ѧ��"Ԫ��
			Element config = (Element) configs.item(i);
			//	����һ��ѧ����Beanʵ��
			studentBean = new ConfigBean();
			//	ȡ������������
			studentBean.setName(config.getAttribute("����"));
			
			//	ȡ��url��Ԫ��
			NodeList names = config.getElementsByTagName("url");
			if (names.getLength() == 1) {
				Element e = (Element) names.item(0);
				// ȡ����Ԫ�صĵ�һ���ӽڵ㣬��Ϊ������ֵ�ڵ�
				Text t = (Text) e.getFirstChild();
				// ��ȡֵ�ڵ��ֵ
				studentBean.setUrl(t.getNodeValue());
			}

			// ���½���Bean�ӵ�����б���
			configBeans.add(studentBean);
		}
		// ���ؽ���б�
		return configBeans;
	}

}