public class Products implements ProductsContents{

	@Override
	public Publish getPublish() {
		// TODO Auto-generated method stub
		ProductsRepository ProductIterator = new ProductsRepository();
		
		for(PublishIterator it = ProductIterator.getPubIterator(); it.hasNext();){
			
			Publish P = (Publish) it.next();
			String Name = P.getName();
			String Type = P.getType();
			String Default = P.getDefault();
			String Operation = P.getOperation();
			String Operand1 = P.getOperand1();
			String Operand2 = P.getOperand2();
			String Operand3 = P.getOperand3();
			String Min = P.getMin();
			String Max = P.getMax();
			
			
			//to be fixed 
		}
		return null;
	}

	@Override
	public Subscribe getSubscribe() {
		// TODO Auto-generated method stub
		ProductsRepository ProductIterator = new ProductsRepository();
		
		for(SubscribeIterator sb = ProductIterator.getSubsIterator(); sb.hasNext();){
			
			Subscribe S = (Subscribe) sb.next();
			String Name = S.getName();
			String Type = S.getType();
			String Default = S.getDefault();
			String Origin = S.getOrigin();
			String Min = S.getMin();
			String Max = S.getMax();
			
			
			//to be fixed 
		}
		return null;
	}

}
