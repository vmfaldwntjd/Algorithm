def changeFirst(start, idx):
    if idx == 0:
        for i in range(idx, idx + 2):
            start[i] = '0' if start[i] == '1' else '1'

def changeMid(start, idx):
    global n
    if 0 < idx < n:
        for i in range(idx - 1, idx + 2):
            start[i] = '0' if start[i] == '1' else '1'

def changeLast(start, idx):
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
        if start_tmp[i] != target[i]: #현재 가리키는 부분이 다르다면
            if (0 < i < n - 1) and start_tmp[i - 1] != target[i - 1]: #그리고 그 앞단도 같이 다르다면 바꾼다.
                changeMid(start_tmp, i)
                case1 += 1
            elif i == n - 1:
                if start_tmp[i - 1] != target[i - 1]: #마지막 부분이고 그 앞단도 다르다면 바꿔주기
                    changeLast(start_tmp, i)
                    case1 += 1
                else: #그 앞단이 같다면 이는 목표 전구로 만들기 불가능
                    case1 = -1

        else: #현재 보고 있는 전구 상태가 같다면
            if (0 < i < n - 1) and start_tmp[i - 1] != target[i - 1]:  #같지만 그 앞 전구가 서로 다르다면 바꿔준다.
                changeMid(start_tmp, i)
                case1 += 1
            elif i == n - 1 and start_tmp[i - 1] != target[i - 1]: #그 전구가 마지막이지만 그 앞단이 다르다면 이건 목표 전구로 만들기 불가능
                case1 = -1
    
    #첫 번째 전구를 누르지 않는 경우
    for i in range(1, n):
        if start[i] != target[i]: #현재 가리키는 부분이 다르다면
            if (0 < i < n - 1) and start[i - 1] != target[i - 1]: #그리고 그 앞단도 같이 다르다면 바꾼다.
                changeMid(start, i)
                case2 += 1
            elif i == n - 1:
                if start[i - 1] != target[i - 1]: #마지막 부분이고 그 앞단도 다르다면 바꿔주기
                    changeLast(start, i)
                    case2 += 1
                else: #그 앞단이 같다면 이는 목표 전구로 만들기 불가능
                    case2 = -1

        else: #현재 보고 있는 전구 상태가 같다면
            if (0 < i < n - 1) and start[i - 1] != target[i - 1]:  #같지만 그 앞 전구가 서로 다르다면 바꿔준다.
                changeMid(start, i)
                case2 += 1
            elif i == n - 1 and start[i - 1] != target[i - 1]: #그 전구가 마지막이지만 그 앞단이 다르다면 이건 목표 전구로 만들기 불가능
                case2 = -1
                
    #출력
    if case1 == -1 and case2 != -1:
        print(case2)
    elif case1 != -1 and case2 == -1:
        print(case1)
    else:
        print(min(case1, case2))