import copy

def turn_clockwise(direction): # 왼쪽으로 45도 회전시키기
    return (direction + 1) % 8

# 해당 번호의 물고기 위치를 찾아주는 함수
def find_fish_pos(board, fish_num):
    for i in range(4):
        for j in range(4):
            #해당 좌표의 물고기 번호가 찾는 번호라면 그 위치를 반환
            if board[i][j][0] == fish_num:
                return (i, j)
    #모든 반복문을 지났는데도 없으면 None을 반환
    return None


# 모든 물고기를 이동시키는 함수 (1번 물고기부터 오름차순으로 이동시키기)
def move_fish(board, shark_x, shark_y):
    global dx, dy
    #물고기의 번호는 1번부터 16번까지
    for i in range(1, 17):
        position = find_fish_pos(board, i)
        
        #해당 번호의 물고기가 존재한다면
        if position != None:
            # 좌표와 그 좌표의 방향 정보를 담고
            pos_x, pos_y = position[0], position[1]
            direction = board[pos_x][pos_y][1]
        
            #그 방향을 파악을 하고 이동이 가능하다면 그 방향에 있는 물고기와 스왑, 방향은 최대 총 8번 확인을 해야
            for j in range(8):
                # 먼저 현재 좌표의 해당 방향으로 이동을 해보기 
                nx = pos_x + dx[direction]
                ny = pos_y + dy[direction]

                #범위 내에 있고, 그곳에 상어가 없거나, 이동할 수 있는 곳인지 확인하기
                if (0 <= nx and nx < 4 and 0 <= ny and ny < 4) and not (nx == shark_x and ny == shark_y):                    
                    #그곳에 상어가 없다면 빈 칸이거나 물고기가 있는 칸이다. -> 번호와 방향을 서로 스왑
                    board[pos_x][pos_y][1] = direction # 바꾼 방향을 업데이트 해주고 바꾸기
                    board[pos_x][pos_y], board[nx][ny] = board[nx][ny], board[pos_x][pos_y]
                    break

                #범위 내에 있지 않거나 상어가 존재한다면 방향 틀기
                direction = turn_clockwise(direction)

# 현재 상어 위치에서 이동 가능한 곳의 좌표를 리스트로 담아서 반환하기
def possible_move_for_shark(board, shark_x, shark_y):
    #현재 상어의 위치에서의 방향을 계속 이동했을 때 물고기가 존재하는 경우를 전부 리스트에 담아서 반환하기
    global dx, dy
    pos_for_shark = []
    direction = board[shark_x][shark_y][1]
    
    # 한쪽 방향으로 스캔할 수 있는 범위의 최댓값은 4
    for i in range(4):
        shark_x += dx[direction]
        shark_y += dy[direction]

        #만약 이 좌표가 범위 내에 있고, 물고기가 있는 자리라면 해당 좌표를 pos_for_shark에 담기
        if (0 <= shark_x and shark_x < 4 and 0 <= shark_y and shark_y < 4) and (board[shark_x][shark_y][0] != 0):
            pos_for_shark.append((shark_x, shark_y))

    return pos_for_shark


# 이동 가능한 상어의 모든 위치를 하나하나 살펴봐서 그 최댓값을 반환하기 -> 이것을 dfs방식을 사용해서 찾아낸다.
def dfs_for_shark_move(board, cur_x, cur_y, total):
    global result
    board = copy.deepcopy(board) # 재귀 호출시 각 재귀 호출된 함수들이 독립적으로 board를 사용하기 위해서 deepcopy사용

    # 현재 좌표에서 물고기를 먹었으므로 total에 물고기 번호를 더해준다. 이러면 물고기를 먹은 상태이다.
    total += board[cur_x][cur_y][0]

    #물고기를 다 먹은 상태이므로 해당 위치에는 아무것도 없으므로 0 처리하기
    board[cur_x][cur_y][0] = 0

    move_fish(board, cur_x, cur_y) #먼저 모든 물고기를 이동시키기

    #상어가 이동가능한 곳을 좌표로 리스트에 저장하기
    pos_for_shark = possible_move_for_shark(board, cur_x, cur_y)

    # 종료조건은 더이상 상어가 움직일 수 있는 곳이 없을 때
    if len(pos_for_shark) == 0:
        result = max(result, total)
        return

    #이동 가능한 곳이 존재한다면 dfs를 통해서 상어의 위치에 따른 결과를 전부 찾아내기
    for cur_x, cur_y in pos_for_shark:
        dfs_for_shark_move(board, cur_x, cur_y, total)


#메인
if __name__ == '__main__':
    # 위부터 반시계방향으로 45도씩 회전하는 방향 좌표
    dx = [-1, -1, 0, 1, 1, 1, 0, -1]
    dy = [0, -1, -1, -1, 0, 1, 1, 1]
    result = 0 # 결과물

    #입력받기
    # 4x4의 2차원 배열을 만들기
    board = [[None] * 4 for _ in range(4)]
    for i in range(4):
        data = list(map(int, input().split()))
        for j in range(4):
            # (물고기 번호, 물고기 방향 정보)를 튜플 형식으로 저장하기 그리고 dx, dy인덱스에 맞춰주기 위해서 방향 정보에 -1을 해주기
            board[i][j] = [data[j * 2], data[j * 2 + 1] - 1]
    
    # 과정
    dfs_for_shark_move(board, 0, 0, 0) #입력 인자는 board와 첫 시작 위치 좌표(0, 0), 그리고 상어의 이동에 따른 물고기 번호의 합 0(처음에는 0이다.)

    # 결과를 출력하기
    print(result)
