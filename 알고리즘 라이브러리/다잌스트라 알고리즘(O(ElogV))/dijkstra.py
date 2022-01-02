import heapq, sys
input = sys.stdin.readline
INF = int(1e9)

#노드의 개수, 간선의 개수를 입력받기 
n, m = map(int, input().split())
#시작 노드의 번호를 입력받기
start = int(input())
#각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
#용량은 노드의 개수만큼 생성
graph = [[] for _ in range(n + 1)]
#최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n + 1)

#모든 간선의 정보를 입력받기 
for _ in range(m):
    #a번 노드에서 b노드로 가는데 드는 비용은 c이다.
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

#다잌스트라 알고리즘 
def dijkstra(start):
    q = []
    #시작 노드로 가기 위한 최단 경로는 0으로 설정 후 큐에 삽입
    heapq.heappush(q, (0, start))
    distance[start] = 0 #자기 자신과의 거리는 0으로 설정
    while q: #큐가 비어있지 않다면
        #가장 최단 거리가 짧은 노드에 대한 정보를 꺼내기 -> 우선순위로!
        dist, now = heapq.heappop(q)

        #만약 방문되지 않은 노드라면 
        if distance[now] >= dist:
            for i in graph[now]: #현재 노드와 연결된 노드들 중에서
                #시작 노드로부터의 지금까지의 거리 dist와 현재 뽑힌 다음 노드로의 연결 비용 i[1]을 더한 cost
                cost = dist + i[1]
                
                if cost < distance[i[0]]: #만약 이 비용이 현재 시작 노드로부터 현재 노드의 최적의 거리보다 작다면 업데이트
                    distance[i[0]] = cost
                    #업데이트한 노드는 다시 큐에 삽입
                    heapq.heappush(q, (cost, i[0]))

#다잌스트라 알고리즘을 수행
dijkstra(start)

#모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, n + 1):
    #도달할 수 없는 경우 무한으로 출력
    if distance[i] == INF:
        print('INFINITY')
    else:
        print(diatance[i])
        

    
    
