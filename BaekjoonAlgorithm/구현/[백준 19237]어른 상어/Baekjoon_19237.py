def move_shark(board, priority_move, look_direction, shark_info_for_smell, dx, dy):
    n = len(board)
    new_board = [[0] * n for _ in range(n)]
    for x in range(n):
        for y in range(n):
            if board[x][y] != 0: # 만약 상어가 존재하면
                shark_num = board[x][y]
                flag = False
                #네 방향을 돌아보면서 냄새가 없는 곳을 찾아내기
                #마땅한 곳이 없다면 자신의 냄새 쪽으로 이동
                for i in range(4):
                    #우선순위 방향대로 먼저 한번 이동을 해보고 냄새의 존재에 의해서 이동 불가능하면 그 다음 우선순위대로 이동을 해보자
                    nx = x + dx[priority_move[shark_num - 1][look_direction[shark_num - 1] - 1][i] - 1]
                    ny = y + dy[priority_move[shark_num - 1][look_direction[shark_num - 1] - 1][i] - 1]

                    if 0 <= nx and nx < n and 0 <= ny and ny < n:
                        #만약 냄새의 흔적이 없다면 이동하기
                        if shark_info_for_smell[nx][ny][1] == 0:
                            #이동하면 바라보는 방향도 바뀔 것이므로 업데이트
                            look_direction[shark_num - 1] = priority_move[shark_num - 1][look_direction[shark_num - 1] - 1][i]
                            #새로운 보드를 통해서 이미 그 자리로 이동한 상어가 있는지 확인하기
                            if new_board[nx][ny] == 0: #만약 상어가 없다면
                                new_board[nx][ny] = shark_num
                            else: #있다면 번호가 낮은 상어로 업데이트
                                new_board[nx][ny] = min(new_board[nx][ny], shark_num)
                            flag = True #이동 완료
                            break #이동완료했으므로 네 방향 둘러보는 반복문 나가기
                if not flag: #냄새 때문에 이동 불가능하다면 자신의 냄새로 이동하기
                    #다시 네 방향을 둘러보며
                    for i in range(4):
                        nx = x + dx[priority_move[shark_num - 1][look_direction[shark_num - 1] - 1][i] - 1]
                        ny = y + dy[priority_move[shark_num - 1][look_direction[shark_num - 1] - 1][i] - 1]
                        
                        if 0 <= nx and nx < n and 0 <= ny and ny < n:
                            if shark_info_for_smell[nx][ny][0] == board[x][y]: # 만약 이 자리가 냄새를 남겨놓은 자리라면
                                #해당 자리로 이동하기
                                look_direction[shark_num - 1] = priority_move[shark_num - 1][look_direction[shark_num - 1] - 1][i]
                                new_board[nx][ny] = board[x][y]
                                break
    return new_board #새로 이동한 board를 반환하기
                        
                       

# 상어의 냄새 정보를 업데이트하는 함수
def update_smell(board, k, shark_info_for_smell):
    n = len(board)
    for i in range(n):
        for j in range(n):
            #만약 해당 위치에 냄새가 존재한다면 냄새를 1 감소시키기
            if shark_info_for_smell[i][j][1] > 0:
                shark_info_for_smell[i][j][1] -= 1
            if board[i][j] != 0: #상어가 존재하면 그 자리에 정보 업데이트
                shark_info_for_smell[i][j] = [board[i][j], k]

#상어가 1만 남았는지 확인하는 함수
def isOnlyOne(board):
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j] > 1:
                return False
    return True

#메인 함수
if __name__ == "__main__":
    # 입력하기
    #n은 보드의 크기, m은 상어의 개수, k는 상어의 냄새가 남아있는 시간
    n, m, k = map(int, input().split())

    #상어의 번호와 냄새 정보를 담고 있는 리스트 (상어의 번호, 상어의 냄새 시간)
    #리스트 컴프리핸션 사용
    shark_info_for_smell = [[[0] * 2 for _ in range(n)] for i in range(n)]
    board = [] #상어의 번호 정보를 담을 board
    for _ in range(n):
        board.append(list(map(int, input().split())))
    
    #상어의 번호와 냄새 정보를 smell_for_shark에 업데이트 (3차원 리스트로 형성)
    for i in range(n):
        for j in range(n):
            if board[i][j] != 0:
                shark_info_for_smell[i][j][0] = board[i][j]
                shark_info_for_smell[i][j][1] = k
    
    # 각 상어들이 현재 바라보고 있는 방향을 담기 (리스트) -> 이동후 상어들이 바라보고 있는 방향을 수시로 업데이트 해줘야 한다.
    look_direction = list(map(int, input().split()))

    # 각 상어들이 바라보고 있는 방향에 대한 이동 방향 우선순위 리스트를 선언 (3차원 리스트) -> 상하좌우(0, 1, 2, 3)당 우선 방향 정하기
    priority_move = [[[None]] * 4 for _ in range(m)] 
    for i in range(m):
        for j in range(4):
            priority_move[i][j] = list(map(int, input().split()))

    #과정
    #방향 정보를 담고 있는 리스트(상, 하, 좌, 우)
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    t = 0 # 상어가 움직일 때마다 시간을 기록
    while True:
        #이제 보드에 있는 상어를 우선순위에 따라서 이동시키기
        #이동 시킬 때 상어를 잡아먹는 것까지 포함시키기
        #먼저 냄새 정보를 업데이트
        update_smell(board, k, shark_info_for_smell)
        board = move_shark(board, priority_move, look_direction, shark_info_for_smell, dx, dy)
        t += 1 # 상어를 이동시켰으므로 시간 1초 증가

        # t가 1000이 넘었는데도 1이외의 다른 상어가 있다면 -1을 반환하고 반복문 나오기
        if t > 1000:
            print(-1)
            break
        else:
            if isOnlyOne(board):
                print(t)
                break

        
        
