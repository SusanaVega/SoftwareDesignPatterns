package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JFileChooser;

import FilesManagement.*;
import Proxy.ProxyWeatherTest1;
import Proxy.WeatherTest;
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
								try {
									executeTest();
								} catch (SecurityException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
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
	public static void executeTest() throws SecurityException, IOException
	{
		
		Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh; 
	    fh = new FileHandler(TestCase.getProductConfiguration() +".log");  
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);
        logger.setUseParentHandlers(false);
	    WeatherTest weatherTest;
		System.out.println("Flight type : " + TestCase.getFlightType());
		logger.info("Flight type : " + TestCase.getFlightType());
		System.out.println("Product Configuration : " + TestCase.getProductConfiguration());
		logger.info("Product Configuration : " + TestCase.getProductConfiguration());
		System.out.println("Preflight: Latitude Change : " + TestCase.getPreflight().getPreflight_Latitude_Change());
		logger.info("Preflight: Latitude Change : " + TestCase.getPreflight().getPreflight_Latitude_Change());
		System.out.println("Preflight: Longitude Change : " + TestCase.getPreflight().getPreflight_Longitude_Change());
		logger.info("Preflight: Longitude Change : " + TestCase.getPreflight().getPreflight_Longitude_Change());
		System.out.println("Preflight: Weather : " + TestCase.getPreflight().getPreflight_Weather());
		logger.info("Preflight: Weather : " + TestCase.getPreflight().getPreflight_Weather());
		
		for(int index=0; index<customer.getAircraft().get(0).getProducts().size();index++)
		{	

			//Current product
			Products productRepository = customer.getAircraft().get(0).getProducts().get(index);
			System.out.println("\nProduct: "+ productRepository.getName());			
			logger.info("\nProduct: "+ productRepository.getName());			
			
			for(int testIndex=0;testIndex<TestCase.getFlight_Phases().size();testIndex++){

				//Creation of test factory according with the product name
				TestProcedureFactory testFactory = new TestProcedureFactory();
				TestProcedure test1 = testFactory.getResults(productRepository.getName());
				
				//Compare product subscribe against flight parameter in test case file
				System.out.println("Phase : " + TestCase.getFlight_Phases().get(testIndex).getPhase_Name());
				logger.info("Phase : " + TestCase.getFlight_Phases().get(testIndex).getPhase_Name());
				System.out.println("Aircraft Maneuver : " + TestCase.getFlight_Phases().get(testIndex).getAircraft_Maneuver());
				logger.info("Aircraft Maneuver : " + TestCase.getFlight_Phases().get(testIndex).getAircraft_Maneuver());
				for(SubscribeIterator iter = productRepository.getSubscribeIterator(); iter.hasNext();){
					Subscribe S = new Subscribe();
					S = (Subscribe) iter.next();
					Flight_Phase FP = new Flight_Phase();
					//if the test case contains the specification value,it is evaluated
					FP = TestCase.getFlight_Phases().get(testIndex);
					String evaluation = test1.evaluate(S, FP);
					if(evaluation!=null){
					System.out.println(evaluation);
					logger.info(evaluation);
					}
				}
				TestCase.getFlight_Phases().get(testIndex).unSettignArrays();
				
				TestCase.getFlight_Phases().get(testIndex).populateArrayList();
				weatherTest = new ProxyWeatherTest1(TestCase.getPreflight().getPreflight_Weather(), TestCase.getFlight_Phases().get(testIndex).getAircraft_Maneuver(), customer.getCutomerName(), TestCase.getFlight_Phases().get(testIndex));
				String WeatherResult = weatherTest.runTestWeather();
				System.out.println(WeatherResult);
				logger.info(WeatherResult);
				
			} 
			
		}
		for(int k = 0; k < TestCase.getFlight_Phases().size();k++){
			TestCase.getFlight_Phases().get(k).clearParameters();
			
		}
		
	}

}
