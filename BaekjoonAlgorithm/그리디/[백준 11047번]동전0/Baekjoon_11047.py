if __name__ == '__main__':
    #입력
    #n개의 동전을 사용해서 그 가치 k를 만들고 싶다.
    n, k = map(int, input().split())
    result = 0 #동전 가치를 만들기 위한 동전 개수의 최솟값을 저장할 변수
    coins = list()
    for _ in range(n):
        coins.append(int(input()))
    
    #과정
    coins = sorted(coins, reverse = True)
    for coin in coins:
        if k >= coin:
            result += k // coin
            k -= coin * (k // coin)
    
    #출력
    print(result)
