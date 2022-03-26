if __name__ == "__main__":
    #입력
    s = input()

    #과정
    #10^N 일 때는 N+1개의 M
    #5x10^N일 때는 N개의 M에다가 k를 덧붙이기
    #최댓값이 나오려면 최대한 많은 M개에다가 K를 하나 덧붙이는 쌍이 많아야 한다. 또한 끝자리가 M으로 끝나는 경우에는 M을 전부 따로 분리해서 처리한다.
    #최솟값이 나오려면 M과 K가 따로 분리되어야 한다.
    m_count = 0 # 'M'이 몇 번 나왔는지 카운트 
    k_count = 0 # 'K'가 몇 번 나왔는지 카운트
    mx = '' #최댓값 출력용
    mn = '' #최솟값 출력용

    for i in range(len(s)): #문자열 s를 스캔 
        if s[i] == 'M': #만약 M이라면
            m_count += 1 #'M'을 카운트
            if i == len(s) - 1: #문자열 끝부분이라면
                mx += '1' * m_count  #m뒤에 k가 없이 끝났을 때는 m을 따로 분리해서 계산
                mn += str(pow(10, m_count - 1))
        else: #현재 자리가 'K'라면
            if i == 0: #첫 자리라면
                mn += str(5) #5를 덧붙인다.
            else: #첫 자리가 아니라면
                if m_count == 0: 
                    mn += str(5) #'M'이 카운트된 상태가 아니라면 5를 덧붙인다.
                else: #'M'이 카운트 된 상태라면
                    #'M'과 'K'를 따로 분리해서 처리
                    mn += str(pow(10, m_count - 1)) + str(5) 
            #최댓값 덧붙이기
            mx += str(5 * pow(10, m_count))
            m_count = 0
    
    #출력
    print(mx) #최댓값 출력
    print(mn) #최솟값 출력
