from collections import deque

if __name__ == "__main__":
    #입력
    #모든 바이러스의 번호는 k이하의 자연수
    n, k = map(int, input().split())
    board = []
    q = []
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    for i in range(n):
        board.append(list(map(int, input().split())))
        for j in range(n):
            if board[i][j] != 0:
                q.append((board[i][j], i, j))
    q.sort()
    cnt = 0
    q = deque(q)
    #s초가 지난 후 (x, y)자리를 입력
    s, x, y = map(int, input().split())       

    
    #과정 -> s초까지
    while q:
        if cnt == s:
            break
        #해당 좌표값을 값이 작은 순으로 뽑는다.
        #s초를 지키면서 BFS를 구현해야 한다.
        length = len(q)
        for _ in range(length):
            que = q.popleft() #바이러스 값, 좌표
            for i in range(4): #네 방향을 돌면서
                nx = que[1] + dx[i]
                ny = que[2] + dy[i]
                if nx < 0 or ny < 0 or nx >= n or ny >= n:
                    continue
                if board[nx][ny] != 0:
                    continue
                board[nx][ny] = que[0] #큐 첫 번째 원소에 값을 넣는다.
                q.append((board[nx][ny], nx, ny))           
        cnt += 1
               

    #출력
    print(board[x - 1][y - 1])
    