#입력
n = int(input()) #개수 입력
color = list(input()) #색깔 정보 입력

#과정
#B의 개수와 R의 개수를 구하기 
R_total = color.count("R")
B_total = color.count("B")

#양쪽 끝 색깔을 확인하기
color_first = color[0]
color_last = color[-1]

#양쪽 끝 문자가 같은 경우
if color_first == color_last:
    cnt1 = 1 #이어진 문자의 개수 확인용
    #첫 번째부터 이어진 문자의 개수 확인
    for i in range(1, n):
        if color_first == color[i]:
            cnt1 += 1
        else:
            break
    if color_first == 'B': #첫 번째 색깔이 블루라면
        case1 = B_total - cnt1 #case1이 옮겨야할 색깔의 개수이다.
    else:
        case1 = R_total - cnt1

    #마지막 번째부터 얼마나 이어져 있는지 확인
    cnt2 = 1
    for i in range(n - 2, -1, -1):
        if color_last == color[i]:
            cnt2 += 1
        else:
            break
    if color_last == 'B': #마지막 색깔이 'B'인 경우
        case2 = B_total - cnt2
    else: #마지막 색깔이 'R'인 경우
        case2 = R_total - cnt2

    #출력
    print(min(case1, case2, R_total, B_total)) #이 중에서 최솟값을 출력해야지 옮기는 횟소의 최소가 나온다.

else: #양 쪽 끝 문자가 다른 경우
    cnt1 = 1
    cnt2 = 1
    for i in range(1, n): #왼쪽 끝 문자부터 이어져 있는 문자의 개수 확인
        if color[i] == color_first:
            cnt1 += 1
        else:
            break
    for i in range(n - 2, -1, -1): #오른쪽 끝 문자부터 이어져 있는 문자의 개수 확인
        if color[i] == color_last:
            cnt2 += 1
        else:
            break
    if color_first == 'R': #왼쪽 끝 문자가 레드라면
        case1 = R_total - cnt1
        case2 = B_total - cnt2
    else: #왼쪽 끝 문자가 블루라면
        case1 = B_total - cnt1
        case2 = R_total - cnt2
    
    #출력
    print(min(case1, case2))