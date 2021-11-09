package DOM_RMIJO2;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;



public class DOMWrite_RMIJO2 {
    
	public static void main(String[] args) {
		
        Document doc;
		try{

			File xmlFile=new File("C:\\Users\\zofcs\\Documents\\GitHub\\RMIJO2_XmlGyak\\RMIJO2_XmlGyak\\DOMParser_RMIJO2\\src\\DOM_RMIJO2");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			doc =dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
		}catch(IOException e){
			e.printStackTrace();
		}catch(SAXException sae){
			sae.printStackTrace();
		}catch(ParserConfigurationException pce){
			pce.printStackTrace();
		}
        	
			Element root =doc.createElementNS("domkprlnb", "users");
			doc.appendChild(root);
            root.appendChild(createUser(doc,"1","Pal","Kiss","programozo"));
            root.appendChild(createUser(doc,"2","Piroska","Zold","writer"));
            root.appendChild(createUser(doc,"3","Alma","Gordon","teacher"));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transf = transformerFactory.newTransformer();
        
            transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transf.setOutputProperty(OutputKeys.INDENT, "yes");
            transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(doc);

            File myfFile = new File("users1.xml");

            StreamResult console = new StreamResult(System.out);
            StreamResult file =  new StreamResult(myfFile);

            transf.transform(source, console);
            transf.transform(source, file);

	}

    private static Node createUser(Document doc, String id, String fname, String lname, String pname) {
        Element user = doc.createElement("user");

        user.setAttribute("id", id);
        doc.appendChild(createUserElement())

        return null;
    }
   
}
