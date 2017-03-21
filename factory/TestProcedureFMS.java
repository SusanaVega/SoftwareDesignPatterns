package factory;

import FilesManagement.Flight_Phase;
import FilesManagement.Subscribe;

public class TestProcedureFMS implements TestProcedure{
	
	private int WindSpeed=0;
	private int Duration=0;
	private int FlightSpeed=0;
	private int VerticalSpeed=0;
	private int GPS_Latitude=0;
	private int GPS_Longitude=0;
	private int IRS_Latitude=0;
	private int IRS_Longitude=0;

	public TestProcedureFMS() {
		// TODO Auto-generated constructor stub
	}

	public int getWindSpeed() {
		return WindSpeed;
	}

	public void setWindSpeed(int windSpeed) {
		WindSpeed = windSpeed;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public int getFlightSpeed() {
		return FlightSpeed;
	}

	public void setFlightSpeed(int flightSpeed) {
		FlightSpeed = flightSpeed;
	}

	public int getVerticalSpeed() {
		return VerticalSpeed;
	}

	public void setVerticalSpeed(int verticalSpeed) {
		VerticalSpeed = verticalSpeed;
	}

	public int getGPS_Latitude() {
		return GPS_Latitude;
	}

	public void setGPS_Latitude(int gPS_Latitude) {
		GPS_Latitude = gPS_Latitude;
	}

	public int getGPS_Longitude() {
		return GPS_Longitude;
	}

	public void setGPS_Longitude(int gPS_Longitude) {
		GPS_Longitude = gPS_Longitude;
	}

	public int getIRS_Latitude() {
		return IRS_Latitude;
	}

	public void setIRS_Latitude(int iRS_Latitude) {
		IRS_Latitude = iRS_Latitude;
	}

	public int getIRS_Longitude() {
		return IRS_Longitude;
	}

	public void setIRS_Longitude(int iRS_Longitude) {
		IRS_Longitude = iRS_Longitude;
	}

	@Override
	public String evaluate(Subscribe s, Flight_Phase f) {
		//Evaluate WindSpeed
		switch(s.getName()){
			case "WindSpeed":
		if(f.getWindSpeed()<=s.getMax() && f.getWindSpeed()>=s.getMin()){
			return ("\tWindSpeed : " + f.getWindSpeed() + "[PASS]");}
		else if (f.getWindSpeed()>s.getMax()){
			return("\tWindSpeed : " + f.getWindSpeed() + "[FAIL] WindSpeed is over the max value");}
		else {
			return("\tWindSpeed : " + f.getWindSpeed() + "[FAIL] WindSpeed is under the min value");}
		
		//Evaluate Duration
			case "Duration":
		if(f.getDuration()<=s.getMax() && f.getDuration()>=s.getMin()){
			return("\tDuration : " + f.getDuration() + "[PASS]");}
		else if(f.getDuration()>s.getMax()){
			return("\tDuration : " + f.getDuration() + "[FAIL] Duration is over the max value");}
		else {
			return("\tDuration : " + f.getDuration() + "[FAIL] Duration is under the min value");}
		
		//Evaluate Vertical Speed
			case "VerticalSpeed":
		if(f.getVerticalSpeed()<=s.getMax() && f.getVerticalSpeed()>=s.getMin()){
			return("\tVerticalSpeed : " + f.getVerticalSpeed() + "[PASS]");}
		else if(f.getVerticalSpeed()>s.getMax()){
			return("\tVerticalSpeed : " + f.getVerticalSpeed() + "[FAIL] VerticalSpeed is over the max value");}
		else{
			return("\tVerticalSpeed : " + f.getVerticalSpeed() + "[FAIL] VerticalSpeed is under the min value");}
		
		}
		return null;
		
	}

}
