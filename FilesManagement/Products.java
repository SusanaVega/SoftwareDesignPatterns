package FilesManagement;

import java.util.ArrayList;

import iterator.ProductsContainer;
import iterator.PublishIterator;
import iterator.SubscribeIterator;

public class Products implements ProductsContainer{

	private ArrayList<Subscribe> subscribe;
	private ArrayList<Publish> publish;
	private int productID;
	private String name;
	
	public Products(){
		subscribe = new ArrayList<Subscribe>();
		publish = new ArrayList<Publish>();
	}
	
	public SubscribeIterator getSubscribe() {
		return null;
	}
	public void setSubscribe(Subscribe subscribe) {
		this.subscribe.add(subscribe);
	}
	public PublishIterator getPublish() {
		return null;
	}
	public void setPublish(Publish publish) {
		this.publish.add(publish);
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public PublishIterator getPublishIterator() {
	      return new pubIterator();
	   }
	
	public SubscribeIterator getSubscribeIterator() {
	      return new subsIterator();
	   }
public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
private class pubIterator implements PublishIterator {
		
		int index = 0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(index < publish.size()){
				return true;
			}else{
				return false;				
			}
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(this.hasNext()){
				return publish.get(index++);
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
			if(index < subscribe.size()){
				return true;
			}else{
				return false;				
			}
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(this.hasNext()){
				return subscribe.get(index++);
			}else{
				return null;				
			}
		}
		
	}
	
	
}
