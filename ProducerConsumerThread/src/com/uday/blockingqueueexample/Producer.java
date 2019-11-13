package com.uday.blockingqueueexample;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	int questionNo;
	BlockingQueue<Integer> questionQueue;

	public Producer(BlockingQueue<Integer> questionQueue) {
		this.questionQueue = questionQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (this) {
					System.out.println("got new question" + ++questionNo);
					questionQueue.put(questionNo);
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
