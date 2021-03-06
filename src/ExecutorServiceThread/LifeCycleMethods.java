package ExecutorServiceThread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LifeCycleMethods {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(10);

		// initiated shutdown
		service.shutdown();

		// will throw RejectionExecutionException
		service.execute(new Task());

		// will return true, since shutdown has begun
		service.isShutdown();

		// will return true if all task are completed, including queued ones
		service.isTerminated();

		// block until all tasks are completed or if timeout occurs
		service.awaitTermination(10, TimeUnit.SECONDS);

		// will initiate shutdown and return all queued tasks
		List<Runnable> runnables = service.shutdownNow();
	}

	static class Task implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Thread Name : " + Thread.currentThread().getName());
		}
	}

}
