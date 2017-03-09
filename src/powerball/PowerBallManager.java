package powerball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lottery.BallFactory;
import lottery.Hopper;
import lottery.Manager;

public class PowerBallManager implements Manager{
	private BallFactory ballFactory;
	private List<Hopper> whiteBallMachines;
	private List<Hopper> redBallMachines;

	public static final Integer NUMBER_OF_WHITE_PB_MACHINES = 4;
	public static final Integer NUMBER_OF_RED_PB_MACHINES = 4;
	public static final Integer TOTAL_NUMBER_OF_MACHINES = NUMBER_OF_RED_PB_MACHINES + NUMBER_OF_WHITE_PB_MACHINES;
	public static final Integer NUMBER_OF_WINNING_WHITE_BALLS = 5;
	public static final Integer NUMBER_OF_WINNING_RED_BALLS = 1;



	public PowerBallManager() {
		ballFactory = new BallFactory();
		whiteBallMachines = new ArrayList<>();
		redBallMachines = new ArrayList<>();
		for (int i = 0; i < NUMBER_OF_WHITE_PB_MACHINES; i++){
			WhiteBallMachine whiteBallMachine = new WhiteBallMachine();
			whiteBallMachines.add(new WhiteBallMachine());
		}
		for (int i = 0; i < NUMBER_OF_RED_PB_MACHINES; i++){
			RedBallMachine redBallMachine = new RedBallMachine();
			redBallMachines.add(new RedBallMachine());
		}
		loadDefaultHopper();
	}


	@Override
	public void loadDefaultHopper() {
		for (Hopper whiteBallMachine : whiteBallMachines) {
			whiteBallMachine.addBalls(ballFactory.makeBalls(
					((WhiteBallMachine) whiteBallMachine).getNumBalls(), ((WhiteBallMachine) whiteBallMachine).getBallColor()));
		}
		for (Hopper redBallMachine : redBallMachines) {
			redBallMachine.addBalls(ballFactory.makeBalls(
					((RedBallMachine) redBallMachine).getNumBalls(), ((RedBallMachine) redBallMachine).getBallColor()));
		}

	}


	@Override
	public String[] getWinner() {
		Random generator = new Random();
		Hopper selectedWhiteBallMachine = whiteBallMachines.get(generator.nextInt(whiteBallMachines.size()));
		Hopper selectedRedBallMachine = redBallMachines.get(generator.nextInt(redBallMachines.size()));
		String[] winningBalls = new String[
		                                   NUMBER_OF_WINNING_WHITE_BALLS + NUMBER_OF_WINNING_RED_BALLS];

		for (int i = 0; i < NUMBER_OF_WINNING_WHITE_BALLS; i++) {
			winningBalls[i] = selectedWhiteBallMachine.draw().getLabel();
		}

		for (int i = NUMBER_OF_WINNING_WHITE_BALLS;
				i < NUMBER_OF_WINNING_WHITE_BALLS + NUMBER_OF_WINNING_RED_BALLS; i++) {
			winningBalls[i] = selectedWhiteBallMachine.draw().getLabel();
		}
		return winningBalls;
	}
}
