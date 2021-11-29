from collections import deque
#회전한 경우, 위쪽, 아래쪽, 왼쪽, 오른쪽 모두 리스트에 담을 것이다.
def get_next_pos(pos, board_tmp):
    next_pos = [] # 이동할 수 있는 모든 위치를 담을 리스트 
    dx = [1, -1, 0, 0] # 이동 가능한 경우의 수
    dy = [0, 0, 1, -1]
    pos = list(pos) #집합 자료형이므로 리스트로 변환
    #현재의 위치를 각 좌표별로 쪼갬

    #오류 발생
    p1_x, p1_y, p2_x, p2_y = pos[0][0], pos[0][1], pos[1][0], pos[1][1]

    #현재 상태에서 이동가능한 위치를 전부 담기
    for i in range(4):
        np1_x, np1_y, np2_x, np2_y = p1_x + dx[i], p1_y + dy[i], p2_x + dx[i], p2_y + dy[i]
        #이 해당 위치가 이동할 수 있는 곳이라면 결과 리스트에 담는다.
        if board_tmp[np1_x][np1_y] == 0 and board_tmp[np2_x][np2_y] == 0:
            next_pos.append({(np1_x, np1_y), (np2_x, np2_y)})
    #그리고 현재 상테애서 회전할 수 있는 모든 경우의 수도 담는다.
    #먼저 해당 좌표가 가로로 놓여져 있는 경우 
    if p1_x == p2_x:
        #아래쪽과 위쪽으로 회전하는 경우 둘 다 고려
        for i in (1, -1):
            if board_tmp[p1_x + i][p1_y] == 0 and board_tmp[p2_x + i][p2_y] == 0:                           
                next_pos.append({(p1_x, p1_y), (p2_x + i, p1_y)})
                next_pos.append({(p1_x + i, p2_y), (p2_x, p2_y)})

    #그렇지 않고 현재 상태가 세로로 놓여져 있는 경우
    elif p1_y == p2_y:
        for i in (-1, 1):
            if board_tmp[p1_x][p1_y + i] == 0 and board_tmp[p2_x][p2_y + i] == 0:                
                next_pos.append({(p1_x, p1_y), (p1_x, p2_y + i)})
                next_pos.append({(p2_x, p1_y + i), (p2_x, p2_y)})
    return next_pos

def solution(board):
    n = len(board) #보드의 한 변의 길이 구하기
    #이동하기 쉬우라고 보드의 이동 길이를 
    board_tmp = [[1] * (n + 2) for _ in range(n + 2)]
    visited = []
    for i in range(n):
        for j in range(n):
            board_tmp[i + 1][j + 1] = board[i][j]
    q = deque([({(1, 1), (1, 2)}, 0)]) # 시작 지점과 시간을 큐에 담기
    visited.append({(1, 1), (1, 2)})
    while q:
        pos, answer = q.popleft()
        if (n, n) in pos: #만약 최종 지점이 현재 pos에 존재한다면 결과 반환
            return answer
        
        #이동 가능한 모든 경우를 리스트로 반환
        for next_pos in get_next_pos(pos, board_tmp):
            if next_pos not in visited:
                q.append((next_pos, answer + 1))
                visited.append(next_pos)
    return 0



