
public class Resource {
	private int data;
	private boolean flag = false;

	public Resource(int data) {
		this.data = data;
	}

	public Resource(int data, boolean flag) {
		this.data = data;
		this.flag = flag;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public synchronized void produceProduct() {
		while(flag) {
			try {
				wait(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		data++;
		System.out.println("Producer produces");
		setFlag(true);
		notifyAll();
	}
	public synchronized void consumeProduct() {
		while(!flag) {
			System.out.println("Waiting");
			try {
				wait(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		data--;
		System.out.println("Consumer consumes");
		setFlag(false);
		notifyAll();
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
