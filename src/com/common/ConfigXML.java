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
		//	得到DOM解析器的工厂实例
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			// 从DOM工厂获得DOM解析器
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException pce) {
			System.err.println(pce); 
			return null;
		}

		Document doc = null;
		try {
			// 解析XML文档的输入流，得到一个Document
			doc = db.parse(inFile);
			// 对document对象调用normalize()，可以去掉xml文档中作为格式化内容的空白，
			// 避免了这些空白映射在dom树中成为不必要的text node对象。
			// 否则你得到的dom树可能并不是你所想象的那样。
			// 特别是在输出的时候，这个normalize()更为有用。 
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
		//	得到XML文档的根节点
		Element root = doc.getDocumentElement();
		//	取"服务器"元素列表
		NodeList configs = root.getElementsByTagName("服务器");
		for (int i = 0; i < configs.getLength(); i++) {
			//	依次取每个"学生"元素
			Element config = (Element) configs.item(i);
			//	创建一个学生的Bean实例
			studentBean = new ConfigBean();
			//	取服务器的名称
			studentBean.setName(config.getAttribute("名称"));
			
			//	取“url”元素
			NodeList names = config.getElementsByTagName("url");
			if (names.getLength() == 1) {
				Element e = (Element) names.item(0);
				// 取姓名元素的第一个子节点，即为姓名的值节点
				Text t = (Text) e.getFirstChild();
				// 获取值节点的值
				studentBean.setUrl(t.getNodeValue());
			}

			// 将新建的Bean加到结果列表中
			configBeans.add(studentBean);
		}
		// 返回结果列表
		return configBeans;
	}

}