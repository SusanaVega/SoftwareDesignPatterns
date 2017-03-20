package factory;

import FilesManagement.Flight_Phase;
import FilesManagement.Subscribe;

public class TestProcedureDataRecorder implements TestProcedure{
	
	private int DataRate= 0;

	@Override
	public void evaluate(Subscribe s, Flight_Phase f) {
		if(f.getLongitude_Change()<=s.getMax() && f.getLongitude_Change()>=s.getMin()){
			System.out.println("\tData rate : " + f.getLongitude_Change() + "[PASS]");}
		else{
			System.out.println("\tLongitude_Change : " + f.getLongitude_Change() + "[FAIL]");}
		if(f.getLatitude_Change()<=s.getMax() && f.getLatitude_Change()>=s.getMin()){
			System.out.println("\tLatitude_Change : " + f.getLatitude_Change() + "[PASS]");}
		else{
			System.out.println("\tLatitude_Change : " + f.getLatitude_Change() + "[FAIL]");}
		
	}

	public int getDataRate() {
		return DataRate;
	}

	public void setDataRate(int dataRate) {
		DataRate = dataRate;
	}

}
