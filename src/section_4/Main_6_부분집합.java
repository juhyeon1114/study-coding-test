List<List<Integer>> dfs(int[] nums, List<Integer> curr, int startIndex) {
	List<List<Integer>> answer = new ArrayList<>();
	answer.add(new ArrayList<>(curr));

	for (int i = startIndex; i < nums.length; i++) {
		curr.add(nums[i]);
		answer.addAll(dfs(nums, curr, i+1));
		curr.remove(curr.size() - 1);
	}

	return answer;
}

/**
 * nums로 만들 수 있는 모든 부분집합
 */
void main() {

	int[] nums = {1, 2, 3, 4};

	List<List<Integer>> answer1 = dfs(nums, new ArrayList<>(), 0);
	System.out.println(answer1);

}
