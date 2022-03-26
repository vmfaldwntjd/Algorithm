def reverse(lst, r, c):
    for i in range(r + 1):
        for j in range(c + 1):
            if lst[i][j] == '1':
                lst[i][j] = '0'
            else:
                lst[i][j] = '1'

if __name__ == "__main__":
    #입력
    n, m = map(int, input().split())
    lst = []
    #공백을 입력하는게 아니라서 문자열로 입력받음
    for i in range(n):
        s = input()
        lst.append(list(s)) #리스트로 만들어주기
    
    #과정
    #맨 끝부터 스캔하면서 1이 있으면 뒤집어주기
    cnt = 0
    for i in range(n - 1, -1, -1):
        for j in range(m - 1, -1, -1):
            if lst[i][j] == '1':
                reverse(lst, i, j)
                cnt += 1

    #출력
    print(cnt)
    