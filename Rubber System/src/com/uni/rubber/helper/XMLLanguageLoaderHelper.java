package com.uni.rubber.helper;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import com.uni.rubber.properties.Properties;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class XMLLanguageLoaderHelper {

	public static Map<String, String> XMLLanguageLoaderHelperReader(String[] elements) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			File fXmlFile = new File("rsrc/xml/Languages.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("language");
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (((Element) nNode).getAttribute("id").equals(Properties.LANGUAGE)) {
					for (String str : elements) {
						map.put(str, getNodeValue(str, nNode));
					}
				}
				// map.put("title", getNodeValue("title", nNode));
				// map.put("userLabel", getNodeValue("userLabel", nNode));
				// map.put("passwordLabel", getNodeValue("passwordLabel",
				// nNode));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	private static String getNodeValue(String name, Node nNode) {
		String nodeValue = null;
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			NodeList nl = eElement.getElementsByTagName(name);
			if (nl != null && nl.getLength() > 0) {
				Element el = (Element) nl.item(0);
				System.out.println(name + " : " + el.getFirstChild().getNodeValue());
				nodeValue = el.getFirstChild().getNodeValue();
			}
		}
		return nodeValue;
	}
}
