class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        //Nabamita
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : invocations)
            graph.get(edge[0]).add(edge[1]);

        boolean[] suspicious = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        suspicious[k] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : graph.get(node)) {
                if (!suspicious[next]) {
                    suspicious[next] = true;
                    q.offer(next);
                }
            }
        }

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    ans.add(i);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i])
                ans.add(i);
        }

        return ans;
    }
}
    
