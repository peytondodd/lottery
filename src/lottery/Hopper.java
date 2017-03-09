package com.sd.lottery;

import java.util.List;

public interface Hopper {

	void addBall(Ball ball);
	void addBalls(List<Ball> balls);
	void shuffle();

	Ball draw();

	Ball peek();

}
