package factory;

import FilesManagement.Flight_Phase;
import FilesManagement.Subscribe;

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
	public String evaluate(Subscribe s, Flight_Phase f) {
		switch(s.getName()){
		case "Longitude_Change":
	if(f.getLongitude_Change()<=s.getMax() && f.getLongitude_Change()>=s.getMin()){
		return("\tLongitude_Change : " + f.getLongitude_Change() + "[PASS]");}
	else if (f.getLongitude_Change()>s.getMax()){
		return("\tLongitude_Change : " + f.getWindSpeed() + "[FAIL] Longitude change is over the max value");}
	else {
		return("\tLongitude_Change : " + f.getWindSpeed() + "[FAIL] Longitude change is under the min value");}
		case  "Latitude_Change":
	if(f.getLatitude_Change()<=s.getMax() && f.getLatitude_Change()>=s.getMin()){
		return("\tLatitude_Change : " + f.getLongitude_Change() + "[PASS]");}
	else if (f.getLongitude_Change()>s.getMax()){
		return("\tLatitude_Change : " + f.getWindSpeed() + "[FAIL] Latitude change is over the max value");}
	else {
		return("\tLatitude_Change : " + f.getWindSpeed() + "[FAIL] Latitude change is under the min value");}
	}
	return null;
	}

}
