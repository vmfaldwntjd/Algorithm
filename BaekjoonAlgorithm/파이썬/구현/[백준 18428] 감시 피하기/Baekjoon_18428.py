from collections import deque
#입력
n = int(input())
board = []
for _ in range(n):
    board.append(list(input().split()))

#S: 학생, T: 선생님, O: 장애물
#과정
q = deque()
dx = [0, -1, 0, 1] #좌 상 우 하
dy = [-1, 0, 1, 0]
O_cnt = 0 # 장애물을 카운트할 변수
flag = True # 장애물을 설치할 수 있고 장애물 3개를 설치할 때 감시를 안 당하는지 확인하는 변수
for i in range(n):
    for j in range(n):
        if board[i][j] == 'T':
            q.append((i, j)) #T의 위치를 큐에 삽입
            
while q:
    x, y = q.popleft()
    if flag: # 만약 감시를 당하는 경우이거나, 장애물을 설치할 수 없는 경우가 아니라면
        for i in range(4): # 네 방향을 돌면서 학생이 존재하면 장애물을 설치한다.
            x_tmp = x # 초기 위치를 x_tmp, y_tmp에 저장
            y_tmp = y # x_tmp, y_tmp를 변경하면서 스캔
            nx = x_tmp + dx[i] 
            ny = y_tmp + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue #범위를 벗어나면 다음 방향을 확인
            if board[nx][ny] == 'S': # 초기에 바로 옆에 학생이 존재한다면 장애물 설치 불가 
                flag = False  # 감시를 당할 수 밖에 없는 상황이므로 
                break
            if board[nx][ny] == 'O': # 선생님 바로 옆에 장애물이 존재한다면 다른 방향을 관찰
                continue
            x_tmp = nx # 장애물과 학생이 없는 경우라면 그 방향으로 위치를 업데이트
            y_tmp = ny
                
            while True: #한 쪽 방향을 계속 스캔
                nx = x_tmp + dx[i]
                ny = y_tmp + dy[i]
                if nx < 0 or ny < 0 or nx >= n or ny >= n: #범위 벗어나면 나오고 다른 방향
                    break

                if board[nx][ny] == 'O':
                    break

                if board[nx][ny] == 'S': #학생이 존재한다면
                    board[x_tmp][y_tmp] = 'O' #학생 바로 옆에 장애물을 설치
                    O_cnt += 1 # 장애물을 하나 설치했으므로 카운트
                    if O_cnt > 3: #만약에 장애물 카운트가 3개를 넘어가버리는 상황이라면
                        flag = False # 장애물 3개를 설치했을 때 감시를 당하는 상황이므로
                    break
                x_tmp = nx
                y_tmp = ny

#출력
if flag:
    print('YES')
else:#장애물을 세울 수 없는 경우가 나오거나(선생과 학생이 바로 붙어있는 경우), 장애물을 다 썼는데도 감시를 피할 수 없는 경우
    print("NO")