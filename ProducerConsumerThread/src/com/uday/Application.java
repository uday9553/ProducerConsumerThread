package com.uday;

import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		List<Integer> questionLIst=new ArrayList<Integer>();
		Thread t1=new Thread(new Producer(questionLIst));
		Thread t2=new Thread(new Consumer(questionLIst));
		t1.start();
		t2.start();
	}

}
