class Solution {
    static boolean[] visited;
    static int[][] computers;

    public int solution(int n, int[][] computers) {
        Solution.computers = computers;
        visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n);
                count++; // 새로운 네트워크 발견
            }
        }

        return count;
    }

    static void dfs(int node, int n) {
        visited[node] = true;

        for (int next = 0; next < n; next++) {
            // 자기 자신 제외, 연결되어 있고, 아직 방문 안 한 노드
            if (next != node && computers[node][next] == 1 && !visited[next]) {
                dfs(next, n);
            }
        }
    }
}
