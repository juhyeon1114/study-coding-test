/**
 * Tip
 * - String to char[]: tempString.toCharArray()
 * - tempQueue.push(value): 마지막 요소를 추가
 * - tempQueue.pop(): 마지막 요소를 꺼낸 후, 제거
 * - char 표현 vs String 표현: 'a' vs "a"
 */

/**
 * 접근1: Stack (LIFO, Push & Pop) 활용
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
