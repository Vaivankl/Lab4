package com.example.madt1116;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlParser {
    public static ArrayList<String> getAllRatesFromECB(InputStream stream) throws IOException {
        String result = "";
        ArrayList<String> rateslist;
        rateslist = new ArrayList<String>();
        try {
            DocumentBuilderFactory xmlDocFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder xmlDocBuilder = xmlDocFactory.newDocumentBuilder();
            Document doc = xmlDocBuilder.parse(stream);


            NodeList rateNodes = doc.getElementsByTagName(Constants.CUBE_NODE);
            for (int i = 0; i < rateNodes.getLength(); ++i) {
                Element cube = (Element) rateNodes.item(i);
                if(cube.hasAttribute("currency")){
                    String currencyName = cube.getAttribute("currency");
                    {
                        result = "Currency: "+ currencyName + " current rate is "+ cube.getAttribute("rate");
                        rateslist.add(result);
                        break;
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return rateslist;
    }
}
