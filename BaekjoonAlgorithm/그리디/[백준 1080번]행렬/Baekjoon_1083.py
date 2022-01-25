def reverse(a, r, c):
    for i in range(r, r - 3, -1):
        for j in range(c, c - 3, -1):
            a[i][j] = '0' if a[i][j] == '1' else '1'
    
if __name__ == "__main__":
    #입력
    n, m = map(int, input().split())
    a = [] #시작 행렬
    b = [] #목표 행렬
    for _ in range(n):
        a.append(list(input())) #시작 행렬을 입력
    for _ in range(n):
        b.append(list(input())) #목표 행렬을 입력

    #과정
    result = 0 #결과 출력용
    flag = True #두 행렬이 같은지 판단
    if n < 3 or m < 3: #3 x 3행렬이 아니고 두 행렬이 다르면 flag를 False로 변환
        if a != b:
            flag = False    
    else:
        for i in range(n - 1, 1, -1):
            for j in range(m - 1, 1, -1):
                if a[i][j] != b[i][j]: #행과 열 하나하나 살펴보면서 (거꾸로 살폈지만 그럴 필요는 없다.)
                    reverse(a, i, j) #다르면 3 x 3 영역을 뒤집어준다.
                    result += 1 #뒤집었으므로 카운트
                        
        if a != b: #뒤집는 과정을 거쳤는데도 다르면 False
            flag = False

    #출력
    if flag:
        print(result)
    else:   
        print(-1)
    

    