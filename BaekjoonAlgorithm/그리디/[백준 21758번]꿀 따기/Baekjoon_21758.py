if __name__ == '__main__':
    #입력
    n = int(input())
    honey = list(map(int, input().split()))
    
    #과정
    #벌집이 벌들 사이에 있는 경우
    case1 = sum(honey[1:n-1]) + max(honey[1:n-1])

    #벌집이 오른쪽에 있는 경우 -> 오른쪽 끝에 벌집을 놓고, 왼쪽 끝은 벌을 둔 다음, 손해를 최소하 하는 자리에 나머지 벌을 놓으면 된다.
    case2 = left_total = sum(honey[1:n]) #일단 양쪽 끝을 제외한 꿀의 양을 다 더해준다.
    #그리고 나서 나머지 벌을 둘 위치를 하나하나 살펴가면서 최댓값을 찾아나간다.
    left_max = 0
    for i in range(1, n-1):
        left_total -= honey[i] * 2 #두 번 곱해줘서 빼준 이유는 최종적으로 계산할 때 case2와 left_total을 더해줘서 최종값을 도출해낼 것이기 때문에 두 번 곱해줘서 빼줬다. -> 벌이 있는 꿀의 양은 제외하는 것이 된다.
        if left_max < left_total: #이 left_total이 left_max보다 크면 업데이트
            left_max = left_total
        left_total += honey[i] 
    case2 += left_max

    #벌집이 왼쪽에 있는 경우 -> 왼쪽 끝에 벌집을 놓고, 오른쪽 끝에 벌을 둔 상태
    case3 = right_total = sum(honey[0:n-1])
    right_max = 0
    for i in range(n - 2, 0, -1):
        right_total -= honey[i] * 2
        if right_max < right_total:
            right_max = right_total
        right_total += honey[i]
    case3 += right_max

    #출력
    print(max(case1, case2, case3))
