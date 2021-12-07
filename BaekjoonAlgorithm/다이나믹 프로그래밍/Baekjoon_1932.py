#입력
n = int(input())

#과정
# n X n dp테이블을 생성
dp = []
for i in range(n):
    dp.append(list(map(int, input().split())))

for i in range(1, n):
    for j in range(i + 1):
        if j == 0:
            left_up = 0
        else:
            left_up = dp[i - 1][j - 1]
        
        if j == i:
            up = 0
        else:
            up = dp[i - 1][j]

        dp[i][j] = dp[i][j] + max(up, left_up)

#출력
print(max(dp[n - 1]))