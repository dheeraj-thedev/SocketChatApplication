package com.careerera.threadsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Create Some Shared Data 
// We try to modify same via various different Threads 

class Counter {

	private int count = 0;

	public void increment() {

		synchronized (this) {
			count = count + 1;
		}

	}

	public int getCount() {
		return count;
	}
}

//
//1. Retrive current value of count 
//2. increment the retrived value by one 
//3. Storing incremented value back in count

//1. ThreadA : Retrive the count , inital =0 
//1. ThreadA : Retrive the count , inital =0 

public class DemoRaceCondition {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Counter counter = new Counter();

		for (int i = 0; i < 1000; i++) {
			executorService.submit(() -> counter.increment());
		}

		executorService.shutdown();
		executorService.awaitTermination(60, TimeUnit.SECONDS);

		System.out.println("The Final COunt is " + counter.getCount());

	}
}
