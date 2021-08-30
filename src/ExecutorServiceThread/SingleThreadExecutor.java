package ExecutorServiceThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//blocking queue

//LifeCycle : Recreates thread if killed because of the task.
public class SingleThreadExecutor {

	public static void main(String[] args) {

		ExecutorService service = Executors.newSingleThreadExecutor();
		for (int iter = 0; iter < 100; iter++) {
			service.execute(new Task());
		}

		System.out.println("Thread Name : " + Thread.currentThread().getName());
	}

	static class Task implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Thread Name : " + Thread.currentThread().getName());
		}
	}
}
