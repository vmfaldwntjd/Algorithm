from itertools import combinations
#입력 받기
#m은 치킨 집을 고를 수 있는 최대 개수이다.
n, m = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))
    
#과정
chick_house = []
house = []

for i in range(n):
    for j in range(n):
        #집의 위치 정보를 담기
        if board[i][j] == 1:
            house.append((i, j))

        #치킨집의 위치 정보를 담기
        elif board[i][j] == 2:
            chick_house.append((i, j))

#치킨집을 선택하는 경우의 수들의 위치 좌표 모음(튜플)
cases = list(combinations(chick_house, m))

#치킨거리의 합을 구하는 함수
def chick_sum(case):
    result = 0
    for hx, hy in house:
        tmp = 1e9
        for cx, cy in case:
            tmp = min(tmp, abs(hx - cx) + abs(hy - cy))
        result += tmp
    return result

tmp = 1e9
for case in cases:
    tmp = min(tmp, chick_sum(case))

#출력
print(tmp)  