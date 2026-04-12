/**
 * 이분 그래프 (Bipartite Graph)
 */

public boolean solution(int[][] friendGraph) {
	var teamMap = new HashMap<Integer, Integer>();

	for (int i = 0; i < friendGraph.length; i++) {
		var currentTeam = teamMap.get(i);
		if (currentTeam == null) {
			currentTeam = 1;
			teamMap.put(i, currentTeam);
		}

		int[] friends = friendGraph[i];
		for (int j = 0; j < friends.length; j++) {
			var result = dfs(currentTeam, friends[j], teamMap);
			if (!result) {
				return false;
			}
		}
	}
	return true;
}

public boolean dfs(int currentTeam, int friendIdx, Map<Integer, Integer> teamMap) {
	var team = teamMap.get(friendIdx);
	if (team == null) {
		teamMap.put(friendIdx, currentTeam == 1 ? 2 : 1);
		return true;
	} else {
		return team != currentTeam;
	}
}

void main() {
	var friends1 = new int[][] {{1}, {2}, {0}};
	var friends2 = new int[][] {{1, 2}, {0, 3}, {0}, {1}};
	boolean solution = solution(friends2);
	System.out.println(solution);
}
