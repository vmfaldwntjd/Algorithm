if __name__ == '__main__':
    #입력
    n = int(input())
    
    #과정
    #짝수인 경우는 1212...2
    #홀수인 경우는 1212...3
    result = []
    if n % 2: #n이 홀수라면
        for i in range(n):
            if i == n - 1:
                result.append(3)
            elif i % 2 == 0:
                result.append(1)
            else:
                result.append(2)
                
    else: #n이 짝수라면
        for i in range(n):
            if i % 2 == 0:
                result.append(1)
            else:
                result.append(2)
    print(*result) 

