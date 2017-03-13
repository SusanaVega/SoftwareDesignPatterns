package Main;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import FilesManagement.Customer;
import FilesManagement.xmlHandler;

public class FlightSimulation {

	static xmlHandler xmlReader;
	static Customer customer = null;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int selectedValue = j.showSaveDialog(j);
		
		if(selectedValue == JFileChooser.APPROVE_OPTION){
			//System.out.println(j.getSelectedFile());
			String rootFolder = "Files/";
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
					 //fileURL = rootFolder+file.getName();
					 //xmlReader = new xmlHandler();
					 //customer = xmlReader.xmlReader(fileURL);
				 }
			}
		}else{
			System.out.println("Please execute the application to select a FOLDER...");
		}

	}
	
}
