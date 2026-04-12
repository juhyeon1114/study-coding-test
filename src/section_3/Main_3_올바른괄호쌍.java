/**
 * 접근1: Stack (LIFO, Push & Pop) 사용
 */
public int solution(String s) {
	int answer = 0;

	var deque = new ArrayDeque<String>();

	for (char c : s.toCharArray()) {
		if (c == '(') {
			deque.push("(");
		} else if (c == '[') {
			deque.push("[");
		} else if (c == '{') {
			deque.push("{");
		} else {
			if (deque.isEmpty()) {
				return -1;
			}

			var popped = deque.pop();

			if (popped == "(" && c == ')') {
				answer++;
			} else if (popped == "[" && c == ']') {
				answer++;
			} else if (popped == "{" && c == '}') {
				answer++;
			} else {
				return -1;
			}
		}
	}

	return deque.isEmpty() ? answer : -1;
}

void main() {

	String s1 = "()[]{}";
	String s2 = "{(([]))[]}";
	String s3 = "([)]";

	int answer1 = solution(s1); // 3
	int answer2 = solution(s2); // 5
	int answer3 = solution(s3); // -1

	System.out.println(answer1);
	System.out.println(answer2);
	System.out.println(answer3);

}
