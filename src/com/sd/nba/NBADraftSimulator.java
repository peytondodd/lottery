package com.sd.nba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class NBADraftSimulator {
	private Map<String, Integer> results = new HashMap<>();

	public static void main(String[] args) {
		NBADraftSimulator simulator = new NBADraftSimulator();
		simulator.runSimulation(1000);
	}

	private void runSimulation(int runs) {
		for (int i = 0; i < runs; i++) {
			NBADraftManager manager = new NBADraftManager();
			String[] winner = manager.getWinner();
			if (results.containsKey(winner)) {
				int teamWins = results.get(winner);
				teamWins++;
				results.put(winner[0], teamWins);
			} else {
				results.put(winner[0], 1);
			}
		}
		printResults(runs);

	}

	public void printResults(int runs) {
		System.out.println("NBA Draft simulated " + runs + " times:");
		System.out.println("*******************************");
		Set<String> teamNames = results.keySet();
		List<String> teamNamesSorted = new ArrayList<>(teamNames);
		Collections.sort(teamNamesSorted,
				Collections.reverseOrder(new TeamWinsComparator(results)));
		for (String teamName : teamNamesSorted) {
			int wins = results.get(teamName);
			System.out.println(teamName + " won the draft " + wins + " times.");
		}
	}
}

class TeamWinsComparator implements Comparator<String> {
	Map<String , Integer> teamsMap;
	public TeamWinsComparator(Map<String, Integer> teamsMap) {
		this.teamsMap = teamsMap;
	}
	@Override
	public int compare(String teamName1, String teamName2) {
		return teamsMap.get(teamName1).compareTo(teamsMap.get(teamName2));
	}

}
