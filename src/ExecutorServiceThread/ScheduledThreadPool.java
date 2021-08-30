package ExecutorServiceThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Delay queue - DelayedWorkQueue

//Schedule the tasks to run based on time delay (and retrigger for fixedRate / fixedDelay)

// Life Cycle : More threads are created if required.

//Service.schedule, Service.scheduleAtFixedRate, Service.scheduleAtFixedDelay
public class ScheduledThreadPool {

	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

		service.schedule(new Task(), 10, TimeUnit.SECONDS);

		service.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);

		service.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);

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
