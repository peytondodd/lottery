package com.sd.powerball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sd.lottery.Ball;
import com.sd.lottery.Hopper;

public class RedBallMachine implements Hopper {
	private int numBalls;
	private Color ballColor;
	private List<Ball> balls = new ArrayList<Ball>();


	/**
	 * @param numBalls
	 */
	public RedBallMachine() {
		this.numBalls = 26;
		this.ballColor = Color.RED;
	}
	@Override
	public void addBall(Ball ball) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addBalls(List<Ball> balls) {
		this.balls.addAll(balls);
		this.shuffle();
	}

	@Override
	public void shuffle() {
		Collections.shuffle(balls);
	}

	@Override
	public Ball draw() {
		return balls.remove(0);
	}

	@Override
	public Ball peek() {
		// TODO Auto-generated method stub
		return null;
	}
	public Integer getNumBalls() {
		return numBalls;
	}

	public Color getBallColor() {
		return ballColor;
	}

}
