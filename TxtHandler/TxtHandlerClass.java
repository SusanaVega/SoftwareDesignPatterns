package TxtHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TxtHandlerClass {
	
	private String Prod_Config = "";

	public ArrayList<Flight_Phase> txtReader(String file) {
			String string;
			FileReader f;
			Flight_Phase FP = null;
			ArrayList<Flight_Phase> FPArray = new ArrayList<Flight_Phase>(); 
			try {
				f = new FileReader(file);
				BufferedReader b = new BufferedReader(f);
				while((string = b.readLine())!=null) {
					String labelContent = string.substring(string.indexOf("[")+1,string.indexOf("]"));
					String labelValue = string.substring(string.indexOf("=")+1,string.length());
					switch(labelContent){
						case "PRE_FLIGHT"
								+ "": break;
						case "PRODUCT_CONFIGURATION": setProd_Config(labelValue) ;break;
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
	        
			} catch (IOException e) {
				System.out.println("Something failed");
			}
		//}
			return FPArray;
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
	public String getProd_Config() {
		return Prod_Config;
	}
	public void setProd_Config(String prod_Config) {
		Prod_Config = prod_Config;
	}
}
