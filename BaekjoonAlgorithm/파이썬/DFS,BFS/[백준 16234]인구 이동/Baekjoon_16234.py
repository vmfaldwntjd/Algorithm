from collections import deque

numbers_of_ally_people = 0 # 연합국을 이루고 있는 인구 수
result = 0 #인구 이동이 며칠동안 일어났는지 담는 변수
not_stop = True
dx = [-1, 0, 1, 0] #위부터 시계방향 순으로
dy = [0, 1, 0, -1]

#입력받기
board = []
n, l, r = map(int, input().split())
board_tmp = [[None] * n for _ in range(n)]
flag = [[True] * n for _ in range(n)] #연합국으로 처리가 되면 더 이상 볼일이 없을 때 False처리를 한다.
for _ in range(n): # 땅에 각 나라마다의 인구수 입력하기
    L = list(map(int, input().split()))
    board.append(L)

#과정
q = deque() # 인접한 국가끼리의 국경선이 열렸을 때 각 국가를 큐에 담을 것이다.
#BFS가 끝난 뒤에는 이 큐는 비어있을 것이다.
q2 = deque() # 연합국의 인구수를 업데이트 한 결과를 입력해 줄 좌표를 담을 공간이다. BFS를 마쳤을 때 연합국가가 최종적으로 여기에 담길 것이다. 

while True:
    if not_stop:
        for i in range(n):
            for j in range(n):
                board_tmp[i][j] = board[i][j]
                flag[i][j] = True

        for i in range(n):
            for j in range(n):
                if flag[i][j]: #살펴보았던 국가가 아니라면
                    q.append((i, j)) #현재 연합국의 위치를 넣어주기
                    numbers_of_ally_people += board[i][j] #연합국의 전체 수에서 현재 국가 수 더하기
                    
                    while q: #큐가 다 비어버리면 연합국 하나가 생성된 것이다.
                        x, y = q.popleft() #큐에 담고 하나하나 돌면서 주어진 조건을 만족한 연합국을 큐에 하나하나 집어넣고 연합국 인구수를 카운트
                        if flag[x][y]: # 연합국 처리되지 않은 국가라면
                            q2.append((x, y)) # 연합국 처리를 해주기
                            flag[x][y] = False #방문 했으므로 False처리
                            

                        for k in range(4):
                            nx = x + dx[k]
                            ny = y + dy[k]

                            #flag[nx][ny] 부분에서 중복되는 것이 있는데 한 번 연합국으로 처리가 된 상태이므로 그것을 False처리를 해야한다.
                            if (nx >= 0 and ny >= 0 and nx < n and ny < n) and ((nx, ny) not in q) and flag[nx][ny] and (l <= abs(board[nx][ny] - board[x][y]) <= r):
                                q.append((nx, ny))
                                numbers_of_ally_people += board[nx][ny]
                                
                    allycnt = len(q2) #연합 국가의 수를 담기
                    update_of_ally_people = numbers_of_ally_people // allycnt #연합 국가의 인구수 업데이트 
                    if allycnt > 1: #연합국가의 수가 한 개 보다 많다면 
                        while q2:
                            x, y = q2.pop()
                            board[x][y] = update_of_ally_people
                    else:                        
                        q2.pop()
                    numbers_of_ally_people = 0
                    
        #이제 전체 영역의(board) 각 나라의 인구 수가 복사된 영역에서의(board_tmp) 각 냐라의 인구 수 와 같지 않으면 
        #인구 이동이 일어난 것이므로 result에 1을 추가
        signal = False
        for i in range(n):
            for j in range(n):
                if board[i][j] != board_tmp[i][j]:
                    signal = True
                    break

                if signal:
                    break

        if signal:
            result += 1 
        else:
            not_stop = False
    else:
        break
          
#출력
print(result)

