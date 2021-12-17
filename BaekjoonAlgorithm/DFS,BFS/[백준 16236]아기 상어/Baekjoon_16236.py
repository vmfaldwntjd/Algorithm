# BFS방식을 사용
# 먼저 BFS를 통해서 최단 거리를 구했다는 표시를 위해서 arr과 크기가 같은 dist 리스트를 만든다.
# 그리고 그 최단 거리의 dist를 스캔하면서 주어진 조건에 만족하는 찾고자 하는 거리의 최솟값을 일일이 업데이트 그리고 그 최종값을 반환한다.
# 그리고 그 현재 위치로 좌표값을 업데이트
from collections import deque

#최단 거리를 찾아준느 bfs함수
def bfs(n, arr, dx, dy, baby_size, cur_x, cur_y):
    dist = [[-1] * n for i in range(n)] #배열 크기 만큼의 dist 처음에 -1로 초기화
    dist[cur_x][cur_y] = 0 #현재 좌표를 0으로 만들기
    q = deque([(cur_x, cur_y)])
    while q:
        x, y = q.popleft() #x, y를 뽑는다.
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= 0 and nx < n and ny >= 0 and ny < n:
                #만약 방문하지 않은 곳이고 사이즈가 작거나 같은 물고기라면 큐에 넣는다.
                if dist[nx][ny] == -1 and arr[nx][ny] <= baby_size:
                    q.append((nx, ny))
                    dist[nx][ny] = dist[x][y] + 1
    return dist # 현재 아기상어의 위치에서의 이동할 수 있는 곳들의 총 거리를 반환

if __name__ == "__main__":
    n = int(input())
    arr = [] # 상어의 위치 정보를 담을 arr
    INF = int(1e9)

    for _ in range(n):  
        arr.append(list(map(int, input().split())))
    
    #아기 상어의 현재 위치를 찾아주기
    for i in range(n):
        if 9 in arr[i]:
            baby_y = arr[i].index(9)
            baby_x = i
    arr[baby_x][baby_y] = 0 # 현재 아기상어의 위치를 0으로 만든다.
    result = 0 # 결과 출력용
    baby_size = 2 # 처음 아기상어의 크기는 2
    eat_count = 0 # 아기 상어가 먹은 상어의 횟수
    dx = [-1, 0, 1, 0] # 위부터 시계방향 순
    dy = [0, 1, 0, -1]
    
    while True:
        min_dist = INF
        dist = bfs(n, arr, dx, dy, baby_size, baby_x, baby_y) # 이렇게 되면 최소거리만 담은 2차원 리스트를 받는다.
        
        #여기서 arr에서 조건에 만족하는 것들 중 최솟값을 dist를 이용해서 찾아가기
        for i in range(n):
            for j in range(n):
                # dist중에서 arr에서의 조건을 만족한 위치중 최솟값을 갖는 자리를 스캔
                if dist[i][j] != -1 and min_dist > dist[i][j] and 1 <= arr[i][j] and arr[i][j] < baby_size:
                    min_dist = dist[i][j]
                    baby_x = i; baby_y = j

        if min_dist >= INF:
            break
        
        #그 위치를 찾았으면 최솟값을 결과에 더해주기
        result += min_dist
        arr[baby_x][baby_y] = 0 # 카운트 했으므로 이 자리는 0으로 만들기
        eat_count += 1 #먹은 횟수 1증가.
        if eat_count == baby_size:
            baby_size += 1
            eat_count = 0

    print(result)