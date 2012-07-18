package by.minsler.htp.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

	public static void main(String[] args) {

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		builderFactory.setIgnoringComments(true);
		builderFactory.setIgnoringElementContentWhitespace(true);

		DocumentBuilder builder = null;
		Document document = null;

		File file = new File("src/nextlist.xml");

		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		try {
			document = builder.parse(file);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Element root = document.getDocumentElement();
		NodeList nodeList = root.getChildNodes();

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element point = (Element) node;
				String unit = point.getAttribute("unit");
				NodeList xList = point.getElementsByTagName("x");
				NodeList yList = point.getElementsByTagName("y");
				Element xElement = (Element) xList.item(0);
				Element yElement = (Element) yList.item(0);
				System.out.println(xElement.getChildNodes().item(0)
						.getNodeValue()
						+ unit
						+ ", "
						+ yElement.getChildNodes().item(0).getNodeValue()
						+ unit);
			}
		}

		System.out.println("IN HTML");
		File stylesheet = new File("trans.xsl");
		StreamSource styleSource = new StreamSource(stylesheet);
		try {
			Transformer t = TransformerFactory.newInstance().newTransformer(
					styleSource);
			t.transform(new DOMSource(document.getDocumentElement()),
					new StreamResult(System.out));
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
