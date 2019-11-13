package com.uday.ThreadPool;

public class MessageProcessor implements Runnable {
	int messageNo;
	public MessageProcessor(int messageNo) {
		this.messageNo=messageNo;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"[received] message="+messageNo);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"[processin] message="+messageNo);
	}

}
