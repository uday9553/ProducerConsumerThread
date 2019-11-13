package com.uday;

import java.util.List;

public class Consumer implements Runnable {

	List<Integer> questionList;
	public Consumer(List<Integer> questionLIst) {
		this.questionList=questionLIst;
	}
	
	public void answerQuestion() throws InterruptedException {
		synchronized (questionList) {
			while(questionList.isEmpty()) {
				System.out.println("no question to answer");
				questionList.wait();
			}
		}
		synchronized (questionList) {
			Thread.sleep(500);
			System.out.println("Answered Question:"+questionList.remove(0));
			questionList.notify();
			
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				answerQuestion();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
