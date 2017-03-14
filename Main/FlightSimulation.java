package Main;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

import FilesManagement.Products;
import FilesManagement.Publish;
import FilesManagement.Subscribe;
import Factory.PublishIterator;
import Factory.SubscribeIterator;
import FilesManagement.Customer;
import FilesManagement.xmlHandler;
import TxtHandler.Flight_Phase;
import TxtHandler.TxtHandlerClass;

public class FlightSimulation {

	static xmlHandler xmlReader;
	static Customer customer = null;
	static TxtHandlerClass txtReader;
	static Flight_Phase testObj;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int selectedValue = j.showSaveDialog(j);
		
		if(selectedValue == JFileChooser.APPROVE_OPTION){
			//System.out.println(j.getSelectedFile());
			String fileURL = null;
			
			File dir = new File(j.getSelectedFile().getAbsolutePath());
			File[] listOfFiles = dir.listFiles();
			
			String fixedPath = dir.getAbsolutePath().replace("\\", "/");
			
			for (File file : listOfFiles) {
				 if (file.isFile()&&(file.getName().substring(file.getName().lastIndexOf('.')+1).equals("xml"))) {
				   // Scanner
					 
					 fileURL = fixedPath+"/"+file.getName();
					 xmlReader = new xmlHandler();
					 System.out.print(file.getName()+" ");
					 customer = xmlHandler.xmlReader(fileURL);
				  }
				 if (file.isFile()&&(file.getName().substring(file.getName().lastIndexOf('.')+1).equals("txt"))) {
					 // Code to be adapted to run txt object creation
					 
					 fileURL = fixedPath+"/"+file.getName();
					 System.out.print(file.getName()+" ");
					 txtReader = new TxtHandlerClass();
					 testObj = txtReader.txtReader(fileURL);
					 
				 }else{
					 System.out.println("No valid files");
				 }
			}
			
			
			for(int i=0; i<customer.getAircraft().get(0).getProducts().size();i++)
			{
				Products productRepository = customer.getAircraft().get(0).getProducts().get(i);
				System.out.println("Product : " + productRepository.getProductID());
				for(SubscribeIterator iter = productRepository.getSubscribeIterator(); iter.hasNext();){
					Subscribe S = (Subscribe) iter.next();;
			        System.out.println("Subscribe Name : " + S.getName());
			      } 
				for(PublishIterator iter = productRepository.getPublishIterator(); iter.hasNext();){
					Publish P = (Publish) iter.next();;
			        System.out.println("Publish Name : " + P.getName());
			      } 
			}			
			
		}else{
			System.out.println("Please execute the application to select a FOLDER...");
		}

	}
	
}
