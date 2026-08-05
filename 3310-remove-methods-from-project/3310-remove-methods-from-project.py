class Solution:
    def remainingMethods(self, n: int, k: int, invocations: List[List[int]]) -> List[int]:


        #Nabamia
        graph = [[] for _ in range(n)]

        for u, v in invocations:
            graph[u].append(v)

        suspicious = [False] * n

        q = deque([k])
        suspicious[k] = True

        while q:
            node = q.popleft()

            for nxt in graph[node]:
                if not suspicious[nxt]:
                    suspicious[nxt] = True
                    q.append(nxt)

        for u, v in invocations:
            if not suspicious[u] and suspicious[v]:
                return list(range(n))

        ans = []
        for i in range(n):
            if not suspicious[i]:
                ans.append(i)

        return ans