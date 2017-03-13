package TxtHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TxtHandlerClass {

	public Flight_Phase txtReader(String file) {
		//JOptionPane.showMessageDialog(null, "Please choise a test case file");
		//JFileChooser file=new JFileChooser();
		//file.setDialogTitle("Test Case");
		//int returnVal = file.showOpenDialog(null);
		//File file;		
		//if (returnVal == JFileChooser.APPROVE_OPTION){
		//file=file.getSelectedFile();
			String string;
			FileReader f;
			Flight_Phase FP = null;
			ArrayList<Flight_Phase> FPArray = new ArrayList<Flight_Phase>(); 
			try {
				f = new FileReader(file);
				BufferedReader b = new BufferedReader(f);
				while((string = b.readLine())!=null) {
					System.out.println(string);
					String labelContent = string.substring(string.indexOf("[")+1,string.indexOf("]"));
					String labelValue = string.substring(string.indexOf("=")+1,string.length());
					switch(labelContent){
						case "PRE_FLIGHT"
								+ "": break;
						case "FLIGHT_PHASE": 
							if (FP != null)
								FPArray.add(FP);
							FP = new Flight_Phase(); 
							FP.setPhase_Name(string.substring(string.indexOf("=")+1, string.length()));break;
						case "FLIGHT_PARAMETER": SetValue(FP,labelValue); break;
						default : break;
					}
				}
				FPArray.add(FP);
				b.close();
				for(int i=0;i<FPArray.size();i++)
				{
					System.out.println("Phase_Name : "+FPArray.get(i).getPhase_Name());
					System.out.println("Duration : "+FPArray.get(i).getDuration());
					System.out.println("Latitude : "+FPArray.get(i).getLatitude_Change());
					System.out.println("Longitud : "+FPArray.get(i).getLongitude_Change());
					System.out.println("Vertical : "+FPArray.get(i).getVerticalSpeed());
					System.out.println("Wind : "+FPArray.get(i).getWindSpeed());
				}
	        
			} catch (IOException e) {
				System.out.println("Something failed");
			}
		//}
			return FP;
	}
	private static void SetValue(Flight_Phase obj, String value)
	{
		String attributeName = value.substring(0,value.indexOf(":"));
		String attibuteValue = value.substring(value.indexOf(":")+1,value.length());
		switch(attributeName)
		{
		case "Duration": obj.setDuration(Integer.parseInt(attibuteValue));break;
		case "VerticalSpeed": obj.setVerticalSpeed(Integer.parseInt(attibuteValue));break;
		case "WindSpeed": obj.setWindSpeed(Integer.parseInt(attibuteValue));break;
		case "Latitude_Change": obj.setLatitude_Change(Float.parseFloat(attibuteValue));break;
		case "Longitude_Change": obj.setLongitude_Change(Float.parseFloat(attibuteValue));break;
		default: System.out.println("Pamameter " + attributeName + " not supported");
		}
	}
}
