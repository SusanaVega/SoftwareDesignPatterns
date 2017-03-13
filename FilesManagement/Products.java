package FilesManagement;

import java.util.ArrayList;

public class Products {

	private ArrayList<Subscribe> subscribe;
	private ArrayList<Publish> publish;
	private int productID;
	
	public Products(){
		subscribe = new ArrayList<Subscribe>();
		publish = new ArrayList<Publish>();
	}
	
	public ArrayList<Subscribe> getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(Subscribe subscribe) {
		this.subscribe.add(subscribe);
	}
	public ArrayList<Publish> getPublish() {
		return publish;
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
	
	
}
