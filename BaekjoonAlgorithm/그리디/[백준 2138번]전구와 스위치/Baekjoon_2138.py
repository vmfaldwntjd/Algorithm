def changeFirst(start, idx): #첫 부분 전구 2개의 스위치를 누르는 메서드 
    if idx == 0:
        for i in range(idx, idx + 2):
            start[i] = '0' if start[i] == '1' else '1'

def changeMid(start, idx): #중간 부분 전구 3개의 스위치를 누르는 메서드
    global n
    if 0 < idx < n:
        for i in range(idx - 1, idx + 2):
            start[i] = '0' if start[i] == '1' else '1'

def changeLast(start, idx): #끝 부분 전구 2개의 스위치를 누르는 메서드
    global n
    if idx == n - 1:
        for i in range(idx, idx - 2, -1):
            start[i] = '0' if start[i] == '1' else '1'

if __name__ == '__main__':
    #입력
    n = int(input())
    start = list(input()) #문자열로 입력
    target = list(input()) #문자열로 입력

    #과정
    #첫 번째 전구를 누른 경우와 그렇지 않은 경우로 나눠서 최솟값을 구하기
    case1 = 0
    case2 = 0
    start_tmp = start[:]

    #첫 번째 전구를 누른 경우
    changeFirst(start_tmp, 0) #첫 번째 전구 누르기
    case1 += 1
    for i in range(1, n):
        if start_tmp[i - 1] != target[i - 1]: #앞의 전구들이 상태가 서로 다르다면
            if 0 < i < n - 1: #현재 위치가 중간이라면 세 개를 바꿔준다.
                changeMid(start_tmp, i)
                case1 += 1
            else: #마지막 전구라면
                if start_tmp[i] != target[i]: #마지막 부분도 다르다면 바꿔주기
                    changeLast(start_tmp, i)
                    case1 += 1
                else: #마지막 부분은 같다면 이는 서로 목표 전구로 만들기 불가능
                    case1 = -1
        else: #그 앞의 전구들은 서로 같고 마지막이 서로 다르다면 -1
            if i == n - 1 and start_tmp[i] != target[i]:
                case1 = -1
                
    #첫 번째 전구를 누르지 않는 경우
    for i in range(1, n):
        if start[i - 1] != target[i - 1]: #앞 전구의 상태가 다르다면
            if 0 < i < n - 1: #중간 부분이라면 세 개를 바꿔준다.
                changeMid(start, i)
                case2 += 1
            else: #마지막 부분이라면 
                if start[i] != target[i]: #서로 다르다면 바꿔주기
                    changeLast(start, i)
                    case2 += 1
                else: #그 앞단이 같다면 이는 목표 전구로 만들기 불가능
                    case2 = -1
        else: #앞 전구의 상태가 같고 마지막 부분이 다르다면 -1
            if i == n - 1 and start[i] != target[i]:
                case2 = -1
    #출력
    if case1 == -1 and case2 != -1:
        print(case2)
    elif case1 != -1 and case2 == -1:
        print(case1)
    else:
        print(min(case1, case2))