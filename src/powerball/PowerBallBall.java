package powerball;

import lottery.Ball;

public class PowerBallBall implements Ball {
	private String label;
	private Color color;
	/**
	 * @param number
	 * @param color
	 */
	public PowerBallBall(String label, Color color) {
		this.label = label;
		this.color = color;
	}

	@Override
	public String getLabel(){
		return label;
	}

}
