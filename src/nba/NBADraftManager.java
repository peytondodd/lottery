package nba;

import java.util.List;

import lottery.BallFactory;
import lottery.Hopper;
import lottery.Manager;

public class NBADraftManager implements Manager{
	private Hopper nbaHopper;
	private BallFactory ballFactory;
	int[] seedCounts = {250, 199, 156, 119, 88, 63, 43, 28, 17, 11, 8, 7, 6, 5};

	public NBADraftManager() {
		 nbaHopper = new NBAHopper();
		 ballFactory = new BallFactory();
		 this.loadDefaultHopper();
	}

	public NBADraftManager(List<String> teamNames) {
		nbaHopper = new NBAHopper();
		ballFactory = new BallFactory();
		this.loadHopperWithLabeledBalls(teamNames);
	}


	@Override
	public void loadDefaultHopper() {
		for (int i = 0; i < seedCounts.length; i++) {
			nbaHopper.addBalls( ballFactory.makeBalls(seedCounts[i], "Seed"+(i+1)) );
		}
	}


	public void loadHopperWithLabeledBalls(List<String> teamNames) {
		for (int i = 0; i < seedCounts.length; i++){
			nbaHopper.addBalls( ballFactory.makeBalls(seedCounts[i], teamNames.get(i)) );
		}
	}

	@Override
	public String[] getWinner() {
		NBATeamBall winningBall = (NBATeamBall) nbaHopper.draw();
		String[] results = new String[1];
		results[0] = winningBall.getLabel();
		return results;
	}
}
