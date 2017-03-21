package factory;

import FilesManagement.Flight_Phase;
import FilesManagement.Subscribe;

public class TestProcedureDataRecorder implements TestProcedure{
	
	private int DataRate= 0;

	@Override
	public String evaluate(Subscribe s, Flight_Phase f) {

		if(getDataRate()<=s.getMax() && getDataRate()>=s.getMin()){
			return("\tData rate : " + f.getLongitude_Change() + "[PASS]");}
		else if (f.getLongitude_Change()>s.getMax()){
			return("\tData rate : " + f.getWindSpeed() + "[FAIL] Data rate is over the max value");}
		else {
			return("\tData rate : " + f.getWindSpeed() + "[FAIL] Data rate is under the min value");}
		
	}

	public int getDataRate() {
		return DataRate;
	}

	public void setDataRate(int dataRate) {
		DataRate = dataRate;
	}

}
