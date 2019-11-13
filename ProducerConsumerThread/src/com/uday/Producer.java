package com.uday;

import java.util.List;

public class Producer implements Runnable {

	List<Integer> questionList;
	int i=0;
	final int Limit=5;
	private int questionNo;
	public Producer(List<Integer> questionLIst) {
		this.questionList=questionLIst;
	}
	public void readQuestion(int questionNo) throws InterruptedException {
		synchronized (questionList) {
			while(questionList.size()==1) {
				System.out.println("maximum limit reached waiting for answers");
				questionList.wait();
			}
		}
		synchronized (questionList) {
			System.out.println("new Question:"+questionNo);
			questionList.add(questionNo);
			Thread.sleep(150);
			questionList.notify();
			
		}
	}

	@Override
	public void run() {
		while(i<15) {
			try {
				readQuestion(questionNo++);
			}
			catch(InterruptedException exe){
				
			}
			i++;
		}

		
	}

}
