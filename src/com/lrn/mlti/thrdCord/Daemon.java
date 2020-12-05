package com.lrn.mlti.thrdCord;

import java.math.BigInteger;

public class Daemon {

	public static void main(String[] args) throws InterruptedException {
		Thread	thread	=	new	Thread(new LongComputationTask(new BigInteger("2"), new BigInteger("1000000000000000000")));
	
		thread.setDaemon(false);
		thread.start();
	//	Thread.sleep(100);
		thread.interrupt();
	}

	
	private static class LongComputationTask implements Runnable {

		private BigInteger base;
		private BigInteger power;

		public LongComputationTask(BigInteger base, BigInteger power) {
			super();
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			System.out.println(base + "^" + power + " = " + pow(base, power));
		}

		public BigInteger pow(BigInteger base, BigInteger pow) {
			BigInteger result = BigInteger.ONE;

			for (BigInteger i = BigInteger.ZERO; i.compareTo(pow) != 0; i = i.add(BigInteger.ONE)) {
				
//				if(Thread.currentThread().isInterrupted()) {
//					System.out.println("Thread interuppted");
//					return BigInteger.ZERO;
//				}
				result = result.multiply(base);
			}
			return result;
		}
	}
}
