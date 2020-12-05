package com.lrn.mlti;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("We are in the thread "+Thread.currentThread().getName());
				System.out.println("Priority : -"+ Thread.currentThread().getPriority());
			}

		});
		
		thread.setName("New Worker Thread");
		
		thread.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("in :- "+Thread.currentThread().getName()+" before starting");
		thread.start();
		System.out.println("in :- "+Thread.currentThread().getName()+" after starting");
	
		Thread.sleep(10000);
	}
}
