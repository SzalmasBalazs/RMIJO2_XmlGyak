package saxRMIJO2;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class PrintAllHandlerSax extends DefaultHandler {

	 private StringBuilder currentValue = new StringBuilder();

	  @Override
	  public void startDocument() {
	      System.out.println("Start Document");
	  }

	  @Override
	  public void endDocument() {
	      System.out.println("End Document");
	  }

	  @Override
	  public void startElement(
	          String uri,
	          String localName,
	          String qName,
	          Attributes attributes) {

	      // reset the tag value
	      currentValue.setLength(0);

	      System.out.printf("Start Element : %s%n", qName);

	      if (qName.equalsIgnoreCase("person")) {
	          // get tag's attribute by name
	          String id = attributes.getValue("id");
	          System.out.printf("Persons id: %s%n", id);
	      }

	      if (qName.equalsIgnoreCase("age")) {
	          // get tag's attribute by index, 0 = first attribute
	          String age = attributes.getValue(0);
	          System.out.printf("Age: %s%n", age);
	      }

	  }

	  @Override
	  public void endElement(String uri,
	                         String localName,
	                         String qName) {

	      System.out.printf("End Element: %s%n", qName);

	      if (qName.equalsIgnoreCase("name")) {
	          System.out.printf("Name: %s%n", currentValue.toString());
	      }

	      if (qName.equalsIgnoreCase("age")) {
	          System.out.printf("Age: %s%n", currentValue.toString());
	      }

	      if (qName.equalsIgnoreCase("city")) {
	          System.out.printf("City: %s%n", currentValue.toString());
	      }

	  }
	  
	  @Override
	  public void characters(char ch[], int start, int length) {
	      currentValue.append(ch, start, length);

	  }

}
