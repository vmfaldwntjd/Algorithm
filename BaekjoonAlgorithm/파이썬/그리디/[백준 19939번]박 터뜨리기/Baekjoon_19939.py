if __name__ == '__main__':
    #입력
    n, k = map(int, input().split()) #공의 개수, 팀의 수

    #과정
    #팀 번호당 공을 몇개 담겨 있는지 담을 리스트
    table = [0] * k #팀의 번호 - 1

    #일단은 테이블에 넣을 수 있는 공의 개수를 업데이트
    for i in range(k):
        table[i] = k - i #첫 번째 원소가 최대
                        #마지막 원소가 최소  
        
    if sum(table) > n: #리스트의 합이 n을 넘어가면 -1을 반환
        #출력
        print(-1)
    else:
        n -= sum(table)
        while n: #n이 0이 될 때 종료
            for i in range(k):
                table[i] += 1
                n -= 1
                if n <= 0:
                    break

        #출력
        print(table[0] - table[-1]) #최댓값 - 최솟값 반환