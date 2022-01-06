if __name__ == '__main__':
    #입력
    #a는 초기값, b는 만들어야 하는 값
    a, b = map(int, input().split())
    
    #과정
    result = 0 #결과 담기 용
    #거꾸로 생각을 해보자 B에서 A로 가기
    flag = True #B에서 A로 갈 수 있으면 flag는 True

    while True:
        if b % 10 == 1: #끝자리 수가 1이라면 1을 제외하기
            b //= 10
            result += 1
            
        elif b % 2 == 0: #2로 나누어 떨어지면 2로 나누기
            b //= 2
            result += 1
        else: #둘 다 안된다면 -1을 출력해야한다.
            flag = False
            break

        if b < a: #b가 a보다 작으면 -1을 출력
            flag = False
            break

        elif b == a: #b가 a와 같아졌다면 연산 횟수에다 1 더한 값 출력
            break
    
    #출력
    if flag:
        print(result + 1)
    else:
        print(-1)