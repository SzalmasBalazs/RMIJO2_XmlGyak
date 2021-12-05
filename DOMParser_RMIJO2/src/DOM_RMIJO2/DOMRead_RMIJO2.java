package DOM_RMIJO2;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

public class DOMRead_RMIJO2 {

	public static void main(String[] args) {
		
		try{
			File xmlFile=new File("C:\\Users\\zofcs\\Documents\\GitHub\\RMIJO2_XmlGyak\\RMIJO2_XmlGyak\\DOMParser_RMIJO2\\src\\DOM_RMIJO2");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document doc =dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element:"+doc.getDocumentElement().getNodeName());
			
			ReadCurrentElement(doc);
		}catch(IOException e){
			e.printStackTrace();
		}catch(SAXException sae){
			sae.printStackTrace();
		}catch(ParserConfigurationException pce){
			pce.printStackTrace();
		}

	}

	private static void ReadCurrentElement(Document doc) {
		NodeList NodeList = doc.getElementsByTagName("user");
		for(int i = 0; i < NodeList.getLength();i++){
			Node nNode= NodeList.item(i);
			Element element =(Element)nNode;

			Node node0 = element.getElementsByTagName("id").item(0);
			String uid = node0.getTextContent();

			Node node1 = element.getElementsByTagName("first_name").item(0);
			String fname = node1.getTextContent();

			Node node2 = element.getElementsByTagName("last_name").item(0);
			String lname = node2.getTextContent();

			Node node3 = element.getElementsByTagName("profession").item(0);
			String pname = node3.getTextContent();

			System.out.println("User id:"+uid);
			System.out.println("First name: "+fname);
			System.out.println("Last name: "+lname);
			System.out.println("Profession: "+pname);
		}

	}

}
