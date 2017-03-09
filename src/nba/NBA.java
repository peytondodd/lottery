package nba;

import java.util.Arrays;
import java.util.List;

public class NBA {
	public static void main(String[] args) {
		String[] teams = {"Nuggets", "Rockets", "Super Sonics", "Jazz", "Knicks"
				, "Nets", "Bulls", "Heat", "Wizards", "Timberwolves", "Celtics"
				, "Lakers", "Warriors", "Caveliers"};
		List<String> teamList = Arrays.asList(teams);
		NBADraftManager manager = new NBADraftManager(teamList);
		String[] winner = manager.getWinner();
		System.out.println(winner[0]);
	}
}
