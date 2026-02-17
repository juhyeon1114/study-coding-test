/**
 * 접근 1: 완전 탐색
 * - 기능적으로는 정상 동작하지만 시간 복잡도가 너무 큼
 */
int func1(int[] prices, int target) {
	int answer = 0;
	int size = prices.length;

	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			int first = prices[i];
			int second = prices[j];
			if (i == j) {
				continue;
			}

			if ((first + second) == target) {
				System.out.printf("first : %d, second : %d", first, second);
				answer += 1;
			}
		}
	}

	System.out.println(answer);
	return answer;
}

/**
 * 접근2: HashSet 활용
 * - 기능적으로 정상 동작하며, 시간복잡도 O(N)을 갖는 효율적인 로직
 */
int func2(int[] prices, int target) {
	int answer = 0;
	Set<Integer> memo = new HashSet<>();

	for (int i = 0; i < prices.length; i++) {
		int price = prices[i];
		int targetPrice = target - price;
		if (memo.contains(targetPrice)) {
			answer += 1;
		}
		memo.add(price);
	}

	return answer;
}

void main() {
	int[] prices = {4, 1, 9, 7, 5, 3, 16};
	int target = 14;

	int answer = func2(prices, target);
	System.out.printf("answer : %d", answer);

}
