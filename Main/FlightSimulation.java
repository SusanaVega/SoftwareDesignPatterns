package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import FilesManagement.Products;
import FilesManagement.Publish;
import FilesManagement.Subscribe;
import FilesManagement.Customer;
import FilesManagement.xmlHandler;
import TxtHandler.Flight_Phase;
import TxtHandler.TxtHandlerClass;
import factory.TestProcedure;
import factory.TestProcedureFactory;
import iterator.PublishIterator;
import iterator.SubscribeIterator;

public class FlightSimulation {

	static xmlHandler xmlReader;
	static Customer customer = null;
	static TxtHandlerClass txtReader;
	static ArrayList<Flight_Phase> testObj;

	public static void main(String[] args) throws FileNotFoundException{

		JFileChooser j = new JFileChooser();
		j.setCurrentDirectory(new java.io.File("."));
		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int selectedValue = j.showSaveDialog(j);

		if(selectedValue == JFileChooser.APPROVE_OPTION){
			String fileURL = null;

			File dir = new File(j.getSelectedFile().getAbsolutePath());
			File[] listOfFiles = dir.listFiles();

			String fixedPath = dir.getAbsolutePath().replace("\\", "/");

			for (File file : listOfFiles) {
				if (file.isFile()&&(file.getName().substring(file.getName().lastIndexOf('.')+1).equals("txt"))) {
					// Code to be adapted to run txt object creation

					fileURL = fixedPath+"/"+file.getName();
					txtReader = new TxtHandlerClass();
					System.out.println("Simulating " + file.getName());
					testObj = txtReader.txtReader(fileURL);
					String pro_conf = txtReader.getProd_Config();
					for (File file1 : listOfFiles) {

						if (file1.isFile()&&(file1.getName().substring(file1.getName().lastIndexOf('.')+1).equals("xml"))) {
							// Scanner
							if(pro_conf.equals(file1.getName().replace(".xml", ""))){
								fileURL = fixedPath+"/"+file1.getName();
								xmlReader = new xmlHandler();
								System.out.println("Processing Input File " + file1.getName());
								customer = xmlHandler.xmlReader(fileURL);
								executeTest();
								System.out.println("Finished processing Test input file " + file1.getName());
							}
							else
							{
								System.out.println("No suitable test case for "+file1.getName()+ " file");
							}
						}
					}
					System.out.println("Finishing simulation " + file.getName());
				}else if(!file.getName().substring(file.getName().lastIndexOf('.')+1).equals("xml")){
					System.out.println("No valid file: " + file.getName());
				}
			}

		}else{
			System.out.println("Please execute the application to select a FOLDER...");
		}

	}
	public static void executeTest()
	{
		for(int index=0; index<customer.getAircraft().get(0).getProducts().size();index++)
		{				
			//Current product
			Products productRepository = customer.getAircraft().get(0).getProducts().get(index);
			System.out.println("\nProduct: "+ productRepository.getName());
			for(int testIndex=0;testIndex<testObj.size();testIndex++){
				//Creation of test factory according with the product name
				TestProcedureFactory testFactory = new TestProcedureFactory();
				TestProcedure test1 = testFactory.getResults(productRepository.getName());
				//Compare product subscribe against flight parameter in test case file
				System.out.println("Phase : " + testObj.get(testIndex).getPhase_Name());
				for(SubscribeIterator iter = productRepository.getSubscribeIterator(); iter.hasNext();){
					Subscribe S = new Subscribe();
					S = (Subscribe) iter.next();
					Flight_Phase FP = new Flight_Phase();
					//if the test case contains the specification value,it is evaluated
					FP = testObj.get(testIndex);
					test1.evaluate(S, FP);	
				}
			} 
		}			
	}

}
