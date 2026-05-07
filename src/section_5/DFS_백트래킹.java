package section_5;

/**
 * Case: 모든 경우의 수 탐색
 * - 순열
 * - 조합
 */
class DFS_백트래킹 {

	public void dfs(int[][] nodes, boolean[] visited) {
		// 조건 체크 후 결과 갱신
		for (int i = 0; i < nodes.length; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			dfs(nodes, visited);
			visited[i] = false; // 백트래킹
		}
	}

	public void solution(int[][] nodes) {
		var visited = new boolean[nodes.length];
		dfs(nodes, visited);
	}

}
