
public class ResourceClient {

	public static void main(String[] args) {
		Resource resource = new Resource(0);
		Thread t1 = new ResourceThread(resource, ResourceUtilityType.PRODUCE);
		Thread t2 = new ResourceThread(resource, ResourceUtilityType.CONSUME);
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t1.start();
		try {
			t1.join(); t2.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(resource.getData());
	}

}
