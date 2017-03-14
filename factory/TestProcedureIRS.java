package factory;

import FilesManagement.Subscribe;
import TxtHandler.Flight_Phase;

public class TestProcedureIRS implements TestProcedure{
	
	private Double Longitude_Change=0.0;
	private Double Latitude_Change=0.0;

	public TestProcedureIRS() {
		// TODO Auto-generated constructor stub
	}

	public Double getLongitude_Change() {
		return Longitude_Change;
	}

	public void setLongitude_Change(Double longitude_Change) {
		Longitude_Change = longitude_Change;
	}

	public Double getLatitude_Change() {
		return Latitude_Change;
	}

	public void setLatitude_Change(Double latitude_Change) {
		Latitude_Change = latitude_Change;
	}

	@Override
	public void evaluate(Subscribe s, Flight_Phase f) {
		if(f.getLongitude_Change()<=s.getMax() && f.getLongitude_Change()>=s.getMin()){
			System.out.println("\tLongitude_Change : " + f.getLongitude_Change() + "[PASS]");}
		else{
			System.out.println("\tLongitude_Change : " + f.getLongitude_Change() + "[FAIL]");}
		if(f.getLatitude_Change()<=s.getMax() && f.getLatitude_Change()>=s.getMin()){
			System.out.println("\tLatitude_Change : " + f.getLatitude_Change() + "[PASS]");}
		else{
			System.out.println("\tLatitude_Change : " + f.getLatitude_Change() + "[FAIL]");}
		
	}

}
