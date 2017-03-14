package iterator;
public interface ProductsContainer {

	public PublishIterator getPublish();
	public SubscribeIterator getSubscribe();
	
}
