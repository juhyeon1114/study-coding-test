/**
 * 접근1: Queue를 활용
 */
public int solution(String s) {
	int answer = 0;

	ArrayDeque<String> deque = new ArrayDeque<>();

	for (char c : s.toCharArray()) {
		if (c == '(') {
			deque.push("(");
		} else {
			if (deque.isEmpty()) {
				return -1;
			}
			String popped = deque.pop();
			if (!popped.equals("(")) {
				return -1;
			}
			answer++;
		}
	}

	return deque.isEmpty() ? answer : -1;
}

void main() {
	String s1 = "(()())()";
	String s2 = "((())())";
	String s3 = "((())()";
	String s4 = "())()";
	int solution = solution(s4);
	System.out.println(solution);
}
