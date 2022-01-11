if __name__ == '__main__':
    #입력
    n = int(input())
    
    #과정
    #짝수인 경우는 1212...2
    #홀수인 경우는 1212...3

    #n이 짝수인 경우에는 마지막에 3을 덧붙이지 않는다.
    result = [1, 2] * (n // 2) + ([3] if n % 2 else [])
    print(*result)