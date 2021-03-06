package lottery;

import java.util.ArrayList;
import java.util.List;

import nba.NBATeamBall;
import powerball.Color;
import powerball.PowerBallBall;

public class BallFactory {
	public List<Ball> makeBalls(int numBalls, String name) {
		List<Ball> balls = new ArrayList<>();
		for (int i = 0; i < numBalls; i++) {
			balls.add(new NBATeamBall(name));
		}
		return balls;
	}
	public List<Ball> makeBalls(Integer numBalls, Color color) {
		List<Ball> balls = new ArrayList<>();
		for (Integer label = 1; label <= numBalls; label++){
			balls.add(new PowerBallBall(label.toString(), color));
		}
		return balls;
	}
}
