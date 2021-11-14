import heapq

#입력
flag = True
n, m, k, x = map(int, input().split())
INF = int(1e9)
graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append((b, 1)) #a에서 b까지의 거리가 1이다.

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist: # 만약 방문한 적이 있는 노드라면
            continue
        for i in graph[now]: #현재 노드와 연결된 노드들 중에서
            cost = dist + i[1]
            if distance[i[0]] > cost:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(x)

for i in range(1, len(distance)):
    if distance[i] == k:
        flag = False
        print(i)

if flag:
    print(-1)