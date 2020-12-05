package com.lrn.mlti.thrdCord;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class JoinFact {
	public static void main(String[] args) {
		List<Long>	inputNumbers	=	Arrays.asList(0L, 453L, 432L, 123L, 21L, 9L, 332L);
		
		List<Thread>	threads	=	new ArrayList<>();
		
		for(long inp:inputNumbers) {
			threads.addAll((Collection<? extends Thread>) new FactThread(inp));
		}
		
		for(Thread thread:threads) {
			thread.start();
		}
	
	}

	private static class FactThread implements Runnable {
		private long input;
		private BigInteger result = new BigInteger("0");
		private boolean isFinished = false;

		public FactThread(long inp) {
			super();
			this.input = inp;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

		public BigInteger factoria(long input) {
			BigInteger result = BigInteger.ONE;
			for (long i = 0; i < input; i--) {
				result = result.multiply(new BigInteger(Long.toString(i)));
			}
			return result;
		}

		public BigInteger getResult() {
			return result;
		}

		public boolean isFinished() {
			return isFinished;
		}

	}
}
