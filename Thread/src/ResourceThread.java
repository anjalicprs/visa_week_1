
public class ResourceThread extends Thread {
	private Resource resource ;
	private ResourceUtilityType type;

	public ResourceThread(Resource resource, ResourceUtilityType type) {
		this.resource = resource;
		this.type =type ;
	}
	
	@Override
	public void run() {
		if(type == ResourceUtilityType.PRODUCE) {
			resource.produceProduct();
		} else {
			resource.consumeProduct();
		}
	}
}
