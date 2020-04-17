package com.healthcare.gatewayDeatils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class IpDetailsClass {

	private final String filename = "Ipdetails.xml";
	private final String filePath = "C:\\PAF";
	
	
	private IpDetails ReadCode() throws Exception {
		File file = new File(filePath);
		
		if (file.isDirectory()) {
			File ipAddress = new File(filePath + "\\" + filename);
			if (ipAddress.exists() && ipAddress.isFile()) {
				return this.IPXMLREADER(ipAddress);
			}
			else {
				return this.IPXMLREADER(LOAD_FROM_RES(filename));
			}
		}
		else {
			return this.IPXMLREADER(LOAD_FROM_RES(filename));
		}
	}
	
	
	private final IpDetails IPXMLREADER(File XML) {
		try {
			if (XML.isFile()) {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = (Document) db.parse(XML);
				doc.getDocumentElement().normalize();
				NodeList nodeList = doc.getElementsByTagName("ip");
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						
						Element element = (Element) node;
						IpDetails ipDetails = new IpDetails();
						
						ipDetails.setDocIP(element.getElementsByTagName("doctor").item(0).getTextContent());
						ipDetails.setUserIP(element.getElementsByTagName("user").item(0).getTextContent());
						ipDetails.setLabIP(element.getElementsByTagName("lab").item(0).getTextContent());
						ipDetails.setPaymentIP(element.getElementsByTagName("payment").item(0).getTextContent());
						ipDetails.setHospitalIP(element.getElementsByTagName("hospital").item(0).getTextContent());
						ipDetails.setAppoimentIP(element.getElementsByTagName("appoiment").item(0).getTextContent());
						ipDetails.setGatewayIP(element.getElementsByTagName("gateway").item(0).getTextContent());
						
						return ipDetails;
					}
				}
			}
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IpDetails ipDetails = new IpDetails();
		return ipDetails;	
	}
	
	public IpDetails getIpDetails() {
		try {
			return ReadCode();
		} catch (Exception e) {
			IpDetails ipDetails = new IpDetails();
			e.printStackTrace();
			return ipDetails;
		}
	}
	
	private final File LOAD_FROM_RES(String fileString) {
		ClassLoader classLoader = new IpDetailsClass().getClass().getClassLoader();
		File XML = new File(classLoader.getResource(fileString).getFile());
		return XML;
	}
}
