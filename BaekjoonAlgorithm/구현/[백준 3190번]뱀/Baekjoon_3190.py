import sys
from collections import deque

n = int(sys.stdin.readline())
board = [[0] * (n) for _ in range(n)] #nxn의 보드를 생성
x, y = 0, 0
board[x][y] = 1 #뱀의 위치를 1로 설정

#방향의 정보를 나타내는 것들(동남서북) 
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
d = 0 # 첫 방향은 동쪽

q = deque([(0, 0)]) #뱀의 위치 정보를 큐에 담는다.
k = int(sys.stdin.readline())
result = 0 # 게임이 끝난 시간을 기록할 '초' 단위
tms = {} #시간을 인덱스로 두고, 그의 원소를 방향 전환 정보로 담는다.
for _ in range(k):
    #행과 열의 정보 -> 사과의 위치 정보
    a, b = map(int, sys.stdin.readline().split())
    board[a - 1][b - 1] = -1 #사과의 위치를 -1로 표시

l = int(sys.stdin.readline())
for _ in range(l):
    X, c = input().split()
    tms[int(X)] = c #시간과 방향 전환 정보를 사전형으로 등록

#보드의 범위를 벗어나거나 몸에 부딪히면 게임을 종료
#뱀의 몸통이 있는 부분은 큐에 담을 것이다.
def turn(direction, info):
    if info == 'L':
        direction = (direction - 1) % 4
    else:
        direction = (direction + 1) % 4
    return direction

while True:
    #먼저 해당 방향으로 이동시키기
    x = x + dx[d]
    y = y + dy[d]

    #이 좌표가 범위를 벗어나거나 부딪히지 않은 경우라면
    if  (0 <= x < n and 0 <= y < n) and board[x][y] != 1:
        #만약 그 자리에 사과가 있다면 그냥 현재 위치를 큐에만 삽입
        if board[x][y] == -1:
            q.append((x, y)) #머리 부분 추가
            
        else: #사과가 없다면 꼬리를 제거 -> 그리고 그 자리는 다시 0으로 만들어줘야함
            x_tmp, y_tmp  = q.popleft()
            board[x_tmp][y_tmp] = 0
            q.append((x, y)) 
        board[x][y] = 1 #머리부분을 1로 만들기
        result += 1 #시간을 더해준다.
        #이 시간이 사전형 tms에 있는 key와 동일하다면 방향 전환
        if result in tms.keys():
            d = turn(d, tms[result])        

    else: #그렇지 않다면
        result += 1
        break

#최종 결과를 출력
print(result)