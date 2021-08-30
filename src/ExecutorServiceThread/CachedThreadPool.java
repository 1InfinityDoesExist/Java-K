package ExecutorServiceThread;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

/*
 * Synchronous queue (can hold only 1 task)
 * 
 * If all threads are busy, then create a new thread for the task and place it in the pool.
 * 
 * Life Cycle : If thread is idle for 60 second (no tasks to execute) then kill the thread 
 * 
 */
public class CachedThreadPool {

	public static void main(String[] args) {

		// for lot of short lived task
		ExecutorService service = Executors.newCachedThreadPool();

		// submit the task for execution
		for (int iter = 0; iter < 100; iter++) {
			service.execute(new Task());
		}
		System.out.println("Thread Name : " + Thread.currentThread().getName());
	}

	static class Task implements Runnable {
		public void run() {
			System.out.println("Thread Name : " + Thread.currentThread().getName());
		}
	}

}
