package lottery;

public interface Manager {

	void loadDefaultHopper();
//	void loadHopperWithLabeledBalls(List<String> listOfLabels);
	String[] getWinner();
}
