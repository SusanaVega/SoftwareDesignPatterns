import java.util.ArrayList;

public class ProductsRepository implements ProductsContainer{ 

	public ArrayList<Subscribe> subs = new ArrayList<Subscribe>();
	public ArrayList<Publish> pub = new ArrayList<Publish>();
	
	public PublishIterator getPubIterator(){
		return new pubIterator();
	}
	public SubscribeIterator getSubsIterator(){
		return new subsIterator();
	}

	public ProductsRepository() {
		// TODO Auto-generated constructor stub
	}
	
	private class pubIterator implements PublishIterator {
		
		int index = 0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(index < pub.size()){
				return true;
			}else{
				return false;				
			}
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(this.hasNext()){
				return pub.get(index++);
			}else{
				return null;				
			}
				
		}
		
	}
	
	private class subsIterator implements SubscribeIterator {

		int index = 0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(index < subs.size()){
				return true;
			}else{
				return false;				
			}
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(this.hasNext()){
				return subs.get(index++);
			}else{
				return null;				
			}
		}
		
	}

}
