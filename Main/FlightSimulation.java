package Main;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import Adapter.ProxyWeatherTest1;
import Adapter.WeatherTest;
import FilesManagement.*;
import factory.TestProcedure;
import factory.TestProcedureFactory;
import iterator.SubscribeIterator;

public class FlightSimulation {

	static xmlHandler xmlReader;
	static Customer customer = null;
	static TxtHandlerClass txtReader;
	static TestCase TestCase;
	//static ArrayList<Flight_Phase> FlightPhases_Array;

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
					TestCase = new TestCase();
					System.out.println("Simulating " + file.getName());
					TestCase = txtReader.txtReader(fileURL);
					//FlightPhases_Array = TestCase.getFlight_Phases();
					//String pro_conf = txtReader.getProd_Config();
					String pro_conf = TestCase.getProductConfiguration();
					for (File file1 : listOfFiles) {

						if (file1.isFile()&&(file1.getName().substring(file1.getName().lastIndexOf('.')+1).equals("xml"))) {
							// Scanner
							if(pro_conf.equals(file1.getName().replace(".xml", ""))){
								fileURL = fixedPath+"/"+file1.getName();
								xmlReader = new xmlHandler();
								System.out.println("Processing Input File " + file1.getName());
								customer = xmlHandler.xmlReader(fileURL);
								System.out.println("\nCustomer: " + customer.getCutomerName());
								executeTest();
								System.out.println("Finished processing Test input file " + file1.getName());
								
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
	      WeatherTest weatherTest;

	      //image will be loaded from disk
	      //image.display(); 
		System.out.println("Flight type : " + TestCase.getFlightType());
		System.out.println("Product Configuration : " + TestCase.getProductConfiguration());
		System.out.println("Preflight: Latitude Change : " + TestCase.getPreflight().getPreflight_Latitude_Change());
		System.out.println("Preflight: Longitude Change : " + TestCase.getPreflight().getPreflight_Longitude_Change());
		System.out.println("Preflight: Weather : " + TestCase.getPreflight().getPreflight_Weather());
		
		for(int index=0; index<customer.getAircraft().get(0).getProducts().size();index++)
		{	

			//Current product
			Products productRepository = customer.getAircraft().get(0).getProducts().get(index);
			System.out.println("\nProduct: "+ productRepository.getName());			
			
			for(int testIndex=0;testIndex<TestCase.getFlight_Phases().size();testIndex++){

				//Creation of test factory according with the product name
				TestProcedureFactory testFactory = new TestProcedureFactory();
				TestProcedure test1 = testFactory.getResults(productRepository.getName());
				
				//Compare product subscribe against flight parameter in test case file
				System.out.println("Phase : " + TestCase.getFlight_Phases().get(testIndex).getPhase_Name());
				System.out.println("Aircraft Maneuver : " + TestCase.getFlight_Phases().get(testIndex).getAircraft_Maneuver());
				for(SubscribeIterator iter = productRepository.getSubscribeIterator(); iter.hasNext();){
					Subscribe S = new Subscribe();
					S = (Subscribe) iter.next();
					Flight_Phase FP = new Flight_Phase();
					//if the test case contains the specification value,it is evaluated
					FP = TestCase.getFlight_Phases().get(testIndex);
					test1.evaluate(S, FP);
				}
				TestCase.getFlight_Phases().get(testIndex).unSettignArrays();
				
				TestCase.getFlight_Phases().get(testIndex).populateArrayList();
				weatherTest = new ProxyWeatherTest1(TestCase.getPreflight().getPreflight_Weather(), TestCase.getFlight_Phases().get(testIndex).getAircraft_Maneuver(), customer.getCutomerName(), TestCase.getFlight_Phases().get(testIndex));
				weatherTest.runTestWeather();
				//TestCase.getFlight_Phases().get(testIndex).clearParameters();
				
			} 
			
		}
		for(int k = 0; k < TestCase.getFlight_Phases().size();k++){
			TestCase.getFlight_Phases().get(k).clearParameters();
			
		}
		
	}

}
