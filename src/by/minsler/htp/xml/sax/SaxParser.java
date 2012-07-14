package by.minsler.htp.xml.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import by.minsler.htp.xml.SqlConfig;
import by.minsler.htp.xml.sax.handler.SqlHandler;

public class SaxParser {

	public static void main(String[] args) {

		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxFactory.newSAXParser();
			saxParser.parse("configsql.xml", new SqlHandler());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("file not found");
		}

		System.out.println(SqlConfig.getInstance().getPrefereces());
	}
}
