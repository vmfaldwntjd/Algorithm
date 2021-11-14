from collections import deque
INF = 1e9
flag = True
n, m, k, x = map(int, input().split())
graph = [[] * m for i in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
distance = [INF] * (n + 1)
distance[x] = 0
q = deque([x])

#BFS로 구현
while q:
    n = q.popleft()
    for i in graph[n]:
        if distance[i] == INF:
            distance[i] = distance[n] + 1
            q.append(i)

for i in range(1, len(distance)):
    if distance[i] == k:
        flag = False
        print(i)

if flag:
    print(-1)