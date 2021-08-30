package ExecutorServiceThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(10);

		List<Future<Integer>> futures = new ArrayList<>();

		for (int iter = 0; iter < 100; iter++) {
			Future<Integer> future = service.submit(new Task());
			futures.add(future);
		}

		for (int iter = 0; iter < 100; iter++) {
			Future<Integer> fut = futures.get(iter);

			Integer result = fut.get(); // blocking operation
			System.out.println(result);

			// extra method

			fut.cancel(false);
			fut.isCancelled();
			fut.isDone();// return true even if the task has failed.
		}

		System.out.println("Thread Name : " + Thread.currentThread().getName());
		;

	}

	static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			Thread.sleep(3000);
			return new Random().nextInt();
		}
	}
}
