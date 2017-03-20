package factory;
public class TestProcedureFactory {
	
   //use getShape method to get object of type shape 
   public TestProcedure getResults(String TestProcedureType){
      if(TestProcedureType == null){
         return null;
      }		
      if(TestProcedureType.equalsIgnoreCase("FMS")){
         return new TestProcedureFMS();
         
      } else if(TestProcedureType.equalsIgnoreCase("GPS")){
         return new TestProcedureGPS();
         
      } else if(TestProcedureType.equalsIgnoreCase("IRS")){
         return new TestProcedureIRS();
      }
      else if(TestProcedureType.equalsIgnoreCase("Engine")){
          return new TestProcedureEngine();
       }
      else if (TestProcedureType.equalsIgnoreCase("DataRecorder"))
    	  return new TestProcedureDataRecorder();
      
      return null;
   }
}