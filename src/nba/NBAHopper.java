package nba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lottery.Ball;
import lottery.Hopper;

public class NBAHopper implements Hopper{
	private List<Ball> hopper = new ArrayList<Ball>();

	@Override
	public void addBall(Ball ball) {
		hopper.add(ball);
	}
	@Override
	public void addBalls(List<Ball> balls) {
		hopper.addAll(balls);
		this.shuffle();
	}
	@Override
	public void shuffle() {
		Collections.shuffle(hopper);
	}

	@Override
	public Ball draw() {
		return hopper.remove(0);
	}

	@Override
	public Ball peek() {
		return hopper.get(0);
	}

}
