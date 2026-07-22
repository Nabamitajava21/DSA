class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];
        //Nabamita
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }

        boolean[] visited = new boolean[n + 1];

        return dfs(1, graph, visited);
    }

    private int dfs(int node, List<int[]>[] graph, boolean[] visited) {

        visited[node] = true;

        int ans = Integer.MAX_VALUE;

        for (int[] edge : graph[node]) {

            int next = edge[0];
            int dist = edge[1];

            ans = Math.min(ans, dist);

            if (!visited[next]) {
                ans = Math.min(ans, dfs(next, graph, visited));
            }
        }

        return ans;
    }
}
    
