package TxtHandler;

public class Flight_Phase {
	private String Phase_Name = "";
	private int Duration = 0;
	private int VerticalSpeed = 0;
	private int WindSpeed = 0;
	private float Latitude_Change = 0;
	private float Longitude_Change = 0;

	public Flight_Phase() {
		// TODO Auto-generated constructor stub
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

}
