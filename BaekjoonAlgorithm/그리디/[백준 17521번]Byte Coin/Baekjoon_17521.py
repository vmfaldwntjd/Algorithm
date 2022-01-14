if __name__ == "__main__":
    #입력
    #n개의 코인, w는 초기 현금
    n, w = map(int, input().split())
    coin_price = list()
    for _ in range(n):
        coin_price.append(int(input()))
    
    #과정
    #증가하는 구간을 찾아서 끝점에는 매수, 끝점에는 매도
    result = w #결과값을 출력할 변수
    idx = 1
    num_of_coins = 0 #매수할 코인의 개수 
    remain = 0 #매수하고 남은 돈
    while True:
        if idx >= n: #코인 리스트 구간을 전부 살폈다면
            if num_of_coins: #매수한 코인이 존재한다면
                result = num_of_coins * coin_price[idx - 1] + remain #결과값을 업데이트
            break
            
        if coin_price[idx] > coin_price[idx - 1]: #현재 구간이 오름차순이라면
            if num_of_coins == 0:
                num_of_coins = result // coin_price[idx - 1] #매수하기
                remain = result % coin_price[idx - 1]
            idx += 1

        else: #내림차순이라면
            if num_of_coins: #매도하기
                result = num_of_coins * coin_price[idx - 1] + remain
                num_of_coins = 0
                remain = 0
            idx += 1 

    #출력
    print(result)


