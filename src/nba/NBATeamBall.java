package com.sd.nba;

import com.sd.lottery.Ball;

public class NBATeamBall implements Ball {
	private String label;

	public NBATeamBall(String name){
		this.label = name;
	}

	@Override
	public String getLabel(){
		return label;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ball [name=");
		builder.append(label);
		builder.append("]");
		return builder.toString();
	}


}
