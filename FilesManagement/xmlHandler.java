package FilesManagement;

import java.io.File;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class xmlHandler {

	static Customer customer;
	static Aircraft aircraft;
	static Products prodObj = null;
	static Subscribe subscribe;
	static Publish publish;
	
  public static Customer xmlReader(String fileURL) {

	  try {

		  File file = new File(fileURL);

		  DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		  Document doc = dBuilder.parse(file);

		  if (doc.hasChildNodes()) {			  
			  printNote(doc.getChildNodes(), false);
			  aircraft.popProduct();
		  }
		  customer.setAircraft(aircraft);
		  System.out.println("Size Aircraft: "+aircraft.getProducts().size());
		  //System.out.println("Size Prod Subs: "+prodObj.getPublish().get(2));

		  
	  } catch (Exception e) {
		  System.out.println("Error: "+e.getMessage());
	  }
	  return customer;

  }

  private static void printNote(NodeList nodeList, boolean branch) {
	  
	  boolean productIDDef = branch;
	  
	  for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);
			
			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				
				// get node name and value
				//System.out.println("Node Name =" + tempNode.getNodeName() + " [OPEN] ");

				String nodeName = tempNode.getNodeName();
				
				if(count == 0 && !tempNode.hasAttributes()){
					customer = new Customer();
				}
				
				if(count == 1 && !tempNode.hasAttributes()){
					aircraft = new Aircraft();
				}
				
				if (tempNode.hasAttributes()) {

					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();
					
					if(nodeMap.getLength() == 1){
						Node node = nodeMap.item(0);

						if(node.getNodeName().equals("ProductID")){

							prodObj = new Products();
							prodObj.setProductID(Integer.parseInt(node.getNodeValue()));

						}
					}else if(nodeName.equals("Subscribe")){
						
						Subscribe subObj = new Subscribe();

							for (int i = 0; i < nodeMap.getLength(); i++) {
								Node node = nodeMap.item(i);
								String nodeAttname = node.getNodeName();
								String nodeAttvalue = node.getNodeValue();
								SettingSubscriberAtts(subObj, nodeAttname, nodeAttvalue);	
							}

						prodObj.setSubscribe(subObj);
						
					}else if(nodeName.equals("Publish")){
						Publish pubObj = new Publish();
						for (int i = 0; i < nodeMap.getLength(); i++) {

							Node node = nodeMap.item(i);
							String nodeAttname = node.getNodeName();
							String nodeAttvalue = node.getNodeValue();
							settingPublishAtts(pubObj, nodeAttname, nodeAttvalue);

						}
						prodObj.setPublish(pubObj);
					}

				}

				if (tempNode.hasChildNodes()) {
					printNote(tempNode.getChildNodes(), true);
				}
				else{
					productIDDef = false;
				}
				//System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
				//System.out.println("Size Prod Subscribe: " + prodObj.getSubscribe().size());	
				//System.out.println("Size Prod Publish: " + prodObj.getPublish().size());	
			}
			
		
	  }  
	  
	  if(!productIDDef){
		  aircraft.setProducts(prodObj);
		  }
  }

  private static void SettingSubscriberAtts(Subscribe subscribe, String nodeName, String nodeValue){
	  //System.out.println("Setting Subscriber values");
	 switch (nodeName){
		  case "Name":
			  subscribe.setName(nodeValue);
			  break;
		  case "Origin":
			  subscribe.setOrigin(nodeValue);
			  break;
		  case "Type":
			  subscribe.setType(nodeValue);
			  break;
		  case "Max":
			  subscribe.setMax(nodeValue);
			  break;
		  case "Min":
			  subscribe.setMin(nodeValue);
			  break;
		  case "Default":
			  subscribe.setDefault(nodeValue);
			  break;
		  default:
			System.out.println("Subscribe - No case for: " + nodeName + " value: " + nodeValue);
			  break;	  
	  }
	  
  }
  
  private static void settingPublishAtts(Publish publish, String nodeName, String nodeValue){
	  //System.out.println("Setting Publish values");
	  switch (nodeName){
	  case "Name":
		  publish.setName(nodeValue);
		  break;
	  case "Type":
		  publish.setType(nodeValue);
		  break;
	  case "Default":
		  publish.setDefault(nodeValue);
		  break;
	  case "Max":
		  publish.setMax(nodeValue);
		  break;
	  case "Min":
		  publish.setMin(nodeValue);
		  break;
	  case "Operation":
		  publish.setOperation(nodeValue);
		  break;
	  case "Operand1":
		  publish.setOperand1(nodeValue);
		  break;
	  case "Operand2":
		  publish.setOperand2(nodeValue);
		  break;
	  case "Operand3":
		  publish.setOperand3(nodeValue);
		  break;
	  default:
		System.out.println("PUBLISH - No case for: " + nodeName + " value: " + nodeValue);
		  break;
			  
  }
	  
	  
  }
  
}