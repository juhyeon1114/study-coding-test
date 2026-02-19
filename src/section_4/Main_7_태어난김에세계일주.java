
List<int[]> countryAnswer = new ArrayList<>();
int maxSize = 0;

public void dfs(int balance, int[][] countries, List<int[]> curr, List<Boolean> visited) {
	if (balance >= 0) {
		countryAnswer.addAll(curr);
		maxSize = Math.max(maxSize, curr.size());
	}

	if (!visited.contains(false)) {
		return;
	}

	for (int i = 0; i < countries.length; i++) {
		if (visited.get(i)) {
			continue;
		}
		int requiredPrice = countries[i][1];
		if (requiredPrice > balance) {
			continue;
		}

		visited.set(i, true);
		curr.add(countries[i]);

		dfs(balance - countries[i][0], countries, curr, visited);

		visited.set(i, false);
		curr.remove(curr.size() - 1);
	}
}

public int solution(int balance, int[][] countries) {
	maxSize = 0;
	countryAnswer = new ArrayList<>();
	Boolean[] booleans = new Boolean[countries.length];
	Arrays.fill(booleans, false);
	dfs(balance, countries, new ArrayList<>(), new ArrayList<>(Arrays.asList(booleans)));
	return maxSize;
}

void main() {
	int balance1 = 600;
	int[][] countries1 = {{70, 350}, {100, 550}, {350, 400}};

	int balance2 = 500;
	int[][] countries2 = {{250, 250}, {300, 400}, {120, 450}, {70, 150}};

	int answer1 = solution(balance1, countries1);
	System.out.println(answer1);

	int answer2 = solution(balance2, countries2);
	System.out.println(answer2);

}
