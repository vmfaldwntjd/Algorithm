if __name__ == "__main__":
    #입력
    n = int(input())
    met_stk = list(map(int, input().split()))

    #과정
    met_stk.sort() #오름차순으로 정렬
    total = sum(met_stk)
    cost = 0
    for i in met_stk:
        total -= i
        cost += total * i

    #출력
    print(cost)