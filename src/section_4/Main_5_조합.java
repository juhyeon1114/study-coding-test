/**
 * 강의
 */
List<List<Integer>> dfs2(int[] nums, int m, List<Integer> curr, int startIndex) {
	List<List<Integer>> answer = new ArrayList<>();

	if (curr.size() == m) {
		answer.add(new ArrayList<>(curr));
		return answer;
	}

	for (int i = startIndex; i < nums.length; i++) {
		if (curr.contains(nums[i])) {
			continue;
		}
		curr.add(nums[i]);
		answer.addAll(dfs2(nums, m, curr, i + 1));
		curr.remove(curr.size() - 1); // 원상복구
	}

	return answer;
}

/**
 * 직접
 */
List<List<Integer>> dfs(int[] nums, int m, List<Integer> curr, int lastIndex) {
	List<List<Integer>> answer = new ArrayList<>();

	if (curr.size() == m) {
		answer.add(new ArrayList<>(curr));
		return answer;
	}

	for (int i = 0; i < nums.length; i++) {
		if (curr.contains(nums[i]) || i <= lastIndex) {
			continue;
		}
		curr.add(nums[i]);
		lastIndex = i;

		answer.addAll(dfs(nums, m, curr, lastIndex));

		lastIndex = -1;
		curr.remove(curr.size() - 1); // 원상복구
	}

	return answer;
}

/**
 * m개의 원소를 선택하여 순서를 고려하지 않은 2차원 배열을 응답
 */
void main() {

	int[] nums = {1, 2, 3, 4};
	int m = 2;

	List<List<Integer>> answer1 = dfs(nums, m, new ArrayList<>(), -1);
	System.out.println(answer1);

	List<List<Integer>> answer2 = dfs2(nums, m, new ArrayList<>(), 0);
	System.out.println(answer2);

}
