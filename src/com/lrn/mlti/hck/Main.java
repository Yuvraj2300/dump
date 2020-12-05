package com.lrn.mlti.hck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public final static int MAX_PASS = 9999;

	public static void main(String[] args) {
		Random random = new Random();

		Vault vault = new Vault(random.nextInt(MAX_PASS));
		List<Thread> threads = new ArrayList<>();
		threads.add(new	 AscendingHackerThread(vault));
		threads.add(new	 DescendingHackerThread(vault));
		threads.add(new PoliceThread());
		
		for(Thread th:threads) {
			th.start();
		}
	}

	private static class Vault {
		private int password;

		public Vault(int password) {
			super();
			this.password = password;
		}

		public boolean isCorrect(int guess) throws InterruptedException {
			Thread.sleep(5);
			return this.password == guess;
		}
	}

	static abstract class HackerThread extends Thread {
		protected Vault vault;

		public HackerThread(Vault vault) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(Thread.MAX_PRIORITY);
		}

		@Override
		public void start() {
			System.out.println("Starting Thread :- " + this.getName());
			super.start();
		}
	}

	private static class AscendingHackerThread extends HackerThread {

		public AscendingHackerThread(Vault vault) {
			super(vault);
		}

		@Override
		public void run() {
			for (int guess = 0; guess < MAX_PASS; guess++) {
				try {
					if (vault.isCorrect(guess)) {
						System.out.println(this.getName() + " guessed the right password : " + guess);
						System.exit(0);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static class DescendingHackerThread extends HackerThread {

		public DescendingHackerThread(Vault vault) {
			super(vault);
		}

		@Override
		public void run() {
			for (int guess = MAX_PASS; guess >= 0; guess--) {
				try {
					if (vault.isCorrect(guess)) {
						System.out.println(this.getName() + " guessed the right password : " + guess);
						System.exit(0);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static class PoliceThread extends Thread {
		@Override
		public void run() {
			for (int i = 10; i > 0; i--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}
			System.out.println("Game over for you hackers hhahahhaa !");
			System.exit(0);
		}
	}

}