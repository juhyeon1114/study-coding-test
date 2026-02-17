/**
 * 접근1: 오름차순, 내림차순 문제에서는 단조 스택을 활용한다.
 */
public int[] solution1(int[] weights) {
	int[] answer = new int[weights.length];
	ArrayDeque<int[]> stack = new ArrayDeque<>();

	for (int i = 0; i < weights.length; i++) {
		int weight = weights[i];

		while (!stack.isEmpty() && stack.peek()[1] < weight) {
			var popped = stack.pop();
			int poppedIndex = popped[0];
			answer[poppedIndex] = i - poppedIndex;
		}
		stack.push(new int[] {i, weight});
	}

	return answer;
}

void main() {
	var weights1 = new int[] {25, 23, 31, 28, 25, 25, 27, 29};
	var weights2 = new int[] {45, 42, 50, 48, 46, 52, 49};
	var weights3 = new int[] {79, 76, 73, 65, 65, 59};

	int[] ints = solution1(weights1);
	System.out.println(Arrays.toString(ints));
	ints = solution1(weights2);
	System.out.println(Arrays.toString(ints));
	ints = solution1(weights3);
	System.out.println(Arrays.toString(ints));
}
