class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
          //Nabamita
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        int[] indegree = new int[n];

        int maxEdge = 0;

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            maxEdge = Math.max(maxEdge, e[2]);
        }

        // Topological order
        int[] topo = new int[n];
        int idx = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;

            for (int[] nxt : graph[u]) {
                if (--indegree[nxt[0]] == 0)
                    q.offer(nxt[0]);
            }
        }

        int low = 0;
        int high = maxEdge;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid, graph, topo, online, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int limit,
                          List<int[]>[] graph,
                          int[] topo,
                          boolean[] online,
                          long k) {

        int n = online.length;

        long INF = Long.MAX_VALUE / 4;

        long[] dp = new long[n];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int u : topo) {

            if (dp[u] == INF)
                continue;

            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (int[] e : graph[u]) {

                int v = e[0];
                int w = e[1];

                if (w < limit)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                if (dp[u] + w < dp[v]) {
                    dp[v] = dp[u] + w;
                }
            }
        }

        return dp[n - 1] <= k;
    }
}