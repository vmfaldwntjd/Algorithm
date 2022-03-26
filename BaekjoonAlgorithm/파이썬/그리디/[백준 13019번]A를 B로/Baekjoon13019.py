if __name__ == "__main__":
    #입력
    a = list(input()) #문자열 A
    b = list(input()) #문자열 B

    #과정
    result = 0
    b_idx = len(b) - 1
    for i in range(len(a) - 1, -1, -1): #문자열 A와 B를 거꾸로 스캔
        if a[i] != b[b_idx]:
            result += 1
        else:
            b_idx -= 1
            if b_idx < 0: #문자열 B의 길이가 A보다 작은 경우에는 반복문 탈출
                break
            
    #두 문자열을 정렬했을 때 같으면 문자열 A를 B로 만드는 것이 가능하다.
    a.sort() 
    b.sort()
    #출력
    if a != b:
        print(-1)
    else:
        print(result)