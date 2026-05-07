package section_5;

/**
 * Case: 연결된 노드를 빠짐없이 방문
 * - 연결 요소 개수
 * - 경로 존재 여부
 */
class DFS_그래프탐색 {

	public void dfs(int node, int[][] nodes, boolean[] visited) {
		visited[node] = true;

		for (int i = 0; i < nodes.length; i++) {
			if (visited[i]) {
				continue;
			}
			var nextNode = nodes[i][0]; // nodes에서 추출
			dfs(nextNode, nodes, visited);
		}
	}

	public void solution(int[][] nodes) {
		var visited = new boolean[nodes.length];
		dfs(0, nodes, visited);
	}

}
