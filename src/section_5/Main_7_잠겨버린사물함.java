public int solution(int[][] lockers) {
	int visitCount = 0;
	var visited = new int[lockers.length];

	visit(visited, 0, lockers);

	for (int i = 0; i < visited.length; i++) {
		if (visited[i] == 1)
			visitCount++;
	}

	return lockers.length - visitCount;
}

void visit(int[] visited, int lockerNumber, int[][] lockers) {
	if (visited[lockerNumber] == 1) {
		return;
	}

	System.out.println(lockerNumber + " 방문");
	visited[lockerNumber] = 1;
	int[] nextLockers = lockers[lockerNumber];
	for (int nextLocker : nextLockers) {
		visit(visited, nextLocker, lockers);
	}
}

void main() {
	var lockers1 = new int[][] {{1, 2}, {3}, {}, {0}};
	var lockers2 = new int[][] {{1, 3}, {2, 4}, {0}, {4}, {}, {3, 4}};
	var result = solution(lockers2);
	System.out.println(result);
}
