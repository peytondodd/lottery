package com.sd.powerball;

public class PowerBallSimulator {
	private String[] winner;

	public static void main(String[] args) {
		PowerBallSimulator simulator = new PowerBallSimulator();
		simulator.runSimulation(1);
	}

	private void runSimulation(int runs) {
		for (int i = 0; i < runs; i++) {
			PowerBallManager manager = new PowerBallManager();
			winner = manager.getWinner();
		}
		printResults(runs);

	}

	public void printResults(int runs) {
		System.out.println("Winning PowerBall Numbers for This Week:");
		System.out.println("****************************************");
		for(int  i = 0; i < PowerBallManager.NUMBER_OF_WINNING_WHITE_BALLS; i++) {
			System.out.print(winner[i] + " ");
		}
		System.out.print(": ");
		for(int  i = 0; i < PowerBallManager.NUMBER_OF_WINNING_RED_BALLS; i++) {
			System.out.print(winner[i] + " ");

		}

	}
}
