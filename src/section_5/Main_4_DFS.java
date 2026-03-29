void solution(List<List<Integer>> graph) {
	boolean[] visited = new boolean[graph.size()];
	dfs(0, graph, visited);
}

/**
 * DFS
 * - 스택, 재귀 사용
 */
void dfs(int curr, List<List<Integer>> graph, boolean[] visited) {
	visited[curr] = true;

	for (int next : graph.get(curr)) {
		if (!visited[next]) {
			dfs(next, graph, visited);
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
