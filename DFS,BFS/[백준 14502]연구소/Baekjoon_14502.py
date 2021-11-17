from collections import deque

n, m = map(int, input().split())
#0은 허공, 1은 벽, 2는 바이러스(2의 개수는 2~10)

#입력 받기
board = []
dx = [1, 0, -1, 0] #방향을 나타내는 좌표
dy = [0, 1, 0, -1]

for _ in range(n):
    board.append(list(map(int, input().split())))
board_tmp = [[0] * m for _ in range(n)]
result = 0

#바이러스를 퍼뜨리는 함수 -> 방식은 BFS를 사용하였다.
def virus(tmp, x, y):
    que = deque([(x, y)])
    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if tmp[nx][ny] == 0:
                tmp[nx][ny] = 2
                que.append((nx, ny))

#안전 영역의 크기를 계산하는 함수
def num_of_zero(tmp):
    zeroCnt = 0
    for i in range(n):
        for j in range(m):
            if tmp[i][j] == 0:
                zeroCnt += 1
    return zeroCnt


#과정 -> 울타리 3개를 보드에 배치하는 경우는 dfs방식을 사용
def dfs(cnt):
    global result
    if cnt == 3:
        for i in range(n):
            for j in range(m):
                board_tmp[i][j] = board[i][j]
        for i in range(n):
            for j in range(m):
                if board_tmp[i][j] == 2:
                    virus(board_tmp, i, j)
        result = max(result, num_of_zero(board_tmp))
        return

    for i in range(n):
        for j in range(m):
            if board[i][j] == 0:
                board[i][j] = 1
                cnt += 1 
                dfs(cnt)            
                board[i][j] = 0
                cnt -= 1
            
dfs(0)

#출력
print(result)