package com.lrn.mlti;

public class Error {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				throw new RuntimeException("Intentional Error");
			}
		});

		thread.setName("Misbehaving Thread");
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println(
						"A critical error was caught in thread :- " + t.getName() + ", this error is :-" + e.getMessage());
			}
		});
		
		thread.start();

	}
}
