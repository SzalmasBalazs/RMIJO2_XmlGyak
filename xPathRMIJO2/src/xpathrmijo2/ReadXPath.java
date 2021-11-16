package xpathrmijo2;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ReadXPath {
   
   public static void main(String[] args) {
      
      try {
         File inputFile = new File("C:\\Users\\zofcs\\eclipse-workspace\\xPathRMIJO2\\src\\xpathrmijo2\\StudentRMIJO2.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder;

         dBuilder = dbFactory.newDocumentBuilder();

         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();

         XPath xPath =  XPathFactory.newInstance().newXPath();

         String expression = "/class/student";	        
         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
            doc, XPathConstants.NODESET);

         for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("Student ID :" + eElement.getAttribute("id"));
               System.out.println("Keresztnév : " 
                  + eElement
                  .getElementsByTagName("keresztnév")
                  .item(0)
                  .getTextContent());
               System.out.println("Vezetéknév : " 
                  + eElement
                  .getElementsByTagName("vezetéknév")
                  .item(0)
                  .getTextContent());
               System.out.println("Becenév : " 
                  + eElement
                  .getElementsByTagName("Becenév")
                  .item(0)
                  .getTextContent());
               System.out.println("Életkor : " 
                  + eElement
                  .getElementsByTagName("Kor")
                  .item(0)
                  .getTextContent());
            }
         }
      } catch (ParserConfigurationException e) {
         e.printStackTrace();
      } catch (SAXException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (XPathExpressionException e) {
         e.printStackTrace();
      }
   }
}