package FilesManagement;

import java.util.ArrayList;

public class Flight_Phase {
	private String Phase_Name = "";
	//private String Flight_Type = "";
	private String Aircraft_Maneuver = "";
	private int Duration = 0;
	private int VerticalSpeed = 0;
	private int WindSpeed = 0;
	private float Latitude_Change = 0;
	private float Longitude_Change = 0;
	private ArrayList<String> paramNames = new ArrayList<String>();
	private ArrayList<Float> paramValues = new ArrayList<Float>();

	public Flight_Phase() {
		// TODO Auto-generated constructor stub
	}

	public void populateArrayList(){
		
		this.setParamNames("Duration");
		this.setParamValues((float)this.getDuration());
		this.setParamNames("VerticalSpeed");
		this.setParamValues((float)this.getVerticalSpeed());
		this.setParamNames("WindSpeed");
		this.setParamValues((float)this.getWindSpeed());
		this.setParamNames("Latitude_Charge");
		this.setParamValues((float)this.getLatitude_Change());
		this.setParamNames("Longitude_Change");
		this.setParamValues((float)this.getLongitude_Change());
		
	}
	
	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public int getWindSpeed() {
		return WindSpeed;
	}

	public void setWindSpeed(int windspeed) {
		WindSpeed = windspeed;
	}

	public float getLatitude_Change() {
		return Latitude_Change;
	}

	public void setLatitude_Change(float latitude_Change) {
		Latitude_Change = latitude_Change;
	}

	public float getLongitude_Change() {
		return Longitude_Change;
	}

	public void setLongitude_Change(float longitude_Change) {
		Longitude_Change = longitude_Change;
	}

	public String getPhase_Name() {
		return Phase_Name;
	}

	public void setPhase_Name(String phase_Name) {
		Phase_Name = phase_Name;
	}

	public int getVerticalSpeed() {
		return VerticalSpeed;
	}

	public void setVerticalSpeed(int verticalSpeed) {
		VerticalSpeed = verticalSpeed;
	}

	public String getAircraft_Maneuver() {
		return Aircraft_Maneuver;
	}

	public void setAircraft_Maneuver(String aircraft_Maneuver) {
		Aircraft_Maneuver = aircraft_Maneuver;
	}

	public ArrayList<String> getParamNames() {
		return paramNames;
	}

	public void setParamNames(String paramNames) {
		this.paramNames.add(paramNames);
	}

	public ArrayList<Float> getParamValues() {
		return paramValues;
	}

	public void setParamValues(Float paramValues) {
		this.paramValues.add(paramValues);
	}
	
	public void unSettignArrays(){
		this.paramNames.clear();
		this.paramValues.clear();
	}
	
public void clearParameters(){
		
		this.Phase_Name = "";
		//private String Flight_Type = "";
		this.Aircraft_Maneuver = "";
		this.Duration = 0;
		this.VerticalSpeed = 0;
		this.WindSpeed = 0;
		this.Latitude_Change = 0;
		this.Longitude_Change = 0;

	}

	
}
