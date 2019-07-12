
public class ThreadExample {

	public static void main(String[] args) {
		Numbers t1 = new Numbers(1, 400);
		Numbers t2 = new Numbers(900, 1200);
		/*
		 * If we name it as daemon thread then it will not execute fully as other non-daemon will get
		 * over
		 */
		//t2.setDaemon(true);
		Chars ch = new Chars();
		/*
		 * If class implements runnable we introduce a thread and then pass the object to
		 * it for providing a target
		 */
		Thread t3 = new Thread(ch);//for calling ch class thread
		t3.start();
		t1.start();
		t2.start();
		doTask();
	}

	private static void doTask() {
		Thread t = Thread.currentThread();
		System.out.println("Name: " + t.getName());
		System.out.println("Priority: " + t.getPriority());
		System.out.println("Group: " + t.getThreadGroup().getName());
		/*
		 * JRE waits for the status of last nonDaemon Thread before it terminates
		 */
		System.out.println("Daemon: " + t.isDaemon());
	}

}
