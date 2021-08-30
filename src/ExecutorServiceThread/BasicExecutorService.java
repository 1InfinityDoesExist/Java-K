package ExecutorServiceThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * LinkedBlockingQueue
 * If taskType =  CPU intensive then ideal pool size = CPU Core Count, Consideration = How many other applications (or other executors/threads) are running on the same CPU
 *  
 * If taskType = IO intensive then Ideal pool size = High, Consideration = Exact  number will depend on rate of task submissions and average task wait time.
 * Too many threads will increase memory consumption too.
 * 
 */
public class BasicExecutorService {

	public static void main(String[] args) {

		// get count of availabe cores

		int coreCount = Runtime.getRuntime().availableProcessors();

		// Create a pool
		ExecutorService service = Executors.newFixedThreadPool(coreCount);
		for (int iter = 0; iter < 100; iter++) {
			service.execute(new Task());
		}
		System.out.println("Thread Name : " + Thread.currentThread().getName());
	}

	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println("Thread Name : " + Thread.currentThread().getName());
		}
	}

}
