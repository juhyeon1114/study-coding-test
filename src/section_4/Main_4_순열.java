List<List<Integer>> answer3 = new ArrayList<>();

void dfs3(int[] nums, int m, List<Integer> curr, boolean[] visited) {
	// Base case
	if (curr.size() == m) {
		answer3.add(new ArrayList<>(curr));
		return;
	}

	for (int i = 0; i < nums.length; i++) {
		if (visited[i]) {
			continue;
		}
		curr.add(nums[i]);
		visited[i] = true;
		dfs3(nums, m, curr, visited);
		visited[i] = false;
		int lastIndex = curr.size() - 1;
		curr.remove(lastIndex); // 원상복구
	}
}

List<List<Integer>> dfs2(int[] nums, int m, List<Integer> curr, boolean[] visited) {
	List<List<Integer>> answer = new ArrayList<>();

	// Base case
	if (curr.size() == m) {
		answer.add(new ArrayList<>(curr));
		return answer;
	}

	for (int i = 0; i < nums.length; i++) {
		if (visited[i]) {
			continue;
		}
		curr.add(nums[i]);
		visited[i] = true;
		answer.addAll(dfs2(nums, m, curr, visited));
		visited[i] = false;
		int lastIndex = curr.size() - 1;
		curr.remove(lastIndex); // 원상복구
	}

	return answer;
}

List<List<Integer>> dfs(int[] nums, int m, List<Integer> curr) {
	List<List<Integer>> answer = new ArrayList<>();

	// Base case
	if (curr.size() == m) {
		answer.add(new ArrayList<>(curr));
		return answer;
	}

	for (int i = 0; i < nums.length; i++) {
		if (curr.contains(nums[i])) {
			continue;
		}
		curr.add(nums[i]);
		answer.addAll(dfs(nums, m, curr));
		int lastIndex = curr.size() - 1;
		curr.remove(lastIndex); // 원상복구
	}

	return answer;
}

/**
 * m개의 원소를 선택하여 순서를 고려한 2차원 배열을 응답
 */
void main() {

	int[] nums = {1, 2, 3, 4};
	int m = 2;

	List<List<Integer>> answer1 = dfs(nums, m, new ArrayList<>());
	System.out.println(answer1);

	List<List<Integer>> answer2 = dfs2(nums, m, new ArrayList<>(), new boolean[nums.length]);
	System.out.println(answer2);

	dfs3(nums, m, new ArrayList<>(), new boolean[nums.length]);
	System.out.println(answer3);

}
