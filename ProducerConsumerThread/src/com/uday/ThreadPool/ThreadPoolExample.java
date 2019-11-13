package com.uday.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
	public static void main(String[] args) {
		int number = 0;

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		while (number<20) {
			executorService.execute(new MessageProcessor(++number));
		}
		Runnable processor1 = new MessageProcessor(2);
		executorService.execute(processor1);

		executorService.shutdown();
		while (!executorService.isTerminated()) {

		}
		System.out.println("submitted all tasks");
	}

}
