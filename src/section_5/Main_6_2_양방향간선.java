/**
 * - edges배열의 각 행 [a, b]는 출발 노드 a에서 도착 노드 b로만 향하는 양방향 간선이 존재함
 * - 그래프의 노드는 총 n개이며, 각각 0부터 n-1까지의 번호를 가짐
 */
int n = 5;
int[][] edges = {
	{0, 1},
	{0, 2},
	{0, 4},
	{1, 3},
	{2, 4},
	{3, 4},
};

List<List<Integer>> createGraph(int[][] edges) {
	var graph = new ArrayList<List<Integer>>();
	for (int i = 0; i < n; i++) {
		graph.add(new ArrayList<>());
	}
	for (int[] edge : edges) {
		int from = edge[0];
		int to = edge[1];
		graph.get(from).add(to);
		graph.get(to).add(from);
	}
	return graph;
}

void main() {
	// 양방향 간선 리스트를 그래프로 변환
	var graph = createGraph(edges);
	System.out.println(graph);
}
