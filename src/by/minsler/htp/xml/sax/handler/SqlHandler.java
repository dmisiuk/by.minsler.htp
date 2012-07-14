package by.minsler.htp.xml.sax.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.minsler.htp.xml.SqlConfig;

public class SqlHandler extends DefaultHandler {

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		String value = attributes.getValue("value");
		SqlConfig.getPrefereces().put(qName, value);
	}

}
