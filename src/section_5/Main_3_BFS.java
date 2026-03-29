void solution(List<List<Integer>> graph) {
	boolean[] visited = new boolean[graph.size()];
	bfs(0, graph, visited);
}

/**
 * BFS
 * - 큐 사용
 * - 알고리즘
 * 1. 시작 노드 예약
 * 2. (while) 방문 - 예약
 */
void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
	var queue = new ArrayDeque<Integer>();
	queue.offer(start); // offer(): 큐의 끝에 요소 추가
	visited[start] = true;

	while (!queue.isEmpty()) {
		int current = queue.poll(); // poll(): 큐의 맨 앞 요소를 추출 후, 큐에서는 제거

		for (int neighbor : graph.get(current)) {
			if (!visited[neighbor]) {
				queue.offer(neighbor);
				visited[neighbor] = true;
			}
		}
	}
}

void main() {
	var graph = new ArrayList<List<Integer>>();
	graph.add(List.of(1, 3, 6));
	graph.add(List.of(0, 3));
	graph.add(List.of(3));
	graph.add(List.of(0, 1, 2, 7));
	graph.add(List.of(5));
	graph.add(List.of(4, 6, 7));
	graph.add(List.of(0, 5));
	graph.add(List.of(3, 5));
	solution(graph);
}
